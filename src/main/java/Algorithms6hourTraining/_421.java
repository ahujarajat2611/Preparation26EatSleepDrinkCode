package Algorithms6hourTraining;

/*

 */
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class _421 {

    //credit: https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap/7
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 3; i >= 0; i--) {
            mask |= (1 << i);//the mask will grow like this: 100...000, 110...000, 111...000 to 111...111, each time, we only get the most left part of all numbers in the given array
            System.out.println("mask = " + Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                System.out.println("num = " + Integer.toBinaryString(num));
                set.add(num & mask);
                System.out.println("mask & num = " + Integer.toBinaryString(mask & num));
            }

            int candidate = max | (1 << i);
            System.out.println("candidate = " + Integer.toBinaryString(candidate));
            /**Reason behind this: if a ^ prefix = candidate, then a ^ candidate = prefix, also prefix ^ candidate = a
             * in this below code: we use this one: prefix ^ candidate = a*/
            for (int prefix : set) {
                System.out.println("candidate ^ prefix = " + Integer.toBinaryString(candidate ^ prefix));
                if (set.contains(candidate ^ prefix)) {
                    max = candidate;
                }
            }
            System.out.println("max = " + max);
            System.out.println("i = " + i);
            System.out.println("===============================================");
        }
        return max;
    }

    public static void main(String[] args) {
        _421 ans = new _421();
        System.out.println(ans.findMaximumXOR(new int[]{3, 10, 5}));
    }

}

class BitTrie {

    BitTrie left = null;

    BitTrie right = null;

}
class MaxXor {

    public boolean containsDuplicate(int[] nums) {

        BitTrie root = new BitTrie();

        for (int num : nums) {

            BitTrie cur = root;

            for (int i = 31; i >= 0; i--) {

                if (((num >>> i) & 1) == 1) {

                    if (cur.left == null) {

                        cur.left = new BitTrie();

                    }

                    cur = cur.left;

                } else {

                    if (cur.right == null) {

                        cur.right = new BitTrie();

                    }

                    cur = cur.right;

                }

            }

        }


        int max = 0;

        for (int num : nums) {

            BitTrie cur = root;

            int i = 31, curNum = num;

            for (; i >= 0; i--) {

                // at insertion time i had gone to left when 1 was there
                // so here to search max xor i will go right
                if (((curNum >>> i) & 1) == 1) {

                    if (cur.right != null) {

                        cur = cur.right;

                        curNum |= (1 << i);
// if my right is nnull i have no option but to go left !!!!!
                    } else {

                        cur = cur.left;

                    }

                } else {

                    if (cur.left != null) {

                        cur = cur.left;

                        curNum |= (1 << i);

                    } else {

                        cur = cur.right;

                    }

                }
// i dont think this solution is right since
                // we are checking for max inside the loop
                //
                max = Math.max(curNum, max);

            }

        }

        System.out.println(max);

        return true;

    }
}