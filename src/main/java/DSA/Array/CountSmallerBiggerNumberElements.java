package DSA.Array;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

class CountSmallerBiggerNumberElements {
    private class TreeNode{
        long val=0;
        int count =1;
        int leftSize =0;
        int rightSize =0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(long v){
            this.val = v;
            this.count = 1;
            this.leftSize = 0;
            this.rightSize =0;
        }
    }
    private TreeNode insert(TreeNode root,int val){
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
    private int countSmaller(TreeNode root,long val){
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
    private int countHigher(TreeNode root,long val){
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
    // cant return two things from function
    // hence updating floor and ceil in functions itself
    public void floorAndCeilOfBst(TreeNode root, int val, AtomicLong floor, AtomicLong ceil) {
        if (root == null)
            return;
        if (val<root.val) {
            ceil.set(root.val);
            floorAndCeilOfBst(root.left, val,floor,ceil);
        } else if (val>root.val) {
            floor.set(root.val);
            floorAndCeilOfBst(root.right, val,floor,ceil);
        } else {
            floor.set(root.val);
            ceil.set(root.val);
        }
    }

}
