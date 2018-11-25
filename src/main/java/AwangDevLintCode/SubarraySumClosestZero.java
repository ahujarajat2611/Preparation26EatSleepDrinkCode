package AwangDevLintCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hadoop on 24/2/18.
 */
/*
Revise again and agian !!!!

 */
public class SubarraySumClosestZero {
    class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }

    public class Solution {
        /**
         * @param nums: A list of integers
         * @return: A list of integers includes the index of the first number
         *          and the index of the last number
         */
        public int[] subarraySumClosest(int[] nums) {
            int[] res = new int[2];
            if (nums == null || nums.length == 0) {
                return res;
            }

            int len = nums.length;
            if(len == 1) {
                res[0] = res[1] = 0;
                return res;
            }
            Pair[] sums = new Pair[len+1];
            int prev = 0;
            // very imp step .. you need to utteer carefeull you almost made mistake here !!!
            // since you will be asked to find subarray length not just sum so you need to store index as we well

            sums[0] = new Pair(0, 0);
            //
            // Very imp
            // we need to store  prefix sum and indexes with those sum and then sort it
            // dont delay it making pair class
            // thiink abt first case how you want to deal with it .. storing firsst index or zero !!!
            for (int i = 1; i <= len; i++) {
                sums[i] = new Pair(prev + nums[i-1], i);
                prev = sums[i].sum;
            }
            Arrays.sort(sums, new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    return a.sum - b.sum;
                }
            });
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= len; i++) {

                if (ans > sums[i].sum - sums[i-1].sum) {
                    ans = sums[i].sum - sums[i-1].sum;
                    // subtracing index -1 always since we stored index + 1 in the pair

                    int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                    Arrays.sort(temp);
                    /*
                    // Fuck you need to add here +1 since you subtracted that element out while calculating sum
                    // So many things to take care in just one problem !!!!!
                    // Very imp 1
                    // Google quesstio  without a doubt !!!!
                    //
                     */
                    // Very imp step !!!
                    res[0] = temp[0] + 1;
                    res[1] = temp[1];
                }

            }

            return res;
        }
    }
}
