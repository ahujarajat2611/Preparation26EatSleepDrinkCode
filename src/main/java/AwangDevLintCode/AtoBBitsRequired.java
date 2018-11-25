package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
// simle count number of 1s with a^b
public class AtoBBitsRequired {
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (a ^ b) >> i & 1;
        }
        return count;
    }

    int numberofbuts(int x){
        int count=0;
        while (x>0){
            x = x & x-1;
            count++;
        }
        return count;
    }
}

