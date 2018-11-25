package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 13/2/18.
 */
import java.util.*;
public class MaxPathThatHashConsecutiveElements {
}

//    Binary Tree( increasing by 1 )
//    parent to child ( parent to child)
//root :->


class Tree{

    //int maxAnswer =Integer.MIN_VALUE;
    List<Integer> maxList = new ArrayList<Integer>();
    List<Integer> getLongestIncreasingPathFromParentChild(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        if(isLeaf(root)){
            result.add(root.val);
            return result;
        }

        List<Integer> left = getLongestIncreasingPathFromParentChild(root.left);
        List<Integer> right = getLongestIncreasingPathFromParentChild(root.right);

        int current  = root.val;
        int lastLeftValue = left.get(left.size()-1);
        if(current +1 == lastLeftValue ){
            left.add(current);
        }
        else{
            left.clear();
            left.add(current);
        }

        int lastRightValue = right.get(right.size()-1);
        if(current +1 == lastRightValue ){
            right.add(current);
        }
        else{
            right.clear();
            right.add(current);
        }

        if(maxList.size()<left.size()){
            maxList = new ArrayList<Integer>(left);
        }
        if(maxList.size()<right.size()){
            maxList = new ArrayList<Integer>(right);
        }
        return left.size()>right.size()? left:right;
    }

    private boolean isLeaf(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        return false;
    }

//    List<Integer> longestList(TreeNode root){
//
//
//    }

}

