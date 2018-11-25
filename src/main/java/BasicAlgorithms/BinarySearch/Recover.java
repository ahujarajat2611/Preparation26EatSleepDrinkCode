package BasicAlgorithms.BinarySearch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 18/10/17.
 */
public class Recover {

    private class Noderef{
        TreeNode node;
    }
    public void recoverTree(TreeNode root) {
        Noderef firstNode= new Noderef();
        Noderef secondNode = new Noderef();
        Noderef prev = new Noderef();
        prev.node = new TreeNode(Integer.MIN_VALUE);
        inorder(root,firstNode,secondNode,prev);

        if(secondNode.node == null){
            if(firstNode.node!=root){
                secondNode.node = root;
            }
            else {
                secondNode.node = firstNode.node.left!=null?firstNode.node.left:firstNode.node.right;
            }
        }
        int data = firstNode.node.val;
        firstNode.node.val = secondNode.node.val;
        secondNode.node.val = data;
    }

    private void findMin(TreeNode root,AtomicInteger atomicInteger) {
        if(root == null){
            return;
        }
        if(atomicInteger.get()>root.val){
            atomicInteger.set(root.val);
        }
        findMin(root.left,atomicInteger);
        findMin(root.right,atomicInteger);
    }

    private void inorder(TreeNode root, Noderef firstNode, Noderef secondNode,Noderef prev) {
        if(root == null){
            return;
        }

        inorder(root.left,firstNode,secondNode,prev);
        // anomly
        if(root.val<prev.node.val){
            if(firstNode.node == null){
                firstNode.node = prev.node;
            }
            else if(firstNode.node!=null){
                secondNode.node = root;
            }
        }
        prev.node = root;
        inorder(root.right,firstNode,secondNode,prev);
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
}