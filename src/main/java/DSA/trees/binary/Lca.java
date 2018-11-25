package DSA.trees.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 10/9/17.
 */
public class Lca {
    private class Node{
        int val;
        Node left;
        Node right;
    }
    public Node lca(Node tree, Node n1, Node n2) {
        if (n1.equals(n2)) return n1;

        Stack<Node> pathToN1 = pathTo(tree, n1);
        Stack<Node> pathToN2 = pathTo(tree, n2);
        if (pathToN1 == null || pathToN2 == null) return null;

        Node prev = null;
        while (!pathToN1.isEmpty() && !pathToN2.isEmpty()) {
            Node s = pathToN1.pop();
            Node t = pathToN2.pop();
            if (s.equals(t)) prev = s;
            else break;
        }

        return prev;
    }
    
    public List<Node> pathMine(Node tree, Node n){
        if(tree == null){
            return null;
        }
        if(tree == n){
            List<Node> list = new ArrayList<>();
            list.add(tree);
            return list;
        }
        List<Node> left = pathMine(tree.left,n);
        
        if(left!=null){
            left.add(0,tree);
            return left;
        }
        List<Node> right = pathMine(tree.right,n);
        if(right!=null){
            right.add(0,tree);
            return right;
        }
        return null;
    }

    public Stack<Node> pathTo(Node tree, Node n) {
        if (tree == null) return null;
        if (tree.equals(n)) {
            // if we want path from the list
            // what a solution it is fuck
            // you need to keep this in mind
            // either top to down you keep tean
            // or bottom to top ( here it is bottom to top)
            Stack<Node> s = new Stack<Node>();
            s.push(tree);
            return s;
        }

        Stack<Node> left = pathTo(tree.left, n);
        Stack<Node> right = pathTo(tree.right, n);

        if (left != null) {
            left.push(tree);
            return left;
        }

        if (right != null) {
            right.push(tree);
            return right;
        }

        return null;
    }
}
