package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 20/1/18.
 */
public class SumNumbes {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        AtomicInteger integer = new AtomicInteger();
        sumnumberhelper(root,root.val,integer);
        return integer.intValue();
    }

    private void sumnumberhelper(TreeNode root, int val,AtomicInteger integer) {
        if(root == null){
            return ;
        }
        if(root.left== null && root.right == null){
            integer.set(integer.get()+val);
            return;
        }
        if(root.left!=null) {
            sumnumberhelper(root.left,10*val+root.left.val,integer);
        }
        if(root.right!=null){
            sumnumberhelper(root.right,10*val+root.right.val,integer);
        }

    }
}
