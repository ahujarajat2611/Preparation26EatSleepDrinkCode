package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class ConnectNodes {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        TreeLinkNode head = null;
        TreeLinkNode previous = null;
        TreeLinkNode current = root;
        while (current!=null){

            //process on same level
            while (current!=null) {

//                if (head == null) {
//                    if (current.left != null) {
//                        head = current.left;
//                    }
//                    if (current.right != null) {
//                        head = current.right;
//                    }
//                }

                if(current.left!=null){
                    if(previous != null){
                        previous = current.left;
                        head = current.left;
                    }else {
                        previous.next = current.left;
                        previous = current.left;
                    }
                }

                if(current.right!=null){
                    if(previous != null){
                        previous = current.right;
                        head = current.left;
                    }else {
                        previous.next = current.right;
                        previous = current.right;
                    }
                }

                current = current.next;
            }

            current = head;
            head = null;
            previous = null;
        }
    }

    private class TreeLinkNode{
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;
        TreeLinkNode(int x){
            val = x;
        }
    }
}