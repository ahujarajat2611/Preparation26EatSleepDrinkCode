package OldAttemptLearning.programgreek;

import java.util.Stack;

/**
 * Created by hadoop on 22/8/17.
 */
public class PostOrderIterative {
    Stack<Pair> stack = new Stack<Pair>();
    TreeNode node ;

    void iterative(){
        while(true){

            while(node!=null){
                stack.push(new Pair(1,node));
                node = node.left;
            }

            if(stack.isEmpty()){
                break;
            }
            Pair pair = stack.pop();

            if(pair.status ==1){
                pair.status = -1;
                stack.push(pair);
                node = pair.treeNode.right;
            }
            else{
                System.out.println(pair.treeNode.val);
                node = null;
            }
        }
    }

    public PostOrderIterative(TreeNode node) {
        this.node = node;
    }

    private class Pair{
        int status;
        TreeNode treeNode;

        public Pair(int status, TreeNode treeNode) {
            this.status = status;
            this.treeNode = treeNode;
        }
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
