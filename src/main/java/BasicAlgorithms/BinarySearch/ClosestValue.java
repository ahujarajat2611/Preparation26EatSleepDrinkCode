package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class ClosestValue {

    public int closestValue(TreeNode root, double target) {
        if(root ==null){
            return (int)target;
        }
        double diff = Double.MAX_VALUE;
        int valueintree= -1;
        Double d = new Double(target);

        while (root!=null){
            if(diff >Math.abs(target-root.val)){
                diff = Math.abs(target-root.val);
                valueintree = root.val;
            }
            if(d-(double)root.val<0.001){
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return valueintree;
    }


    public int closestValueConcise(TreeNode root, double target) {
        int closet = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) <= Math.abs(closet - target)) {
                closet = root.val;
            }
            root = root.val < target ? root.right : root.left;
        }
        return closet;
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
}
