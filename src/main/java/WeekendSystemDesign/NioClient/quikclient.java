package WeekendSystemDesign.NioClient;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * @author eric
 * 
 * https://www.youtube.com/user/thepoorMechanic
 * 
 * Highly Scalable Server with Java NIO (part 1) https://www.youtube.com/watch?v=nUI4zO6abH0
 * Highly Scalable Server with Java NIO (part 2) https://www.youtube.com/watch?v=AofvCRyvkAk
 *
 */
public class quikclient {

	public static void main(String[] args) throws Throwable {
		Socket s = new Socket("localhost", 1337);

		// time to write to the server
		OutputStream out = s.getOutputStream();
		out.write(55);
		out.write(54);
		out.write(34);
		out.write(23);
		out.write(2);
		out.write(7);
		out.flush();

		// time to read from the server
		InputStream in = s.getInputStream();
		int read = -1;
		while ((read = in.read()) != -1) {
			System.out.println(read);
		}
	}

}