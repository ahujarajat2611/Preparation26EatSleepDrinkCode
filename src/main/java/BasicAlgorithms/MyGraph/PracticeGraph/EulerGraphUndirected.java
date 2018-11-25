package BasicAlgorithms.MyGraph.PracticeGraph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 20/10/17.
 */
public class EulerGraphUndirected {
    private int V;
    List<Integer> [] adj;

    public EulerGraphUndirected(int v) {
        V = v;
        adj = new LinkedList[V];

        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int i,int j){
        // since undirected we need to add both ways in adj list
        adj[i].add(j);
        adj[j].add(i);
    }

    void DfsHelper(int v,boolean []visited){
        visited[v] = true;
        for(int w:adj[v]){

            if(!visited[w]){
                DfsHelper(w,visited);
            }
        }
    }


    public boolean isConnected(){
        boolean [] visited = new boolean[V];

        // find a vertex with nonzero degree
        int i=0;
        for(i=0;i<V;i++){
            if(adj[i].size()!=0){
                break;
            }
        }
        if(i == V){

            System.out.println("Fuck all zero edges graph no edges present in this graph");
            return true;
        }

        DfsHelper(i,visited);
        // once visit is done
        // if a node is not visited and adjcency list size is not zero return false

        for(int k=0;k<V;k++){
            if(visited[k] == false && adj[k].size()>0){
                return false;
            }
        }
        return true;
    }
    int isEulerian(){

        if(isConnected() == false){
            return 0;
        }
        // count the odd degree of undirected graph
        int odd=0;
        for(int i=0;i<V;i++){
            if(adj[i].size()%2 ==1){
                odd++;
            }
        }
        if(odd>2){
            return 0;
        }
        // if count is more than 2 than graph can not be suler 
        // in path edhe will repeaat for sureeeeee 
        if(odd == 2){
            // means suler path is there not cycle 
            return 1;
        }
        if(odd == 0){
            // means euler cycle exists
            return 2;
        }
        return 0;
    }
    void test()
    {
        int res = isEulerian();
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
            System.out.println("graph has a Euler cycle");
    }
    public static void main(String args[])
    {
        // Let us create and test graphs shown in above figures
        EulerGraphUndirected g1 = new EulerGraphUndirected(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.test();

        EulerGraphUndirected g2 = new EulerGraphUndirected(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.test();

        EulerGraphUndirected g3 = new EulerGraphUndirected(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        g3.test();

        // Let us create a graph with 3 vertices
        // connected in the form of cycle
        EulerGraphUndirected g4 = new EulerGraphUndirected(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        g4.test();

        // Let us create a graph with all veritces
        // with zero degree
        EulerGraphUndirected g5 = new EulerGraphUndirected(3);
        g5.test();
    }
}
