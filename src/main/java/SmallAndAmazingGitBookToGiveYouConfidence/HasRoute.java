package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 22/9/17.
 */
public class HasRoute {
    HashSet<DirectedGraphNode> hashSet = new HashSet<>();
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        return dfsHelper(s,t,graph);
    }

    private boolean dfsHelper(DirectedGraphNode s, DirectedGraphNode t, ArrayList<DirectedGraphNode> graph) {
        if(s == t){
            return true;
        }

        hashSet.add(s);
        for(DirectedGraphNode directedGraphNode :s.neighbor){
            if(!hashSet.contains(directedGraphNode)){
                if(dfsHelper(directedGraphNode,t,graph)){
                    return true;
                }
            }
        }
        return false;
    }

    private class DirectedGraphNode{
        int label;
        ArrayList<DirectedGraphNode> neighbor;
    }
    private boolean bfsHelper(ArrayList<DirectedGraphNode> graphNodes,DirectedGraphNode start,DirectedGraphNode end){

        if(start == end){
            return true;
        }
        HashSet<DirectedGraphNode> bfsSet = new HashSet<>();
        Queue<DirectedGraphNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(start);
        bfsSet.add(start);
        while(!bfsQueue.isEmpty()){
            DirectedGraphNode polled = bfsQueue.poll();
            if(polled == end){
                return true;
            }
            for(DirectedGraphNode node:polled.neighbor){
                if(!bfsSet.contains(node)){
                    bfsSet.add(node);
                    bfsQueue.add(node);
                }
            }
        }
        return false;
    }
}
