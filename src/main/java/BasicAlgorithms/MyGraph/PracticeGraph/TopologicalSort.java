package BasicAlgorithms.MyGraph.PracticeGraph;

import java.util.*;

/**
 * Created by hadoop on 20/10/17.
 */
public class TopologicalSort {
    int V;
    List<Integer> []adj;

    public TopologicalSort(int x){
        // nothing but array of list
        // wjhy are you getting confused
        //
        /*
        */
//        Integer []array = new Integer[V];
//        array[0] = new Integer(2);
//        array[1] = new Integer(3);
//
//        Map<String,String> arrayOfMap[] = new Map[];
//        arrayOfMap[0] = new HashMap<>();
//        arrayOfMap[1] = new HashMap<>();
//
//
//        // fucking array of any DS is possible
        this.V = x;

        adj = new List[V];

        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public void addEdge(int i,int j){
        adj[i].add(j);
    }

    public void topologicalSort(){
        int indegree[] = new int[V];

        for(int i=0;i<V;i++){
            for(int node:adj[i]){
                indegree[node]++;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        Vector<Integer> topLogicalOrder = new Vector<>();
        while (!queue.isEmpty()){
            int polled = queue.poll();
            topLogicalOrder.add(polled);
            for(int node:adj[polled]){
                indegree[node]--;
                if(indegree[node] == 0){
                    queue.add(node);
                }
            }

            count++;
        }
        if(count!=V){
            System.out.println("There exist a cycle .. beware not a Dag");
        }

        for(Integer node:topLogicalOrder){
            System.out.print(" "+node);
        }
    }
}
class Main
{
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort g=new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(" rajat Following is a Topological Sort");
        g.topologicalSort();

    }
}
