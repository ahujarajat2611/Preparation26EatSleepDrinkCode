package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class SortedArrayToList {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTHelpler(0,num.length-1,num);
    }

    private TreeNode sortedArrayToBSTHelpler(int low, int end,int []num) {
        if(low>end){
            return null;
        }
        if(low == end){
            return new TreeNode(num[low]);
        }

        int mid = low + (end-low)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTHelpler(low,mid-1,num);
        root.right = sortedArrayToBSTHelpler(mid+1,end,num);
        return root;
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