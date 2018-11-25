package AwangDevLintCode;
import java.util.*;

/*
	Thoughts:
	Do a BFS.
	Once null occur, all the rest following it has to be null
*/
public class ValidateCompleteTree {

    /**
     * Returns true if binary tree is complete
     *
     * @return true if tree is complete else false.
     */
    public boolean isCompleteSImple(TreeNode root) {
        if (root == null) {
            throw new NoSuchElementException();
        }
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        // watta solution
        // iscompletedetected is fasle ( one variable is enough to deal with all cases )

        boolean incompleteDetected = false;

        // one variable incomplete detected is enough !!
        // incomplete tree is enought once we get null
        // after that we if get non null and this set to true
        // means there is problem !!!
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                if (incompleteDetected) return false;
                queue.add(node.left);
            } else {
                incompleteDetected = true;
            }

            if (node.right != null) {
                if (incompleteDetected) return false;
                queue.add(node.right);
            } else {
                incompleteDetected = true;
            }
        }
        return true;
    }
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag && (node.left != null || node.right != null)) {
                return false;
            }
            // is this condition required i dont think so
            // covered in upper case
            if (node.left == null && node.right != null) {
                return false;
            } else if (node.left == null || node.right == null) {
                flag = true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return true;
    }
}
