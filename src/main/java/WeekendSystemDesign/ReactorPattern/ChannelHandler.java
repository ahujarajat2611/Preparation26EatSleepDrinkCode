package WeekendSystemDesign.ReactorPattern;

import java.nio.channels.SelectionKey;

public interface ChannelHandler {

  /**
   * Called when the {@code channel} receives some data from remote peer.
   * 
   * @param channel the channel from which the data was received.
   * @param readObject the data read.
   * @param key the key on which read event occurred.
   */
  void handleChannelRead(AbstractNioChannel channel, Object readObject, SelectionKey key);
}