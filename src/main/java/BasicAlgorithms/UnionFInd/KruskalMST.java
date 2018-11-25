/**
 * 
 */
package BasicAlgorithms.UnionFInd;

import java.util.*;


/**
 * @author Raj
 *
 */
public class KruskalMST {
	private static class Edge{
		int v1;
		int v2;
		int weight;

		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge{" +
					"v1=" + v1 +
					", v2=" + v2 +
					", weight=" + weight +
					'}';
		}
	}
	private static class Graph{
		HashMap<Integer,HashSet<Integer>> adj;
		HashMap<Integer,HashSet<Edge>> adj2 = new HashMap<>();
		Set<Edge> getEdges(){
			HashSet<Edge> allEdges = new HashSet<>();
			for(HashSet<Edge> edge:adj2.values()){
				allEdges.addAll(edge);
			}
			return allEdges;
		}
		Set<Integer> getVertices(){
			return adj2.keySet();
		}
		void addEdge(int u,int v,int weight){
			if(!adj2.containsKey(u)){
				adj2.put(u,new HashSet<>());
			}
			adj2.get(u).add(new Edge(u,v,weight));
		}
	}
	public List<Edge> kruskalMST(Graph graph) {
		List<Edge> result = new ArrayList<>();
		DisjointSet<Integer> ds = new DisjointSet();

		for (int v : graph.getVertices()) {
			ds.makeset(v);
		}

		List<Edge> edges = new ArrayList<>(graph.getEdges());
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});

		for (Edge e : edges) {
			int parent1 = ds.findsetid(e.v1);
			int parent2 = ds.findsetid(e.v2);
			if (parent1 == parent2) {
				continue;
			}
			ds.Union(parent1, parent2);
			result.add(e);
			if (result.size() == graph.getVertices().size() - 1) {
				break;
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 5, 1);
		graph.addEdge(2, 6, 3);
		graph.addEdge(2, 4, 2);
		graph.addEdge(6, 5, 2);
		graph.addEdge(6, 4, 3);
		graph.addEdge(4, 7, 2);
		graph.addEdge(3, 4, 5);
		graph.addEdge(3, 7, 8);
		graph.addEdge(7, 1, 8);
		graph.addEdge(5, 1, 8);

		KruskalMST obj = new KruskalMST();
		List<Edge> result = obj.kruskalMST(graph);
		System.out.println(result);
		System.out.println(graph.getVertices());
	}

}
