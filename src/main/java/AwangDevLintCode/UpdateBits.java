package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
public class UpdateBits {
    public int updateBits(int n, int m, int i, int j) {
        // create a mask to clear bits i through j in n
        // Example: i=2, j=4, result should be 11100011
        // for simplicity, we'll use just 8 bits for the example
        int allOnes = ~0; // will equal sequence of all 1s
        int left = allOnes << (j + 1); // left: 11100000
        int right = ((1 << i) - 1); // right:00000011
        int newright = ~(~0<<i);
        int newrightright = (1<<i)-1;
        System.out.println(Integer.toBinaryString(newright));
        System.out.println(Integer.toBinaryString(right));
        System.out.println(Integer.toBinaryString(newrightright));
        System.out.println("=====");
        int newleft = ~((1 << j+1)-1);
        System.out.println(Integer.toBinaryString(newleft));
        System.out.println(Integer.toBinaryString(left));

        int mask = left | right; // mask: 11100011
        // clear bits j through i then put m in there
        int n_cleared = n & mask; // clear bits j through i
        int m_shifted = m << i; // move m into correct position
        //System.out.println(Integer.toBinaryString(m));
        //System.out.println(Integer.toBinaryString(m_shifted));
        //int newmask = ~(mask);
        //System.out.println(Integer.toBinaryString(mask));

       // System.out.println(Integer.toBinaryString(newmask));
//        System.out.println(Integer.toBinaryString(m & newmask));
        return (n_cleared | m_shifted);


        // also ~mask && m_shifted to fecth all bits
    }

    public static void main(String[] args) {
        UpdateBits updateBits = new UpdateBits();
        System.out.println(updateBits.updateBits(100,34,2,3));
    }
}

