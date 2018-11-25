package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
I have solved this four times, but I still couldn't remember it correctly. It is similar to dual pivot quick sort.
1. We take two pivots, the left one (pl) initialized at index 0 and the right one initialized at index A.length - 1;
2. Then we loop the array, if A[index] == 0, we swap it with pl, increment pl; if A[index] == 2, we swap it with pr, decrement pr.
 */
public class SortColors {

    public void sortColors(int[] A) {
        if (A == null || A.length < 2)
            return;
        int pl = 0;
        int pr = A.length - 1;
        int index = 0;
        while (index <= pr){
            if (A[index] == 0){
                swap(A, index++, pl++);
            }
            else if (A[index] == 2)
                swap(A, index, pr--);
            else
                index++;
        }
    }
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
