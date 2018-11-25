package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
public class RotateString {
    public char[] rotateString(char[] A, int offset) {
        if (A == null || A.length == 0) return A;
        offset = offset % (A.length);
        reverse(A, 0, A.length - offset - 1);
        reverse(A, A.length - offset, A.length - 1);
        reverse(A, 0, A.length - 1);
        return A;
    }


    //Helper function: reverse certain range of array
    public void reverse(char[] A, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = A[j];
            A[j] = A[i];
            A[i] = temp;
        }
    }
}
