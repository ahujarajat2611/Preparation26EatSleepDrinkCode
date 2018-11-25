package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
public class ClosestValue {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        double ans = 0;
        double diff = Integer.MAX_VALUE;
        double closest = root.val;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            } else {
                if (diff>= Math.abs(target - root.val)) {
                    diff = Math.abs(target - root.val);
                    closest = root.val;
                }
                // this part is tricky like where to go
                // if target is less than root
                // surely you have to go near to target go to left
                // try to go to the near to the rooot
                if (root.val > target) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }//END while
        return (int)closest;
    }
}
