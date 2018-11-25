package SystemDesignNodes.ConcurrentConnections;
//https://stackoverflow.com/questions/9497987/how-many-requests-can-handle-a-port-at-a-time

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
public class ThreadPooledServer implements Runnable{

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;
    protected ExecutorService threadPool =
        Executors.newFixedThreadPool(10);

    public ThreadPooledServer(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    break;
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
            this.threadPool.execute(
                new WorkerRunnable(clientSocket,
                    "Thread Pooled Server"));
        }
        this.threadPool.shutdown();
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }

    public static void main(String[] args) {
        ThreadPooledServer server = new ThreadPooledServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
       // server.stop();
    }
}


class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            System.out.println(input.read());
            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
                    this.serverText + " - " +
                    time +
                    "").getBytes());
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}
/*
This text describes a simple thread pooled server implemented in Java. The code is based on the multithreaded server desbribed in the text on Multithreaded Servers. The main difference is the server loop. Rather than starting a new thread per incoming connection, the connection is wrapped in a Runnable and handed off to a thread poool with a fixed number of threads. The Runnable's are kept in a queue in the thread pool. When a thread in the thread pool is idle it will take a Runnable from the queue and execute it.

Note: Thread pools are discussed in more detail in the text Thread Pools.

Here is how the server loop looks in the thread pooled edition (the full code is shown at the bottom of this text):

    while(! isStopped()){
         Socket clientSocket = null;
         try {
             clientSocket = this.serverSocket.accept();
         } catch (IOException e) {
             if(isStopped()) {
                 System.out.println("Server Stopped.") ;
                 break;
             }
             throw new RuntimeException(
                "Error accepting client connection", e);
         }

            this.threadPool.execute(
            new WorkerRunnable(clientSocket, "Thread Pooled Server"));

     }

The only change in the loop from the multithreaded server to here is the code in bold:

this.threadPool.execute(
   new WorkerRunnable(clientSocket, "Thread Pooled Server"));
Rather than starting a new thread per incoming connection, the WorkerRunnable is passed to the thread pool for execution when a thread in the pool becomes idle.

Here is the code for the WorkerRunnable class, which is passed to the worker thread constructor:
 Apache MINA is a network application framework which helps users develop high performance and high scalability network applications easily. It provides an abstract ·event-driven · asynchronous API over various transports such as TCP/IP and UDP/IP via Java NIO.
 100,000 concurrent connections should be easily possible in Java if you use something like Netty.

You need to be able to:

Accept incoming connections fast enough. The NIO framework helps enormously here, which is what Netty uses internally. There is a smallish queue for incoming requests, so you need to be able to handle these faster than the queue can fill up.
Create connections for each client (this implies some memory overhead for things like connection info, buffers etc.) - you may need to tweak your VM settings to have enough free memory for all the connections
See this article from 2009 where they discuss achieving 100,000 concurrent connections with about 20% CPU usage on a quad-core server.




I am creating a web application having a login page , where number of users can tries to login at same time. so here I need to handle number of requests at a time.

I know this is already implemented for number of popular sites like G talk.

So I have some questions in my mind.

"How many requests can a port handle at a time ?"

How many sockets can I(server) create ? is there any limitations?

For e.g . As we know when we implement client server communication using Socket programming(TCP), we pass 'a port number(unreserved port number)to server for creating a socket .

So I mean to say if 100000 requests came at a single time then what will be approach of port to these all requests.

Is he manitains some queue for all these requests , or he just accepts number of requests as per his limit? if yes what is handling request limit size of port ?

Summary: I want to know how server serves multiple requests simultaneously?I don't know any thing about it. I know we are connection to a server via its ip address and port number that's it. So I thought there is only one port and many request come to that port only via different clients so how server manages all the requests?

This is all I want to know. If you explain this concept in detail it would be very helpful. Thanks any way.







A port doesn't handle requests, it receives packets. Depending on the implementation of the server this packets may be handled by one or more processes / threads, so this is unlimited theoretically. But you'll always be limited by bandwith and processing performance.

If lots of packets arrive at one port and cannot be handled in a timely manner they will be buffered (by the server, the operating system or hardware). If those buffers are full, the congestion maybe handled by network components (routers, switches) and the protocols the network traffic is based on. TCP for example has some methods to avoid or control congestion: http://en.wikipedia.org/wiki/Transmission_Control_Protocol#Congestion_control




This is typically configured in the application/web server you are using. How you limit the number of concurrent requests is by limiting the number of parallel worker threads you allow the server to spawn to serve requests. If more requests come in than there are available threads to handle them, they will publish to queue up. This is the second thing you typically configure, the socket back-log size. When the back-log is full, the server will publish responding with "connection refused" when new requests come in.



Then you'll probably be restricted by number of File Descriptors your os supports (in case of *nix) or the number of simultaneous connections your webserver supports. The OS maximum on my machine seems to be 75000.
https://stackoverflow.com/questions/9497987/how-many-requests-can-handle-a-port-at-a-time
 */

/*
A limit on the number of open sockets is configurable in the /proc file system

cat /proc/sys/fs/file-max
Max for incoming connections in the OS defined by integer limits.

Linux itself allows billions of open sockets.

To use the sockets you need an application listening, e.g. a web server, and that will use a certain amount of RAM per socket.

RAM and CPU will introduce the real limits. (modern 2017, think millions not billions)

1 millions is possible, not easy. Expect to use X Gigabytes of RAM to manage 1 million sockets.

Outgoing TCP connections are limited by port numbers ~65000 per IP. You can have multiple IP addresses, but not unlimited IP addresses. This is a limit in TCP not Linux.


72
down vote
I achieved 1600k concurrent idle socket connections, and at the same time 57k req/s on a Linux desktop (16G RAM, I7 2600 CPU). It's a single thread http server written in C with epoll. Source code is on github, a blog here.

Edit:

I did 600k concurrent HTTP connections (client & server) on both the same computer, with JAVA/Clojure . detail info post, HN discussion: http://news.ycombinator.com/item?id=5127251

The cost of a connection(with epoll):

application need some RAM per connection
TCP buffer 2 * 4k ~ 10k, or more
epoll need some memory for a file descriptor, from epoll(7)
Each registered file descriptor costs roughly 90 bytes on a 32-bit kernel, and roughly 160 bytes on a 64-bit kernel.
https://stackoverflow.com/questions/651665/how-many-socket-connections-possible
 */