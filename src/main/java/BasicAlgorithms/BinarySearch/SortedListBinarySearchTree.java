package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class SortedListBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
    int sizeoflist = getsize(head)  ;
        NodeRef noderef = new NodeRef();
        noderef.node = head;
        return listtotree(0,sizeoflist-1,noderef);
    }

    private TreeNode listtotree(int start, int end,NodeRef nodeRef) {
        if(start>end){
            return null;
        }

        if(start == end){
            TreeNode root = new TreeNode(nodeRef.node.val);
            nodeRef.node = nodeRef.node.next;
            return root;
        }

        int mid = start+end/2;

        TreeNode  left = listtotree(start,mid-1,nodeRef);

        TreeNode root = new TreeNode(nodeRef.node.val);
        nodeRef.node = nodeRef.node.next;

        TreeNode right = listtotree(mid+1,end,nodeRef);

        root.left = left;
        root.right = right;
        return root;
    }

    private int getsize(ListNode head) {
        int i=0;
        while (head!=null){
            head = head.next;
            i++;
        }
        return i;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public class NodeRef{
        ListNode node;
  }

  public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

