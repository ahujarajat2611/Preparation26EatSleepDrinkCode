package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Next Largest and Smallest number that has the same number of 1 bits

Given an integer, print the next smallest and next largest number that have the same number of 1 bits in their binary representation.

Ok, this is interesting. So basically, given a binary number, 11100110, if we want to find the next largest one that has the same number of 1 bits, we first switch the first 0 to 1, which gives us 11101110, then we switch the next 1 after that 0 to 0, and results in 11101010. Since we want the next largest, we would want to  shift all the 1s after that to the most right side, and the result is: 11101001, yep, here is the solution.

The next smallest number is similar. Reversely, we switch the first 1 to 0 and the next 0 to 1. Using another example 110011 would result in 101011, and shifts, and the answer is: 101110.

 */
public class NextLargestSmallestNumber {
    public class NextBitNumber {
        private int setBit(int n, int index, boolean toOne) {
            int rst;
            if (toOne)
                rst = n | (1 << index);
            else {
                int mask = ~ (1 << index);
                rst = n & mask;
            }
            return rst;
        }
        private boolean getBit(int n, int index) {
            return (n & (1 << index)) > 0;
        }
        public int nextLargest(int n) {
            if (n <= 0)
                return -1;
            int index = 0;
            int countOnes = 0;
            while (!getBit(n, index))
                index++;
            while(getBit(n, index)) {
                index++;
                countOnes++;
            }
            n = setBit(n, index, true);
            index--;
            n = setBit(n, index, false);
            countOnes--;
            index--;
            for (int i = index; i > index - countOnes; i--)
                n = setBit(n, i, false);
            for (int i = 0; i < countOnes; i++)
                n = setBit(n, i, true);
            return n;
        }
        public int nextSmallest(int n) {
            if (n <= 0)
                return -1;
            int index = 0;
            int countZeros = 0;
            while (getBit(n, index)) {
                index++;
            }
            while (!getBit(n, index)) {
                index++;
                countZeros++;
            }
            n = setBit(n, index, false);
            index--;
            n = setBit(n, index, true);
            index--;
            countZeros--;
            for (int i = index; i > index - countZeros; i--)
                n = setBit(n, i, true);
            for (int i = 0; i < countZeros; i++)
                n = setBit(n, i, false);
            return n;
        }

    }
}
