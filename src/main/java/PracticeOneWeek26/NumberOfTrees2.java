package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 10/12/17.
 */
public class NumberOfTrees2 {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    public ArrayList<TreeNode> generate(int start, int end) {
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();
        if (start > end) {
            rst.add(null);
            return rst;
        }
        for (int i = start; i <= end; i++){
            ArrayList<TreeNode> left = generate(start, i - 1);
            ArrayList<TreeNode> right = generate(i +  1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }
}
