package Algorithms6hourTraining;

/**
 * Created by hadoop on 21/12/17.
 */
/*
Hamming distance among all pairs
// so we talk abt at each bit level
for 31 bits we count for all interasr how manys
1 .. at each bit level once we know 1 cout ..
that bit will generate aroudn no.of1 *(len-no.of 1) hamming distance for 1 bit
// likewise calcultae for all the bits
 */
public class HammingDistance {
    int hammingDistance(int nums[]){
        int len = nums.length;
        /*

        This loop could have been reversed as wel l
        like take each bit and travelrs all numbers and calculate result
       instead of storing in the coutofones array
         */
        int[] countOfOnes = new int[32];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                countOfOnes[j] += (nums[i] >> j) & 1;
            }
        }
        int sum = 0;
        for (int count: countOfOnes) {
            sum += count * (len - count);
        }
        return sum;
    }
}
