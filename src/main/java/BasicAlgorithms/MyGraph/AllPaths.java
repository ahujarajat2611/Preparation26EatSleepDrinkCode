package BasicAlgorithms.MyGraph;
import java.util.*;

public class AllPaths {
    private boolean[] marked;        // vertices in current path
    private Stack<Integer> path;     // the current path
    private int numberOfPaths;       // number of simple path

    // show all simple paths from s to t - use DFS
    public AllPaths(Graph g, int s, int t) {
        marked = new boolean[g.getV()];
        path   = new Stack<Integer>();
        dfs(g, s, t);
    }


    // use DFS
    // parent usage is not required in this case
    private void dfs(Graph G, int v, int t) {

        // add v to current path
        path.push(v);
        marked[v] = true;

        // found path from s to t
        if (v == t) {
            processCurrentPath();
            numberOfPaths++;
            // with dfs we can calcultae number of paths as well print all paths as well
            // we could have choosen to return this value as well
        }

        // consider all neighbors that would continue path with repeating a node
        else {
            for (int w : G.adj(v)) {
                if (!marked[w])
                    dfs(G, w, t);
            }
        }

        // done exploring from v, so remove from path
        path.pop();
        marked[v] = false;
        // backtracking at parent level
        // usually i prefet backtracking at child level
        // check if child is valid go ahead apply recursion
        // and post recusion backtracking
    }

    // this implementation just prints the path to standard output
    private void processCurrentPath() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : path)
            reverse.push(v);
        if (reverse.size() >= 1)
            System.out.println(reverse.pop());
        while (!reverse.isEmpty())
            System.out.println("-" + reverse.pop());
        System.out.println();
    }

    // return number of simple paths between s and t
    public int numberOfPaths() {
        return numberOfPaths;
    }




}
