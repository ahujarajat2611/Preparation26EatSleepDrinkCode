package Nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hadoop on 9/3/18.
 */
public class SingleThreadedBlockingServer {
    public static void main(String[] args)  throws IOException{
        ServerSocket ss = new ServerSocket(8080);
        while (true){
            handle(ss);
        }

    }

    private static void handle(ServerSocket ss)  {
        InputStream in = null;
        OutputStream out = null;
        Socket s  = null;
        try {
            s = ss.accept(); // never null
            System.out.println("Connecctde to socke"+s);
             in = s.getInputStream();
             out = s.getOutputStream();

            int data;
            while ((data = in.read()) != 0) {
                out.write(transmogrify(data));
                System.out.println("inside ");
            }
            System.out.println("here coming");

        }
        catch (Exception e){
            System.out.println("exception");
        }

        finally {
            try {
                System.out.println("exce");
                out.close();
                in.close();
                s.close();
            }
            catch (Exception e){

            }
        }
    }

    private static int transmogrify(int data) {
        if(Character.isLetter(data)){
            if(Character.isUpperCase(data)){
                return Character.toLowerCase(data);
            }
            else {
                return Character.toUpperCase(data);
            }

        }
        return data;
    }
}
