package BasicAlgorithms.MyGraph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hadoop on 19/10/17.
 */
public class DepthFirstSearchOrders{
    boolean [] marked;
    private int []pre;
    private int []post;
    private LinkedList<Integer> preorder;
    private LinkedList<Integer> postorder;
    private int precounter;
    private int postcounter;

    DepthFirstSearchOrders(Digraph g){
        marked = new boolean[g.getV()];
        pre = new int[g.getV()];
        post = new int[g.getV()];
        preorder = new LinkedList<Integer>();
        postorder = new LinkedList<>();
        for(int i=0;i<g.getV();i++){
            if(!marked[i]){
                dfs(g,i);
            }
        }

    }

    private void dfs(Digraph g, int v) {
        preorder.add(v);
        pre[v]=precounter++;
        marked[v] = true;

        for(int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
        postorder.add(v);
        post[v] = postcounter++;
    }
    public Iterable<Integer> post(){
        return postorder;
    }
    public Iterable<Integer> pre(){
        return preorder;
    }
    // decreasing finish times means Topological sort
    public Iterable<Integer> reversePostOrder(){
        Stack<Integer> stack = new Stack<>();
        for(int v:postorder){
            stack.push(v);
        }
        return stack;
    }
}
