package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 3/9/17.
 */
public class FlattenBinaryTree {



//class graphdfsbfstemplate{
//
//   /* dfs(){
//        Stack st = new Stack();
//        st.push(node);
//        node.visited = true;
//        printnode(node)
//        while(!stack.isEMpty){
//        // do not remove until you explored all data
//
//        node = stack.peek() only top seeing not removing
//        Node chile = getunvisitednode(node);
//        if(chile!=null){ // some child node exist in the system
//                child.visited = true;
//                 stack.push(child)
//                 print node(child)
//        }
//        else{
//            remove item from stack
//            stack.pop();
//        }
//
//        }
//
//    }
//
//    */
   static TreeNode lastVisit = null;
   public static void flatten(TreeNode root){
       if (root == null){
           return;
       }
       TreeNode savedRight = root.right;
       //initialize a new node, and fill the nodes from root
       if (lastVisit != null){
           lastVisit.left = null;//assign null to left
           lastVisit.right = root;//right will be filled with left child tree first
       }

       lastVisit = root;
       /**go to left first and fill it to lastVisit node's right tree
        * and save right child **/
       flatten(root.left);
       flatten(savedRight);
   }
}
//    class TreeNode{
//       int data;
//       TreeNode left;
//       TreeNode right;
//   }
