package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
    /*
    Any element in the array could
    correspond to only one of the three possible states:

up position, it means nums[i] > nums[i-1]nums[i]>nums[i−1]
down position, it means nums[i] < nums[i-1]nums[i]<nums[i−1]
equals to position, nums[i] == nums[i-1]nums[i]==nums[i−1]
The updates are done as:

If nums[i] > nums[i-1]nums[i]>nums[i−1], that means it wiggles up. The element before it must be a down position. So up[i] = down[i-1] + 1up[i]=down[i−1]+1, down[i]down[i] remains the same as down[i-1]down[i−1]. If nums[i] < nums[i-1]nums[i]<nums[i−1], that means it wiggles down. The element before it must be a up position. So down[i] = up[i-1] + 1down[i]=up[i−1]+1, up[i]up[i] remains the same as up[i-1]up[i−1]. If nums[i] == nums[i-1]nums[i]==nums[i−1], that means it will not change anything becaue it didn't wiggle at all. So both down[i]down[i] and up[i]up[i] remain the same as down[i-1]down[i−1] and up[i-1]up[i−1].

At the end, we can find the larger out of up[length-1]up[length−1] and down[length-1]down[length−1] to find the max. wiggle subsequence length, where lengthlength refers to the number of elements in the given array.

The process can be illustrated with the following example:
     */
    /*
    Approach #2 Dynamic Programming [Accepted]

Algorithm

To understand this approach, take two arrays for dp named upup and downdown.

Whenever we pick up any element of the array to be a part of the wiggle subsequence, that element could be a part of a rising wiggle or a falling wiggle depending upon which element we have taken prior to it.

up[i]up[i] refers to the length of the longest wiggle subsequence obtained so far considering i^{th}i
​th
​​  element as the last element of the wiggle subsequence and ending with a rising wiggle.

Similarly, down[i]down[i] refers to the length of the longest wiggle subsequence obtained so far considering i^{th}i
​th
​​ element as the last element of the wiggle subsequence and ending with a falling wiggle.

up[i]up[i] will be updated every time we find a rising wiggle ending with the i^{th}i
​th
​​  element. Now, to find up[i]up[i], we need to consider the maximum out of all the previous wiggle subsequences ending with a falling wiggle i.e. down[j]down[j], for every j<ij<i and nums[i]>nums[j]nums[i]>nums[j]. Similarly, down[i]down[i] will be updated.
     */
    public int wiggleMaxLengthAgain(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
