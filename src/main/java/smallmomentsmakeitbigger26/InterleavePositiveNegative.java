package smallmomentsmakeitbigger26;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 14/12/17.
 */
public class InterleavePositiveNegative {
    public void rerange(int[] A) {
        if(A == null || A.length ==0){
            return;
        }
        int posIndex = 0;
        int negIndex = 1;
        int posNum  =0;
        int negNum = 0;
        for(int num:A){
            if(num>0){
                posNum++;
            }
            else {
                negNum++;
            }
        }
        if(posNum > negNum){
            posIndex=0;
            negIndex = 1;
        }
        else {
            posIndex = 1;
            negIndex = 0;
        }

        while (posIndex<A.length && negIndex <A.length){
            while (posIndex<A.length && A[posIndex]>=0){
                posIndex+=2;
            }
            while (negIndex<A.length && A[negIndex]<0){
                negIndex +=2;
            }
            if(posIndex<A.length && negIndex<A.length){
                swap(A,posIndex,negIndex);
                posIndex = posIndex+2;
                negIndex = negIndex+2;
            }
        }

    }

    private void swap(int[] a, int posIndex, int negIndex) {
        int temp = a[posIndex];
        a[posIndex] = a[negIndex];
        a[negIndex] = temp;
    }

    public static void main(String[] args) {
        InterleavePositiveNegative ob = new InterleavePositiveNegative();
        int []ar = new int[]{-2,1,4,-1,-1,2,2};
        ob.rerange(ar);
        ConsoleWriter.printArray(ar);
    }
    public void rerangeWorking(int[] A) {
        int cntPos = 0;
        for (int i : A) {
            if (i > 0) cntPos++;
        }

        if (cntPos > A.length - cntPos) {
            // even: pos, odd: neg
            int i = 0, j = 1;
            while (i < A.length && j < A.length) {
                while (A[i] > 0 && i + 2 < A.length) i += 2;
                while (A[j] < 0 && j + 2 < A.length) j += 2;
                if (A[i] < 0 && A[j] > 0) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
                i += 2;
                j += 2;
            }
        } else {
            // even: neg, odd: pos
            int i = 0, j = 1;
            while (i < A.length && j < A.length) {
                while (A[i] < 0 && i + 2 < A.length) i += 2;
                while (A[j] > 0 && j + 2 < A.length) j += 2;
                if (A[i] > 0 && A[j] < 0) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
                i += 2;
                j += 2;
            }
        }
    }
}
