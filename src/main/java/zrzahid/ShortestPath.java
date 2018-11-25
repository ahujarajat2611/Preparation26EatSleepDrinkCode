package zrzahid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hadoop on 10/9/17.
 */
public class ShortestPath {
    private class Node{
        List<Node> next;

    }
    public List<Node> shortestPath(Node a, Node b){
        if(a == null || b == null) return  null;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node,Node> parent = new HashMap<>();

        // standard BFS
        queue.add(a);
        parent.put(a,null);

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr == b){
                break;
            }
            for(Node n:curr.next){
                if(!parent.containsKey(n)) {
                    queue.add(n);
                    parent.put(n, curr);
                }
            }
        }
        if(parent.get(b) == null) return null;
        List<Node> out = new LinkedList<>();
        Node curr = b;
        while (curr!=null){
            out.add(0,curr);
            curr = parent.get(curr);
        }
        return out;
    }
}
