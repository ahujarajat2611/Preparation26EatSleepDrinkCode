package Algorithms6hourTraining;

import smallmomentsmakeitbigger26.TreeNode;

/**
 * Created by hadoop on 21/12/17.
 */
/*
go left oor go right or starting here same treee we find
 */
public class IsSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s== null && t == null){
            return true;
        }
        if(s == null && t !=null){
            return false;
        }
        if(s != null && t == null){
            return false;
        }
        //same tree starting this point
        // if now go to left or right which ever can
        // give subtree t in s

        // t node will stand still and things start to move
       return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if( s == null ||  t == null){
            return s == t;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right) && s.val == t.val;
    }
}