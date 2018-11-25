package WeekendSystemDesign.ReactorPattern;

/**
 * Created by hadoop on 20/3/18.
 */
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
public abstract class AbstractNioChannel {
    private final SelectableChannel channel;
    private final ChannelHandler handler;
    private final Map<SelectableChannel, Queue<Object>> channelToPendingWrites =
            new ConcurrentHashMap<>();
    private NioReactor reactor;

    /**
     * Creates a new channel.
     *
     * @param handler which will handle events occurring on this channel.
     * @param channel a NIO channel to be wrapped.
     */
    public AbstractNioChannel(ChannelHandler handler, SelectableChannel channel) {
        this.handler = handler;
        this.channel = channel;
    }

    /**
     * Injects the reactor in this channel.
     */
    void setReactor(NioReactor reactor) {
        this.reactor = reactor;
    }

    /**
     * @return the wrapped NIO channel.
     */
    public SelectableChannel getJavaChannel() {
        return channel;
    }

    /**
     * The operation in which the channel is interested, this operation is provided to
     * {@link Selector}.
     *
     * @return interested operation.
     * @see SelectionKey
     */
    public abstract int getInterestedOps();

    /**
     * Binds the channel on provided port.
     *
     * @throws IOException if any I/O error occurs.
     */
    public abstract void bind() throws IOException;

    /**
     * Reads the data using the key and returns the read data. The underlying channel should be
     * fetched using {@link SelectionKey#channel()}.
     *
     * @param key the key on which read event occurred.
     * @return data read.
     * @throws IOException if any I/O error occurs.
     */
    public abstract Object read(SelectionKey key) throws IOException;

    /**
     * @return the handler associated with this channel.
     */
    public ChannelHandler getHandler() {
        return handler;
    }

    /*
     * Called from the context of reactor thread when the key becomes writable. The channel writes the
     * whole pending block of data at once.
     */
    void flush(SelectionKey key) throws IOException {
        Queue<Object> pendingWrites = channelToPendingWrites.get(key.channel());
        while (true) {
            Object pendingWrite = pendingWrites.poll();
            if (pendingWrite == null) {
                // We don't have anything more to write so channel is interested in reading more data
                reactor.changeOps(key, SelectionKey.OP_READ);
                break;
            }

            // ask the concrete channel to make sense of data and write it to java channel
            doWrite(pendingWrite, key);
        }
    }

    /**
     * Writes the data to the channel.
     *
     * @param pendingWrite the data to be written on channel.
     * @param key the key which is writable.
     * @throws IOException if any I/O error occurs.
     */
    protected abstract void doWrite(Object pendingWrite, SelectionKey key) throws IOException;

    /**
     * Queues the data for writing. The data is not guaranteed to be written on underlying channel
     * when this method returns. It will be written when the channel is flushed.
     *
     * <p>
     * This method is used by the {@link ChannelHandler} to send reply back to the client. <br>
     * Example:
     *
     * <pre>
     * <code>
     * {@literal @}Override
     * public void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key) {
     *   byte[] data = ((ByteBuffer)readObject).array();
     *   ByteBuffer buffer = ByteBuffer.wrap("Server reply".getBytes());
     *   channel.write(buffer, key);
     * }
     * </code>
     * </pre>
     *
     * @param data the data to be written on underlying channel.
     * @param key the key which is writable.
     */
    public void write(Object data, SelectionKey key) {
        Queue<Object> pendingWrites = this.channelToPendingWrites.get(key.channel());
        if (pendingWrites == null) {
            synchronized (this.channelToPendingWrites) {
                pendingWrites = this.channelToPendingWrites.get(key.channel());
                if (pendingWrites == null) {
                    pendingWrites = new ConcurrentLinkedQueue<>();
                    this.channelToPendingWrites.put(key.channel(), pendingWrites);
                }
            }
        }
        pendingWrites.add(data);
        reactor.changeOps(key, SelectionKey.OP_WRITE);
    }
}
