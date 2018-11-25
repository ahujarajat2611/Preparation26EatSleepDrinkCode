package WeekendSystemDesign.ConnectionPool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPIPCommunicator {

private final String MODULE="TCPIPCommunicator :";

//private DeviceEntity deviceEntity;
private static InetAddress inetServer = null;
private static int devicePort = -1;
private Socket clientSocket;
private BufferedOutputStream outputStream;
private BufferedInputStream inputStream;
private static boolean isLinkActive = false;
private String IP="";

public TCPIPCommunicator(String IP, int  devicePort) {
    this.IP=IP;
    this.devicePort=devicePort;
    initialize();
}

public static boolean isLinkActive(){
    return isLinkActive;
}

public static void setLinkStatus(boolean status){
    isLinkActive = status;
}

private void initialize() {
    System.out.println(MODULE+ "Inside initialize()" );
    setLinkStatus(false);
    try{
        inetServer = InetAddress.getByName(IP);
    }catch (UnknownHostException uhe) {
        System.out.println(MODULE+ "Error while creating inetaddress, Reason:"+uhe.getMessage());
    }
    System.out.println(MODULE+ "Connecting to - " +inetServer.getHostAddress() + ":" + devicePort);
    establishConnection();

        if(!isLinkActive()){
            //sendNotification(TCPIPConstants.LINK_DOWN);
            releaseResources();
            //resumeLinkSanityHelper();
        }
    System.out.println(MODULE+ "out of initialize(), isLinkActive :" + isLinkActive() );
}

public boolean establishConnection(){
    boolean isConnected = false;
    //Get the Connection to PMS Server.
    if(inetServer != null && devicePort > 0){
        try{
            clientSocket = new Socket(inetServer, devicePort);
            clientSocket.setKeepAlive(true);
        }catch(ConnectException ce){
            ce.printStackTrace();
            setLinkStatus(false);
            System.out.println(MODULE+ "Exception in initialize() " + "Couldnot Connect Server. Reason:"+ce.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            setLinkStatus(false);           
            System.out.println(MODULE+ "Exception in initialize() " + "while creating socket ,Reason: " + e.getMessage());
        }

        //If got connection, Get the streams.
        if(clientSocket != null && !clientSocket.isClosed()){
            System.out.println(MODULE+ "in initialize(), Got Socket Connection." );
            try{
                outputStream = new BufferedOutputStream(clientSocket.getOutputStream());
            }catch(Exception e){
                e.printStackTrace();
                outputStream=null;
                setLinkStatus(false);
                System.out.println(MODULE+ "Exception in initialize() while getting socket outputStream : " + e.getMessage());
            }

            if(outputStream != null){
                try{
                    inputStream = new BufferedInputStream(clientSocket.getInputStream());
                }catch(Exception e){
                    setLinkStatus(false);
                    System.out.println(MODULE+ "Exception in initialize() " + "while getting socket inputStream : " + e.getMessage());
                }
                setLinkStatus(true);
            }
            if(outputStream != null && inputStream != null){
                isConnected = true;
            }
        }else{
            System.out.println(MODULE+ "in initialize(), Connection is closed or null." );
            setLinkStatus(false);
        }
    }
    return isConnected;
}



public int writeData(byte[] msg){
    int retValue = -1;
    try{
        if(isLinkActive() && (outputStream !=null)){
            System.out.println(MODULE+ "Writting data  ::::" + new String(msg)+ "::::");
            outputStream.write(msg);// ed
            outputStream.flush();
            retValue = 1;
        }else{
            System.out.println(MODULE+ " in writeData() link is down so status:" + retValue );
        }
    }catch(Exception e){
        e.printStackTrace();
        retValue = -1;
        System.out.println(MODULE+ "Exception in write() < message to be sent was = " + new String(msg) + " > : " + e.getMessage());
    }
    if(retValue == -1 && isLinkActive()){
        setLinkStatus(false);
        //sendNotification(TCPIPConstants.LINK_DOWN);
        //releaseResources();
        //resumeLinkSanityHelper();
    }
    System.out.println(MODULE+ " in writeData() Write status for ::"+ new String(msg) + ":: -->" +retValue);
    return retValue;
}

public String readData() {
    System.out.println(MODULE+"\tInside readDAta");
    String response = null;
    int bytesReceived=-1;
    byte[] readBuffer = new byte[1024];
    try{
        long timetoread = System.currentTimeMillis();
        if(inputStream == null || !(isLinkActive())){
            System.out.println(MODULE+"Inputstream is null or link is down, returning null");
            return null;
        }

        try{
            System.out.println("Waiting to read data");
            bytesReceived = inputStream.read(readBuffer);
            System.out.println(MODULE+"# Byte Receieved #" + bytesReceived);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(MODULE+"Error in readData() , Reason:"+e.getMessage());
            if(isLinkActive()){
                setLinkStatus(false);
                //sendNotification(TCPIPConstants.LINK_DOWN);
                releaseResources();
                //resumeLinkSanityHelper();
            }
        }
        if(bytesReceived > 0){          
            response = new String(readBuffer,0,bytesReceived); // ed
            timetoread = System.currentTimeMillis() - timetoread;
            System.out.println(MODULE + "Total Bytes Received: " + bytesReceived);
            System.out.println(MODULE+ "Total Time Taken : " + timetoread);
            System.out.println(MODULE+ "Length of data received : " + response.length());
            System.out.println(MODULE+ "Data Received : ####" + response + "####");
        }else{
            ////////// HERE MEANS TCP CONNECTION STATUS WILL CLOSE_WAIT
            ////////// SO RELEASING CONNECTION.
            System.out.println(MODULE+ " Releasing Resource. bytesReceived is <= 0 : Total Bytes Received :"+ bytesReceived );
            if(isLinkActive()){
                setLinkStatus(false);
                //sendNotification(TCPIPConstants.LINK_DOWN);
                releaseResources();
                //resumeLinkSanityHelper();
            }
            System.out.println(MODULE+ " Resource has been released.");
        }
    }catch(Exception e){
        e.printStackTrace();
        System.out.println(MODULE+ "In catch : Data Received : ####" + response + "####");
        System.out.println(MODULE+ "Exception in readdata() : " + e);
    }finally{
        readBuffer=null;
    }
    return response;
}



public void releaseResources(){
    System.out.println(MODULE+ "Releasing Resources....");
    try{
        if(clientSocket !=null)
            clientSocket.close();
    }catch(Exception e){
        System.out.println(MODULE+ "In releaseResources() :Error closing socket."+e.getMessage());
    }
    try{
        if(inputStream !=null )
            inputStream.close();

    }catch(Exception e){
        System.out.println(MODULE+ "In releaseResources() :Error closing inputStream."+e.getMessage());         
    }

    try{
        if(outputStream != null){
            outputStream.close();
        }
    }catch(Exception e){
        System.out.println(MODULE+ "in releaseResources() :Error closing outputStream.");
    }
    System.out.println(MODULE + "Resources Relased...");        
}



}