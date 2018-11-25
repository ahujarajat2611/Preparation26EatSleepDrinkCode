package BasicAlgorithms.BinaryTree;

/**
 * Created by hadoop on 26/10/17.
 */
import java.util.*;
public class PrintKdistanceNodeApart {
    private class Node{
        Node left;
        Node right;
        int data;
    }


    void printkdistanceNodeDown(Node root, int k)
    {
        // Base Case
        if (root == null || k < 0)  return;

        // If we reach a k distant node, print it
        if (k==0)
        {
            System.out.println(root.data);
            return;
        }

        // Recur for left and right subtrees
        printkdistanceNodeDown(root.left, k-1);
        printkdistanceNodeDown(root.right, k-1);
    }

    // Prints all nodes at distance k from a given target node.
// The k distant nodes may be upward or downward.  This function
// Returns distance of root from target node, it returns -1 if target
// node is not present in tree rooted with root.
    int printkdistanceNode(Node root, Node target , int k)
    {
        // Base Case 1: If tree is empty, return -1
        if (root == null) return -1;

        // If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if (root == target)
        {
            printkdistanceNodeDown(root, k);
            return 0;
        }

        // Recur for left subtree
        int dl = printkdistanceNode(root.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1)
        {
            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from target
            if (dl + 1 == k)
                System.out.println(root.data);

            // Else go to right subtree and print all k-dl-2 distant nodes
            // Note that the right child is 2 edges away from left child
         else
            printkdistanceNodeDown(root.right, k-dl-2);

            // Add 1 to the distance and return value for parent calls
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left subtree
        int dr = printkdistanceNode(root.right, target, k);
        if (dr != -1)
        {
            if (dr + 1 == k)
                System.out.println(root.data) ;
         else
            printkdistanceNodeDown(root.left, k-dr-2);
            return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
    }
    void kDistantFromLeafUtil(Node node, int path[], boolean visited[],
                              int pathLen, int k)
    {
        // Base case
        if (node==null) return;

        // append this Node to the path array
        path[pathLen] = node.data;
        visited[pathLen] = false;
        pathLen++;

        // it's a leaf, so print the ancestor at distance k only
        // if the ancestor is not already printed
        if (node.left == null && node.right == null &&
                pathLen-k-1 >= 0 && visited[pathLen-k-1] == false)
        {
            System.out.print(path[pathLen-k-1] + " ");
            visited[pathLen-k-1] = true;
            return;
        }

        // If not leaf node, recur for left and right subtrees
        kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
        kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
    }

    // Given a binary tree and a nuber k, print all nodes that are k
//   distant from a leaf
    void printKDistantfromLeaf(Node node, int k)
    {
        int MAX_HEIGHT = Integer.MAX_VALUE;
        int[] path = new int[MAX_HEIGHT];
        boolean[] visited = new boolean[MAX_HEIGHT];
        //all the elements false in visited
        Arrays.fill(visited, false);
        kDistantFromLeafUtil(node, path, visited, 0, k);
    }
}
