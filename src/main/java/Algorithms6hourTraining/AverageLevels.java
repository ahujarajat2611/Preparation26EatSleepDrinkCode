package Algorithms6hourTraining;

import smallmomentsmakeitbigger26.TreeNode;
import java.util.*;

/**
 * Created by hadoop on 21/12/17.
 */
/*
1) Create Queue
2) get each level size queue.size()
3)iterate current level as per size and adding mroe elements to queue
4)keep trach of average at each level since you size simple caluculate sum/size

 */
public class AverageLevels {
    List<Double> average(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> ans = new LinkedList<>();

        while (!queue.isEmpty()){
            int size = queue.size();
            double sum =0;
            for(int i=0;i<size;i++){
                TreeNode polled = queue.poll();
                sum = sum + polled.val;
                if(polled.left!=null){
                    queue.add(polled.left);
                }
                if(polled.right!=null){
                    queue.add(polled.right);
                }
            }
            double avg = sum/size;
            ans.add(avg);
        }
        return ans;
    }
}
