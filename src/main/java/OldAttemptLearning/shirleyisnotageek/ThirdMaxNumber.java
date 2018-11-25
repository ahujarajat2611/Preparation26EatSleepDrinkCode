package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 22/1/18.
 */
public class ThirdMaxNumber {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int n : nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (first > n && n > second) {
                third = second;
                second = n;
            } else if (second > n && n > third) {
                third = n;
            }
        }
        return third > Long.MIN_VALUE ? (int)third : (int)first;
    }
}
