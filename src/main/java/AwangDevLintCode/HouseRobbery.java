package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that
adjacent houses have security system connected and it will automatically
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.


Example
Given [3, 8, 4], return 8.

Challenge
O(n) time and O(1) memory.

Tags Expand
Dynamic Programming

*/
/*
Thoughts:
MAX, think about DP.
DP[i]: max sum at index i.
Either house i is robbed or not: dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
Init: dp[0] = nums[0]; dp[1] = Math.max(nums[0], nums[1])
*/

public class HouseRobbery {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    /*
        Each house depends on front and back houses
        Two possible case for the last house: rob or not robbed. So we can do two for loop, then compare the
        two differnet future.
    */
    public int robInCircle(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int n = nums.length;

        //Last house not robbed
        int[] dp1 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        dp1[n - 1] = dp1[n - 2];

        //Last house robbed
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < n - 2; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        dp2[n - 1] = dp2[n - 3] + nums[n - 1];

        //Compare
        return Math.max(dp2[n - 1], dp1[n - 1]);
    }

    public int robInTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        }
        return Math.max(dfs(root,true), dfs(root, false));
    }

    public int dfs (TreeNode node, boolean takeCurrentNode) {
        if (node.left == null && node.right == null) {
            if (takeCurrentNode){
                return node.val;
            } else {
                return 0;
            }
        }
        int left = 0;
        int right = 0;
        if (takeCurrentNode) {
            if (node.left != null) {
                left = dfs(node.left, !takeCurrentNode);
            }
            if (node.right != null) {
                right = dfs(node.right, !takeCurrentNode);
            }
            return node.val + left + right;
        } else {
            if (node.left != null) {
                left = Math.max(dfs(node.left, !takeCurrentNode), dfs(node.left, takeCurrentNode));
            }
            if (node.right != null) {
                right = Math.max(dfs(node.right, !takeCurrentNode), dfs(node.right, takeCurrentNode));
            }
            return left + right;
        }

    }

}
