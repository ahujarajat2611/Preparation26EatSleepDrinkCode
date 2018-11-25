package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null)
            throw new NullPointerException("Null array!");
        if (A.length == 0)
            return 1;
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length  && A[A[i]-1]!=A[i]) {
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        //if every element is in place, we are missing the next one!
        return A.length + 1;
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
