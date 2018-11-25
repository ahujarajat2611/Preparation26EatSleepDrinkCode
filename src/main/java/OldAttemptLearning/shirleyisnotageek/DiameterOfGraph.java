package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */



/*

Friday, March 27, 2015
Construct tree with minimum weight from an acyclic undirected unweighted graph
 */
/*
Given an acyclic undirected unweighted connected graph, find its representation as a tree with the least height. Brute force is O(n^2). Come up with an O(n) solution
Well, the problem is the same as saying given a tree, find it's root. An acyclic graph, unfortunately, is a tree. The problem is, we don't know where is the root. So the way we do it is to find the diameter of the graph. The diameter of the graph is defined as:

 */
/*
The diameter d of a graph is the maximum
eccentricity of any vertex in the graph.
 That is, d it is the greatest distance
 between any pair of vertices or, alternatively,
 d = \max_{v \in V}\epsilon(v). To find the diameter of a graph,
  first find the shortest path between each pair of vertices.
   The greatest length of any of these paths is the diameter of the graph.

To do it in O(n),
we first randomly select a node from the graph.
find the farthest node it can reach, call it farthest1.

 Then find the farthest node farthest1 can reach, call it farthest2.
 The diameter of the graph is the distance between farthest1 and farthest2.
  The reason it works is that the given graph
  is a tree, so the two farthest nodes will only have one neighbor.
  If not, the we can go farther down find the next farthest node.

So how to find the root?
Given the two farthest nodes,
the root must be in between. so from one node to the other,
 find the middle one. The way I do it is a brutal force one,
 traverse both nodes to the equal distance, then find the common node.
  So the question is,
   is it possible that there exists a second common node on the path?
    The answer is definitely no,
    since the given graph is a tree.

 */

public class DiameterOfGraph {
}
/*
public class Diameter {
 private Graph g;
 public Diameter(Graph g){
  this.g = g;
 }
 public double maxShortestDistance(Node n){
  g.chooseSource(n);
  PriorityQueue<node> pq = new PriorityQueue<node>(new NodeComparator());
  //Set<node> visited = new HashSet<node> ();
  pq.offer(n);
  double maxDist = 0.0;
  while(!pq.isEmpty()){
   Node curr = pq.poll();
   for(Node nei : g.neighbors.get(curr)){
    double distance = g.getEdge(curr.label, nei.label).weight + curr.dist;
    if(distance < nei.dist){
     pq.remove(nei);
     nei.dist = distance;
     pq.offer(nei);
     maxDist = Math.max(maxDist, distance);
    }
   }
  }
  return maxDist;
 }
 public double diameter(){
  double diameter = 0.0;
  for(Node v : g.vertices.values()){
   diameter = Math.max(diameter, maxShortestDistance(v));
  }
  return diameter;
 }
 private class NodeComparator implements Comparator<node>{

  public int compare(Node a, Node b){
   if(a.dist - b.dist > 0)
    return 1;
   else if (a.dist - b.dist < 0)
    return -1;
   return 0;
  }
 }
}
 */

/*
public class ConstructTree {
 UndirectedGraph forest;
 int diameter;
 public ConstructTree(UndirectedGraph g){
  forest = g;
  //System.out.println("Tree built");
 }
 private UndirectedGraphNode getFarthest(UndirectedGraphNode n){
  Queue<undirectedgraphnode> q = new LinkedList<undirectedgraphnode>();
  q.add(n);
  Map<undirectedgraphnode integer=""> distance = new HashMap<undirectedgraphnode integer=""> ();
  distance.put(n, 0);
  //Set<undirectedgraphnode> visited = new HashSet<undirectedgraphnode> ();
  int maxDist = 0;
  //int currDist = 0;
  UndirectedGraphNode farthest = null;
  while(!q.isEmpty()){
   UndirectedGraphNode curr = q.poll();
   int d = distance.get(curr);
   for(UndirectedGraphNode neighbor : curr.neighbors){
    if(!distance.containsKey(neighbor)){
     distance.put(neighbor, d + 1);
     q.offer(neighbor);
    }
   }
  }
  for(Entry<undirectedgraphnode integer=""> e : distance.entrySet()){
   if(e.getValue() > maxDist){
    maxDist = e.getValue();
    farthest = e.getKey();
   }
  }
  diameter = maxDist;
  return farthest;
 }
 private UndirectedGraphNode getRoot(UndirectedGraphNode n1, UndirectedGraphNode n2){
  int d1, d2;
  if(diameter % 2 == 0)
   d1 = d2 = diameter / 2;
  else{
   d1 = diameter / 2;
   d2 = diameter - d1;
  }
  Queue<undirectedgraphnode> q1 = new LinkedList<undirectedgraphnode>();
  q1.add(n1);
  Queue<undirectedgraphnode> q2 = new LinkedList<undirectedgraphnode>();
  q2.add(n2);
  UndirectedGraphNode toReturn = null;
  while(!q1.isEmpty() && d1 > 0){
   UndirectedGraphNode curr = q1.poll();
   for(UndirectedGraphNode nei : curr.neighbors)
    q1.offer(nei);
   d1--;
  }
  while(!q2.isEmpty() && d2 > 0){
   UndirectedGraphNode  curr = q2.poll();
   for(UndirectedGraphNode nei : curr.neighbors)
    q2.offer(nei);
   d2--;
  }
  for(UndirectedGraphNode node1 : q1){
   for(UndirectedGraphNode node2 : q2){
    if (node1 == node2){
     toReturn = node1;
     break;
    }
   }
  }
  return toReturn;
 }

 public UndirectedGraphNode construct(){
  UndirectedGraphNode random = forest.vertices.entrySet().iterator().next().getValue();
  UndirectedGraphNode farthest = getFarthest(random);
  UndirectedGraphNode farthest2 = getFarthest(farthest);
  return getRoot(farthest, farthest2);
 }
}
 */