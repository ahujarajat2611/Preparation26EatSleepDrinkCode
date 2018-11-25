package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */

import java.util.*;


/*
03.10.2016
Once sorted at beginning, same num are ajacent.
With for loop solution, we are jumping to next position in one dfs call, so this could happen:
skip current and take next. if current == next, that generates duplicates.
Image we've moved one step forward already, so we are not on given index, also current == prev:
that means previous position nums[i-1] must have been used. so we skip the current.
if (i != index && nums[i] == nums[i - 1]) {
    continue;
}
*/
public class SubsetWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }

        Arrays.sort(nums);
        dfs(rst, new ArrayList<Integer>(), 0, nums);
        System.out.println(rst.size());
        System.out.println(1<<nums.length);
        return rst;
    }

    public void dfs(List<List<Integer>> rst, ArrayList<Integer> list, int index, int[] nums) {
      //  System.out.println("list "+list);
        rst.add(new ArrayList<Integer>(list));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(rst, list, i + 1, nums);
            list.remove(list.size() - 1);
//            while (i+1<nums.length && nums[i] == nums[i+1]){
//                i++;
//            }
        }
    }
    public List<List<Integer>> subsetsWithoutDuplicates(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, nums, 0,0);
        System.out.println("ans"+rst.size());
        return rst;
    }
    public void helper(List<List<Integer>> rst, ArrayList<Integer> list,
                       int[] nums, int level, int lastpicked) {
        if (level == nums.length) {
           // System.out.println("list"+list);
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        //pick curr num
       // lastpicked = nums[level];
        if(lastpicked!=nums[level]) {
            list.add(nums[level]);
            // this small mistake good enough to send you home back // be careful of what are things you are passing
            // into functions ..
            helper(rst, list, nums, level + 1, nums[level]);
            list.remove(list.size() - 1);
        }
        //not pick curr num
        helper(rst, list, nums, level + 1,lastpicked);
    }

    public static void main(String[] args) {
        SubsetWithDuplicates ob = new SubsetWithDuplicates();
        int ar[] = new int[]{1,2,3,3,3,4,5,5,5,6,6,6,6};
        ob.subsetsWithDup(ar);
        ob.subsetsWithoutDuplicates(ar);
    }
}
