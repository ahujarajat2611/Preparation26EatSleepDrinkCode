package DSA.Backtracking;

/**
 * Created by hadoop on 21/2/18.
 */
import java.util.Arrays;
public class PartitiontoKEqualSumSubsets {



    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0 || sum < k) return false;
        sum = sum / k;
        return possible(nums, sum, new int[k], nums.length - 1,0);
    }

    // Since i am dealing in the index
    // I need to be careful to make it negative and go thrugh correcct Path !!!
    // I need to be very careful !!!
    // You need to keep addding numbers to partitions !!
    // And thats how you can deal with it !!!
    // For(int partitions =0;partitions< each paritionss siize )
    // Given sum to each paritions and go forward !!!
    // Idx gets negative !!!
    //
    boolean possible(int[] nums, int sum, int[] p, int idx,int partitionNumber) {
        //System.out.println(idx);
        if(p[partitionNumber]>sum){
            return false;
        }
        // thats the way you reach end nnegative and move on
        // or ryou can kkeep track on the basiis of number of elements !!!!
        if (idx == -1) {
            // for (int s : p) System.out.print(s + " ");
            //System.out.println();
            for (int s : p)
                if (s != sum)
                    return false;
            return true;
        }

        int num = nums[idx];

        for (int i = 0; i < p.length; i++) {
                p[i] += num;
                if (possible(nums, sum, p, idx - 1,i)) return true;
                p[i] -= num;
        }
        return false;
    }

        /*
         * This is recursive solution. If interested, dp solution is available at
         * https://leetcode.com/articles/partition-to-k-equal-sum-subsets/
         */
        //https://discuss.leetcode.com/topic/107185/java-c-straightforward-dfs-solution
    public boolean canPartitionKSubsetsDifferentApproach(int[] a, int k) {
            if (k > a.length)
                return false;

            int sum = 0;
            for (int n : a)
                sum += n;
            if (sum % k != 0) {
                return false;
            }
            Arrays.sort(a);
            boolean[] visited = new boolean[a.length];
            return canPartitionUtil(a, k, visited, 0, 0, sum / k, 0);
        }

        private boolean canPartitionUtil(int[] a, int k, boolean[] visited, int index, int sum, int target, int count) {
            if (sum > target)
                return false;

            if (1 == k) {
                return true;
            }
		/*
		 * 'count' is added to address corner case when sum=0
		 *  if it's not added every time 'target' and 'sum' are zero and will fail.
		 */
            if (sum == target && count > 0) {
                return canPartitionUtil(a, k - 1, visited, 0, 0, target, 0);
            }

            for (int i = index; i < a.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (canPartitionUtil(a, k, visited, i + 1, sum + a[i], target, ++count))
                        return true;
                    visited[i] = false;
                }
            }
            return false;
        }

        public static void main(String args[]) {
            PartitiontoKEqualSumSubsets obj = new PartitiontoKEqualSumSubsets();
            int a[] = { 4, 3, 2, 3, 5, 2, 1 };
            boolean result = false;
            result = obj.canPartitionKSubsets(new int[] { 1,2,3,4 }, 2);
            System.out.println(result);

            result = obj.canPartitionKSubsets(a, 4);
            System.out.println(result);

            result = obj.canPartitionKSubsets(new int[] { 0, 0, 0, 0 }, 4);
            System.out.println(result);

        }
}
