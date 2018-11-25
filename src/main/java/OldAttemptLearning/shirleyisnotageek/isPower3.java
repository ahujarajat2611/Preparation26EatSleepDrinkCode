package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 19/1/18.
 */
public class isPower3 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        else if (n == 1)
            return true;
        else if (n % 3 == 0)
            return isPowerOfThree(n / 3);
        else
            return false;

    }
}
