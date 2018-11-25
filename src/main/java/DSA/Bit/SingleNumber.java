package DSA.Bit;

/**
 * Created by hadoop on 20/1/18.
 */
public class SingleNumber {
    public class Solution {
        public int singleNumber(int[] A) {
            if (A == null || A.length == 0)
                return -1;
            //unsigned int, 32 bits
            int[] bits = new int[32];
            int rst = 0;
            for (int i = 0; i < 32; i++)
            {
                for (int j = 0; j < A.length; j++)
                {
                    // & 1 will count only the bit 1
                    bits[i] += A[j] >> i & 1;
                    bits[i] %= 3;
                }
                //adding back to the original position by left shift i bits.
                //e.g.  000 = 000 || (1 << 2) = 100
                rst |= (bits[i] << i);
            }
            return rst;

        }
    }
}
