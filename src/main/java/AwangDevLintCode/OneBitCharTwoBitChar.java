package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

Example 1:
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
Example 2:
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
Note:

1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.

 */
/*
Thoughts
Starting from the first bit number: If you encounter 1, it must jump two; if you encounter 0, it must be a jump.


 */
public class OneBitCharTwoBitChar {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        int index = 0;
        while (index < bits.length - 1) {
            index += bits[index] % 2 == 1 ? 2 : 1;
        }
        return index == bits.length - 1;
    }
}
