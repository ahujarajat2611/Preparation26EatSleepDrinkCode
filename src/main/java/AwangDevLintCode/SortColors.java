package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
public class SortColors {






    // Here i htink you have forgottne
    // that you need to have range with you to do count sort
    // question come straighforwanrd sort array and assume numbers are given
    // in range one particular range you know be it 50 words . be it 100 words
    // bring your count sort if
    // array of words sort them just tthat aarrat can have 10 diffferent words
    // " rjaat" , ahuja. "why
    // sort them simply count sort would do the job // since we know the rnage
    // of itemss  that we are trying sort !!!
    // in radix sort .. we do count sort only but based on the each digit
    // until we finish consuming last digit .. we keep appy count sort on all digits


    public void sortColors2(int[] colors, int k) {
        int[] num = colors;
        // write your code here
        int[] count = new int[k];
        int[] result = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            count[num[i] - 1]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = num.length - 1; i >= 0; i--) {
            result[--count[num[i] - 1]] = num[i];
        }
        for (int i = 0; i < num.length; i++) {
            num[i] = result[i];
        }
    }
}