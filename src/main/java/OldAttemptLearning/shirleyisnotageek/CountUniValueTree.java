package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 22/1/18.
 */
public class CountUniValueTree {
    public int countUnivalSubtrees(TreeNode root) {
        int[] result = determine(root);

        return result[0];
    }

    public int[] determine(TreeNode root){

        if(root == null){
            return new int[]{0,1};
        }

        if(root.left == null && root.right == null){
            return new int[]{1,1};
        }

        int[] left = determine(root.left);
        int[] right = determine(root.right);
        int[] result = new int[2];

        if(left[1] == 1 && right[1] == 1 &&(root.left== null || root.left.val == root.val) &&
                (root.right == null || root.right.val == root.val)){
          // addding one more in the answer since current node also
            // univalue tree
            // note we are not passing any fucking value
            // since we can check from its parent
            // nice trick
            // of mainttaing
            result [0] = left[0] + right[0] + 1;
            result[1] = 1;
        }
        else{
            // just adding answers !!!!
            result[0] = left[0] + right[0];
            result[1] = 0;
        }

        return result;

    }
}
