package WeekendSystemDesign.ConnectionPool;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Map;

import java.util.*;
public class SocketPool{
    Map<String,LinkedList<Socket>> sockets;

public boolean establishConnection(String inetServer , int devicePort) throws Exception{
    boolean result = false;
    try {
        Socket clientSocket = new Socket(inetServer, devicePort);
        String socketKey  = inetServer + "-" + devicePort;
        if(clientSocket.isConnected()&&sockets.containsKey(socketKey)){
            sockets.get(socketKey).add(clientSocket);
        }else if(clientSocket.isConnected()&&!sockets.containsKey(socketKey)){
            LinkedList<Socket> socketSet = new LinkedList<Socket>();
            socketSet.add(clientSocket);
            sockets.put(socketKey, socketSet);
        }
        result = true;
    } catch (UnknownHostException e) {
        result = false;
    } catch (IOException e) {
        result = false;
    }
    return result;
}

public Socket fetchSocket(String inetServer , int devicePort){
    String socketKey  = inetServer + "-" + devicePort;
    Socket clientSocket =null;
    if(sockets.containsKey(socketKey)&&!sockets.get(socketKey).isEmpty()){
        clientSocket = sockets.get(socketKey).removeLast();
        int size = sockets.get(socketKey).size();
        if(size==0){
            sockets.remove(socketKey);
        }
    }
        return clientSocket;
}
//other functions
}