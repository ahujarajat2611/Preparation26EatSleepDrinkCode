package DSA.trees.binary;

/**
 * Created by hadoop on 22/2/18.
 */
public class PopulateNextPointer1And2 {
    public void updateNextSiblingInConstantSpace(BinaryTreeNodeWithSibling<Integer> root) {
        BinaryTreeNodeWithSibling<Integer> level_start, cur;
        level_start = root;
        while (level_start != null) {
            cur = level_start;
            level_start = level_start.left; // update for next level here
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
        }
    }

    public void updateNextSiblingInConstantSpaceNodesCanBeNull(BinaryTreeNodeWithSibling<Integer> root) {
        BinaryTreeNodeWithSibling<Integer> next_level_start = root; // head of
        // the next
        // level
        BinaryTreeNodeWithSibling<Integer> cur; // current node of
        // current level
        BinaryTreeNodeWithSibling<Integer> prev = null;// the leading node on
        // the next level
        while (next_level_start != null) {
            cur = next_level_start;
            next_level_start = null;
            prev = null;
            while (cur != null) {
                // left child
                if (cur.left != null) {// iterate on the current level
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        // first node in this level so nothing to worry for its left sibliing ..........
                        next_level_start = cur.left;
                    }
                    // as usual prev updates !!!!
                    prev = cur.left;
                    // or could have written prev = prev.next !

                }
                // right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        next_level_start = cur.right;
                    }
                    prev = cur.right;
                }
                // move to next node
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        PopulateNextPointer1And2 obj = new PopulateNextPointer1And2();

        BinaryTreeNodeWithSibling<Integer> completebinarytree_root = obj.createTestAlmostCompleteBinaryTree();
        obj.updateNextSiblingInConstantSpace(completebinarytree_root);
    }
    public BinaryTreeNodeWithSibling<Integer> createTestAlmostCompleteBinaryTree() {
        BinaryTreeNodeWithSibling<Integer> n1 = new BinaryTreeNodeWithSibling<Integer>(1);
        BinaryTreeNodeWithSibling<Integer> n2 = new BinaryTreeNodeWithSibling<Integer>(2);
        BinaryTreeNodeWithSibling<Integer> n3 = new BinaryTreeNodeWithSibling<Integer>(3);
        BinaryTreeNodeWithSibling<Integer> n4 = new BinaryTreeNodeWithSibling<Integer>(4);
        BinaryTreeNodeWithSibling<Integer> n5 = new BinaryTreeNodeWithSibling<Integer>(5);
        BinaryTreeNodeWithSibling<Integer> n6 = new BinaryTreeNodeWithSibling<Integer>(6);
        BinaryTreeNodeWithSibling<Integer> n7 = new BinaryTreeNodeWithSibling<Integer>(7);
        BinaryTreeNodeWithSibling<Integer> n8 = new BinaryTreeNodeWithSibling<Integer>(8);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        return n1;
    }
}

class BinaryTreeNodeWithSibling<T> {
    public T data;
    public BinaryTreeNodeWithSibling<T> left;
    public BinaryTreeNodeWithSibling<T> right;
    public BinaryTreeNodeWithSibling<T> next;

    public BinaryTreeNodeWithSibling() {

    }

    public BinaryTreeNodeWithSibling(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode [data=" + data + "]";
    }

}
