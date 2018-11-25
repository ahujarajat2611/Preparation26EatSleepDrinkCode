package zrzahid;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by hadoop on 6/9/17.
 */
// find the min path between two nodes of tree n1 and n2 given their parent !!!
public class MinPath {
    public static void main(String[] args) {
        TreeNode a = null;
        TreeNode b = null;
        int ans = minpath(a,b);
    }
    private class TreeNode{
        int data;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
    }

    public static int minpath(TreeNode a, TreeNode b){
        int height1 = getHeight(a);
        int height2 = getHeight(b);

        if(height1>height2){
            int temp = height1;
            height1 = height2;
            height2 = temp;
            TreeNode tempagain= a;
            a=b;
            b=tempagain;
        }

        LinkedList<Integer> pathDeeper = new LinkedList<>();
        LinkedList<Integer> pathShallower = new LinkedList<>();

        for( int i=0;i<height2-height1;i++){
            pathDeeper.add(b.data);
            b= b.parent;
        }
        while (a!=null && b!=null){

            pathDeeper.add(a.data);
            pathShallower.addFirst(b.data);
            a = a.parent;
            b= b.parent;
            // when you meet thats when you know that
            // you have reached the end !!!
            // kindly save the paths !!
            if(a == b){
                Set<Integer> hashset = new HashSet<>();
                hashset.addAll(pathDeeper);
                hashset.addAll(pathShallower);
                return hashset.size();
            }
        }

        return 0;

    }

    public static int getHeight(TreeNode root){
        int height =0;
        while (root!=null){
            height++;
            root = root.parent;
        }
        return height;
    }
}
