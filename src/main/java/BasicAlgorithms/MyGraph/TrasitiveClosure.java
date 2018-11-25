//package BasicAlgorithms.MyGraph;
//
///**
// * Created by hadoop on 19/10/17.
// */
//
//public class TransitiveClosure {
//    private DepthFirstSearch[] tc;  // tc[v] = reachable from v
//
//    /**
//     * Computes the transitive closure of the digraph {@code G}.
//     *
//     * @param G the digraph
//     */
//    public TransitiveClosure(Digraph G) {
//        tc = new DepthFirstSearch[G.getV()];
//        for (int v = 0; v < G.V(); v++)
//            tc[v] = new DepthFirstSearch(G, v);
//    }
//
//    /**
//     * Is there a directed path from vertex {@code v} to vertex {@code w} in the digraph?
//     *
//     * @param v the source vertex
//     * @param w the target vertex
//     * @return {@code true} if there is a directed path from {@code v} to {@code w},
//     * {@code false} otherwise
//     * @throws IllegalArgumentException unless {@code 0 <= v < V}
//     * @throws IllegalArgumentException unless {@code 0 <= w < V}
//     */
//    public boolean reachable(int v, int w) {
//        validateVertex(v);
//        validateVertex(w);
//        return tc[v].marked(w);
//    }
//
//    // throw an IllegalArgumentException unless {@code 0 <= v < V}
//    private void validateVertex(int v) {
//        int V = tc.length;
//        if (v < 0 || v >= V)
//            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
//    }
//}