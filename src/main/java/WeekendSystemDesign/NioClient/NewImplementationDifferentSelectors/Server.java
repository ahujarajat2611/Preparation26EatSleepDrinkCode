/*
https://github.com/zqhxuyuan/kafka-book/blob/8cd13519df75ad74abd34837064f782d04bde7e2/kafka/src/main/scala/base/nio/scalableIO/simple/Server.java

 */
package WeekendSystemDesign.NioClient.NewImplementationDifferentSelectors;

import java.io.IOException;

public class Server {
	
	public static void main(String[] args) throws IOException {
		new Thread(new ServerReactor(9003)).start();
	}
	
}