package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 22/9/17.
 */
public class TopSort {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
            ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
            //init
            HashMap<DirectedGraphNode,Integer> inDegreeMap = new HashMap<>();
            for(DirectedGraphNode node:graph){
                inDegreeMap.put(node,0);
            }
            //count indegree
            for(DirectedGraphNode directedGraphNode :graph){
                for(DirectedGraphNode neighbournode:directedGraphNode.neighbours){
                    inDegreeMap.put(neighbournode,inDegreeMap.get(neighbournode)+1);
                }
            }
            //Get 0 ingress node
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Queue<DirectedGraphNode> anotherqueue = new LinkedList<>();

        for(DirectedGraphNode directedGraphNode:graph){
                if(inDegreeMap.get(directedGraphNode) ==0){
                    queue.add(directedGraphNode);
                    result.add(directedGraphNode);
                }
            }

        for(HashMap.Entry<DirectedGraphNode,Integer> entry:inDegreeMap.entrySet()){
                if(entry.getValue() ==0){
                    anotherqueue.add(entry.getKey());
                }
        }
        while (!queue.isEmpty()){
                DirectedGraphNode zeroIndegreeNode =queue.poll();
                for(DirectedGraphNode directedGraphNode:zeroIndegreeNode.neighbours){
                    inDegreeMap.put(directedGraphNode,inDegreeMap.get(directedGraphNode)-1);
                    if(inDegreeMap.get(directedGraphNode) == 0){
                        queue.add(directedGraphNode);
                        result.add(directedGraphNode);
                    }
                }
        }

        return result;
    }
    private class DirectedGraphNode{
        int labelNode;
        ArrayList<DirectedGraphNode> neighbours;
    }
}
