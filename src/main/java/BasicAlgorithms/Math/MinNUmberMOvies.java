package BasicAlgorithms.Math;

/**
 * Created by hadoop on 15/1/18.
 */
public class MinNUmberMOvies {
    public static int minMoves(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // increasing n-1 numbers  until they all become same same as decreasing each number to min number
        // and calcultae moves by taking DIff
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int res = 0;
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }

    public static void main(String... args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(minMoves(nums));
    }
}

/*
let’s define sum as the sum of all the numbers,
 before any moves; minNum as the min number int the list; n is the length of the list;

After, say m moves, we get all the numbers as x , and we will get the following equation

 sum + m * (n - 1) = x * n
and actually,

  x = minNum + m
and finally, we will get

  sum - minNum * n = m
So, it is clear and easy now.






Sort By
Comments:  33
ahujarajat261
 Click here to reply
shijungg
shijungg Nov 29, 2016, 12:03 AM
Let me explain why x = minNum + m
our goal is :increment minNum to be equal to maxNum
No matter how many add operations are executed,the goal won’t change.
Every time we do the add operation,the min number in the array must participate in.
After an add operation,the minNum is still the min number
So the minNum participate in every add operation
So x = minNum + m

 */