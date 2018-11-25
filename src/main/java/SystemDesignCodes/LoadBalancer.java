package SystemDesignCodes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 7/10/17.
 */
public class LoadBalancer {

    private class Node{
        int id;
        Node next;
        Node prev;
        Node(int id){
            this.id = id;
            prev = null; // Tricky you got confused as what should be the  value
            next = null;
        }
    }
    Node server;
    Map<Integer,Node> servers;
    LoadBalancer (){
        servers = new HashMap<>();
        server = null;
    }
    public void add(int server_id){
        if(servers.containsKey(server_id)){
            return;
        }
        Node newServer= new Node(server_id);
        if(server == null){
            System.out.println("comig here");
            server = newServer;
            server.next = server;
            server.prev = server;
        }
        else {
            newServer.next = server;
            newServer.prev = server.prev;
            server.prev = newServer;
            newServer.prev.next = newServer;
            server = newServer;
        }
    }
    public void remove(int server_id){
        if(!servers.containsKey(server_id)){
            return;
        }

        Node node = servers.get(server_id);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        servers.remove(server_id);
        if(servers.isEmpty()){
            server = null;
        }
    }

    public int pick(){
       int id =  server.id;
       server = server.next;
       return id;
    }

    public static void main(String args[]){
        LoadBalancer loadBalancer = new LoadBalancer();
        loadBalancer.add(1);
        System.out.println(loadBalancer.server);
        loadBalancer.add(2);
        System.out.println(loadBalancer.server);
        loadBalancer.add(3);
        System.out.println(loadBalancer.server);

        Node ser = loadBalancer.server;
        do{
            System.out.println(ser.id);
            ser = ser.next;
        }while (ser!=loadBalancer.server);
    }
}
