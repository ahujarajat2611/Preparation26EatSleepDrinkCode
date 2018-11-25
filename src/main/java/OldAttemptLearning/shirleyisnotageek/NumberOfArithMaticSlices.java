package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 24/1/18.
 */
/*
Arithmetic Slices
A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, these are arithmetic sequence:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.
1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
The function should return the number of arithmetic slices in the array A.

For a given length (e.g., n ) of arithmetic sequence, we can calculate the number of arithmetic sequences in it is (n - 1) * (n - 2) / 2. So the question becomes finding all arithmetic sequences in the array. Whenever we find one, we calculate number of sequences in it.


 */
public class NumberOfArithMaticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int pos = 1;
        int len = A.length;
        int rst = 0;
        while (pos < len) {
            int lenSub = 1;
            int diff = A[pos] - A[pos - 1];
            while (pos < len && A[pos] - A[pos - 1] == diff) {
                pos++;
                lenSub++;
            }
            if (lenSub >= 3) {
                rst += getRst(lenSub);
            }
        }
        return rst;
    }

    private int getRst(int currLen) {
        return (currLen - 1) * (currLen - 2) / 2;
    }
}

