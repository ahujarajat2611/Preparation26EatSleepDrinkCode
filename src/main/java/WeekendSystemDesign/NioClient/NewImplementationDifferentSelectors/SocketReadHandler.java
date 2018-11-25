package WeekendSystemDesign.NioClient.NewImplementationDifferentSelectors;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;


public class SocketReadHandler extends SocketHandler{
	private SelectionKey selectionKey;
	private  int BLOCK = 4096;    
	private  ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);  
	
	public SocketReadHandler(ServerDispatcher dispatcher, ServerSocketChannel sc, Selector selector) throws IOException{
		super(dispatcher, sc, selector);
	}
	
	@Override
	public void runnerExecute(int readyKeyOps) throws IOException {
		// TODO Auto-generated method stub
		int count = 0;
		if (SelectionKey.OP_READ == readyKeyOps)
		{
            receivebuffer.clear();
            count = socketChannel.read(receivebuffer);   
            if (count > 0) {  
            	System.out.println("Server : Readable.");
            	receivebuffer.flip();  
	            byte[] bytes = new byte[receivebuffer.remaining()];
	            receivebuffer.get(bytes);
	            String body = new String(bytes, "UTF-8"); 
	            System.out.println("Server : Receive :" + body);
	            socketChannel.register(dispatcher.getWriteSelector(), SelectionKey.OP_WRITE);
            }  
		}
	}
}