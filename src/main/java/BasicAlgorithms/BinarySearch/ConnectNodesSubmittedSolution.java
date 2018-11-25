package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 27/1/18.
 */
public class ConnectNodesSubmittedSolution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode nextLevel = root;
        TreeLinkNode previousOnNextLevel = null;
        TreeLinkNode current = null;
        while (nextLevel != null) {
            current = nextLevel;
            nextLevel = null;
            // even if you dont make nextlevelpoint to  null still things can
            // be worked out !!
            previousOnNextLevel = null;
            //process on same level
            while (current != null) {
                // if (nextLevel == null) {
                //     if (current.left != null) {
                //         nextLevel = current.left;
                //     }
                //     // terrrible mistake where to use two ifs and where to use if and else .. INterviewer might confuse you ...
                //     // before write two ifss or if and else think twice .. now
                //     else if (current.right != null) {
                //         nextLevel = current.right;
                //     }
                // }
                if (current.left != null) {
                    if (previousOnNextLevel == null) {
                        nextLevel = current.left;

                    } else {
                        previousOnNextLevel.next = current.left;
                    }
                    previousOnNextLevel = current.left;
                }
                if (current.right != null) {
                    if (previousOnNextLevel == null) {
                        nextLevel = current.right;


                    } else {
                        previousOnNextLevel.next = current.right;
                    }
                    previousOnNextLevel = current.right;
                }
                // travesrse forward like BFS type
                current = current.next;
            }
        }
    }
    public void connectAgain(TreeLinkNode root) {
        if(root == null){
            return;
        }
        TreeLinkNode nextLevel = root;
        TreeLinkNode previousOnNextLevel = null;
        TreeLinkNode current = null;
        while (nextLevel!=null){
            current = nextLevel;
            nextLevel= null;
            previousOnNextLevel = null;
            while (current!=null) {
                if(current.left!=null){
                    if(previousOnNextLevel == null){
                        nextLevel = current.left;
                    }
                    else {
                        previousOnNextLevel.next = current.left;
                    }
                    previousOnNextLevel = current.left;
                }
                if(current.right!=null){
                    if(previousOnNextLevel == null){
                        nextLevel = current.right;
                    }
                    else {
                        previousOnNextLevel.next = current.right;
                    }
                    previousOnNextLevel = current.right;
                }
                current = current.next;
            }
        }
    }
    private class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
}
