package BasicAlgorithms.Graph;
import java.util.*;
import java.util.Queue;

public class ConnectedComponent {
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        for (UndirectedGraphNode n: nodes){
            if (set.contains(n)){
                continue;
            }
            bfs(n, set, result);
        }
        return result;
    }
    public void bfs(UndirectedGraphNode n, 
                    HashSet<UndirectedGraphNode> set, 
                    List<List<Integer>> result){
        List<Integer> temp = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(n);
        set.add(n);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            temp.add(current.label);
            for (UndirectedGraphNode i: current.neighbors){
                if (!set.contains(i)){
                    queue.offer(i);
                    set.add(i);
                }
            }
        }
        Collections.sort(temp);
        result.add(temp);
    }
    class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
}
