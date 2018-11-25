package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 19/1/18.
 */
/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
Example:
Given num = 16, return true. Given num = 5, return false.
Follow up: Could you solve it without loops/recursion?

The easiest way is to use the same approach as in power of three. However, we can use a easier way:

1. num > 0
2. num must be power of two
3. num & 1010101010101010101010101010101 (0x55555555) = num
 */
public class PowerOf4 {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);

    }
}
