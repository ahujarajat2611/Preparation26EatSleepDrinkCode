package BasicAlgorithms.Paritition;

/**
 * Created by hadoop on 1/3/18.
 */
public class RearrangeAgain {
    public void rerange(int[] A) {
        // First to count the number of postive and negative numbers separately
        int cntPos = 0, cntNeg = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] >= 0) {
                cntPos++;
            } else {
                cntNeg++;
            }
        }

        //The order of positive and negative index is depended on which owns more numbers.
        int posInx = 0, negInx = 1;
        if(cntPos < cntNeg) {
            negInx = 0;
            posInx = 1;
        }

        //Swap elements if a negative numbers is on a positive position. Don't forget to check boundaries.
        while(posInx < A.length && negInx < A.length) {
            while(posInx < A.length && A[posInx] >= 0) {
                posInx += 2;
            }
            while(negInx < A.length && A[negInx] < 0) {
                negInx += 2;
            }
            if(posInx < A.length && negInx < A.length) {
                swap(posInx, negInx, A);
                posInx += 2;
                negInx += 2;
            }
        }
    }

    private static void swap(int i, int j, int[] A) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }
}
