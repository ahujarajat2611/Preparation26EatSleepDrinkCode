package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 25/10/17.
 */
import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        TreeNode root = null;
        int totalans = 0;
        TreeSet<Double> set = new TreeSet<>();
        for(int i=nums.length-1;i>=0;i--){
           // System.out.println(nums[i]);
           // System.out.println(set.headSet(new Double(nums[i]/2)).size());
            int numberlessThancurrentby2 =countSmaller(root,(double)nums[i]/2);
            totalans = totalans + numberlessThancurrentby2;
            root = insert(root,nums[i]);
        }
        preorder(root);
        return totalans;
    }

    private class TreeNode{
        double val=0;
        int count =1;
        int leftSize =0;
        int rightSize =0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(double v){
            this.val = v;
            this.count = 1;
            this.leftSize = 0;
            this.rightSize =0;
        }
    }
    void preorder(TreeNode node){
        if(node == null){
            return;
        }
        //System.out.println(node.val +" "+node.count+" "+node.leftSize+" "+node.rightSize);
        preorder(node.left);
        preorder(node.right);
    }
    private TreeNode insert(TreeNode root,double val){
        //System.out.println(root);
        if(root == null){
            return new TreeNode(val);
        }
        else if(val<root.val){
            root.leftSize++;
            root.left = insert(root.left,val);
        }
        else if(val >root.val){
            root.rightSize++;
            root.right = insert(root.right,val);
        }
        else if(val == root.val){
            root.count++;
        }
        return root;
    }
    private int countSmaller(TreeNode root,double val){
        if(root == null){
            return 0;
        }
        else if(val<root.val){
            return countSmaller(root.left,val);
        }
        else if(val>root.val){
            return root.count+root.leftSize + countSmaller(root.right,val);
        }
        else {
            return root.leftSize;
        }
    }
    private int countHigher(TreeNode root,double val){
        if(root == null){
            return 0;
        }
        else if(val <root.val){
            return root.count + root.rightSize + countHigher(root.left,val);
        }
        else if(val >root.val){
            return countHigher(root.right,val);
        }
        else
            return root.rightSize;
    }
//    public void floorAndCeilOfBst(TreeNode root, int val, AtomicInteger floor, AtomicInteger ceil) {
//        if (root == null)
//            return;
//        if (val<root.val) {
//            ceil.set(root.val);
//            floorAndCeilOfBst(root.left, val,floor,ceil);
//        } else if (val>root.val) {
//            floor.set(root.val);
//            floorAndCeilOfBst(root.right, val,floor,ceil);
//        } else {
//            floor.set(root.val);
//            ceil.set(root.val);
//        }
//    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{1,3,2,3,1}));
    }
}
