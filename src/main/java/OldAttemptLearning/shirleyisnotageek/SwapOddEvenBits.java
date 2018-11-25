package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class SwapOddEvenBits {
    public class SwapBits {
        public int swapBits (int n) {
            //0xaaaaaaaa = 10101010...10
            // 0x55555555 = 1010101...01
            return (n & 0xaaaaaaaa) >> 1 | (n & 0x55555555) << 1;
        }
    }
    public class BitsNeededToConvert {
        public int bitsNeeded(int a, int b) {
            if (a == b)
                return 0;
            int count = 0;
            for (int c = a ^ b; c >= 0; c = c>> 1) {
                count += c & 1;
            }
            return count;
        }

    }
}
