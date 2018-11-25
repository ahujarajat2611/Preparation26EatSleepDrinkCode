package BasicAlgorithms.UnionFInd;
import java.util.*;
/*
question is to find connected components in a directed graph. I was thinking at the beginning that it is not impossible to use union find? Because I saw a similar question in the undirected graph to find the connected component is done with BFS. But that question can be done with BFS because it is undirected, that no matter where we publish, we always find all the connection points. And this question is directed graph, if we choose not good point, may not be able to find all the connection points. This seems to involve finding a point of zero. But then the question becomes, This question does not say that there must be zero-degree point, all of the possible presence of circulating direction, for example:
A -> B, B -> C, C -> A
thus caught in no way Find a starting point of the problem. This question is to use union find to do. There are several questions. 1. This question is no longer from 0 to n - 1 points This setting, we are not sure the point of the label's range. So I can not use array to save graph, use hashmap. Of course, the assumption of hashmap is that there is no duplicate label here.
I did not use union find to output all connected component experiences. I want to find all the root first, and then find their children. But such complexity is too high. In fact, very simple, as long as all nodes are traversed, find its root for each node, and then into a hashmap <root, List <child >> on it. The last output when there is a trick is to directly use hashmap.values ​​() to return all List <child>, returns a collection, so you can use for each loop to each list sort, and then into the results inside.
 */
class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
  };

/**
 * Created by hadoop on 7/1/18.
 */
public class ConnectedComponents {
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes){
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        UnionFind uf = new UnionFind(nodes);
        for (DirectedGraphNode node: nodes){
            for (DirectedGraphNode neighbor: node.neighbors){
                uf.connect(node.label, neighbor.label);
            }
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(DirectedGraphNode node: nodes){
            int root = uf.find(node.label);
            List<Integer> list = map.get(root);
            if (list == null){
                list = new ArrayList<Integer>();
            }
            list.add(node.label);
            map.put(root, list);
        }
        for (List<Integer> list: map.values()){
            Collections.sort(list);
            results.add(list);
        }
        return results;
    }
}

class UnionFind {
    HashMap<Integer, Integer> graph;
    HashMap<Integer, Integer> size;

    public UnionFind(ArrayList<DirectedGraphNode> nodes){
        this.graph = new HashMap<Integer, Integer>();
        this.size = new HashMap<Integer, Integer>();
        for (DirectedGraphNode node: nodes){
            this.graph.put(node.label, node.label);
            this.size.put(node.label, 1);
        }
    }

    public void connect(int a, int b){
        int aroot = find(a);
        int broot = find(b);
        if (aroot == broot){
            return;
        }
        int asize = size.get(a);
        int bsize = size.get(b);
        if (asize <= bsize){
            graph.put(aroot, broot);
            size.put(broot, asize + bsize);
        } else {
            graph.put(broot, aroot);
            size.put(aroot, asize + bsize);
        }
    }

    public boolean query(int a, int b){
        return find(a) == find(b);
    }

    public int find(int a){
        while(this.graph.get(a) != a){
            a = this.graph.get(a);
        }
        return a;
    }
}

/*
Find the Weak Connected Component in the Directed Graph
Find the number Weak Connected Component in the directed graph. Each node in the graph contains a label and a list of its neighbors. (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 Notice

Sort the element in the set in increasing order
Have you met this question in a real interview?
Yes
Example
Given graph:
A----->B  C
 \     |  |
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
lintcode This
question is to find connected components in a directed graph. I was thinking at the beginning that it is not impossible to use union find? Because I saw a similar question in the undirected graph to find the connected component is done with BFS. But that question can be done with BFS because it is undirected, that no matter where we publish, we always find all the connection points. And this question is directed graph, if we choose not good point, may not be able to find all the connection points. This seems to involve finding a point of zero. But then the question becomes, This question does not say that there must be zero-degree point, all of the possible presence of circulating direction, for example:
A -> B, B -> C, C -> A
thus caught in no way Find a starting point of the problem. This question is to use union find to do. There are several questions. 1. This question is no longer from 0 to n - 1 points This setting, we are not sure the point of the label's range. So I can not use array to save graph, use hashmap. Of course, the assumption of hashmap is that there is no duplicate label here.
I did not use union find to output all connected component experiences. I want to find all the root first, and then find their children. But such complexity is too high. In fact, very simple, as long as all nodes are traversed, find its root for each node, and then into a hashmap <root, List <child >> on it. The last output when there is a trick is to directly use hashmap.values ​​() to return all List <child>, returns a collection, so you can use for each loop to each list sort, and then into the results inside.
 */

class ConnectedComponentUndirected {
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
}
class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };