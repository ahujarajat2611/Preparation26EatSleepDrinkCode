package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class ReconstructTreeFromPreorder {

    //12122 // 2 are leaves and 1 is non-leaf
    ListNode head;
    TreeNode constructTree(){
        if(head == null){
            return null;
        }
        TreeNode node = new TreeNode(head.val);
        head = head.next;
        if(head.next.val == 1){
            node.val =1;
            node.left = constructTree();
            node.right = constructTree();
        }
        else {
            node.val = 2;
            node.left = null;
            node.right = null;
        }
        return node;

    }
    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
    private class ListNode{
        int val;
        ListNode next;
    }

}
