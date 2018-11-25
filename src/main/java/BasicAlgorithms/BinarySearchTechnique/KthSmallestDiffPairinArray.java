package BasicAlgorithms.BinarySearchTechnique;

import java.util.Arrays;

/**
 * Created by hadoop on 24/12/17.
 */
public class KthSmallestDiffPairinArray {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1]-nums[0];

        System.out.println(right);
        while (left<right){
            int mid = left + (right-left)/2;
            /// lets count how many pairs with diff lesss than mid
            System.out.println("mid"+mid);
            int count= getCount(nums,mid);
            System.out.println("cou"+count);
            int countmine = getCountmine(nums,mid);
            System.out.println("count mine"+countmine);
            if(count<k){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    private int getCount(int[] nums, int mid) {
        int left=0;
        int right=0;
        int count =0;
        while (right<nums.length){

            while (left<right && nums[right]-nums[left]>mid){
                left++;
            }
            if(nums[right]-nums[left]<=mid) {
                count = count + right - left;
            }
           // 1 2 3 4  5
            right++;
        }
        return count;
    }

    private int getCountmine(int[] nums, int mid) {
        int left=0;
        int right=0;
        int count =0;
        while (left<nums.length){
            right = left+1;
            while (right<nums.length && nums[right]-nums[left]<=mid){
                count++;
                right++;
            }
            left++;
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallestDiffPairinArray kthSmallestDiffPairinArray = new KthSmallestDiffPairinArray();
        int []ar = {1,6,1,4,5,7};
        int []ar1 = {1,1,4};
        System.out.println("count +"+kthSmallestDiffPairinArray.getCount(ar1,3));
        System.out.println("count mine + "+kthSmallestDiffPairinArray.getCountmine(ar1,3));
        // 1 1 4 5 6 7

        int dis = 3;
       // System.out.println(kthSmallestDiffPairinArray.smallestDistancePair(ar,dis));
    }
}
/*
int smallestDistancePair(vector<int>& nums, int k) {
        int N = 1000000;
        vector<int> count(N + 1, 0);
        const size_t n = nums.size();
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
               ++count[abs(nums[j] - nums[i])];

        int sum = 0;
        for (int i = 0; i <= N; ++i) {
            sum += count[i];
            if (sum >= k)
                return i;
        }
        return 0;
    }

 */

/*
sort nums O(nlogn)
find the smallest distance d such that at least k pairs have distances <= d
1. Given a distance d, find the number of pairs with distances <= d (two pointer) O(n)
2. binary search (upper bound) within 0 ~ (maxNum - minNum) O(log(max(nums))
For each distance given in subproblem 2:
    do subproblem one
i i + 1, ... j - 1, j
*/
/*
class Solution {
    public:
    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        const size_t n = nums.size();
        int l = 0;
        int r = nums.back() - nums.front();
        while (l < r) {
            int count = 0;
            int m = l + (r - l) / 2;
            int j = 0;
            for (int i = 0; i < n; ++i) {
                while (j < n && nums[j] - nums[i] <= m)
                    ++j;

                count += j - i - 1;
            }

            if (count >= k)
                r = m;
            else
                l = m + 1;
        }

        return l;

    }
};/*
 */