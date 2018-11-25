package SystemDesignNodes.ConcurrentConnections;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.*;
import java.io.*;
public class MyServerThread implements Runnable {

  private InputStream in = null;
  private OutputStream out = null;

  public MyServerThread(Socket s) throws Exception{

    in = s.getInputStream();
    out = s.getOutputStream();

    (new Thread(this)).start();
  }

  public void run() {
    //do stuff with **in** and **out** to interact with client
  }
}
class MyServer {

  private static int PORT = 12345;

  public static void main(String args[]) throws Exception {

    ServerSocket s = new ServerSocket(PORT);
    while (true) new MyServerThread(s.accept());

  }
}