package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
public class MergeSortedArray {

    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null) {
            return A == null ? B : A;
        }
        int[] rst = new int[A.length + B.length];
        int indA = A.length - 1;
        int indB = B.length - 1;
        int i = rst.length - 1;
        while (indA >= 0 && indB >= 0) {
            if (A[indA] <= B[indB]) {
                rst[i--] = B[indB--];
            } else {
                rst[i--] = A[indA--];
            }
        }
        while (indA >= 0) {
            rst[i--] = A[indA--];
        }
        while (indB >= 0) {
            rst[i--] = B[indB--];
        }
        return rst;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return;
        }
        int pos1 = m - 1;
        int pos2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            //Handle remaining of nums1 or nums2
            if (pos1 < 0 || pos2 < 0) {
                nums1[i] = pos1 < 0 ? nums2[pos2--] : nums1[pos1--];
            } else {
                if (nums1[pos1] >= nums2[pos2]) {
                    nums1[i] = nums1[pos1--];
                } else {
                    nums1[i] = nums2[pos2--];
                }
            }
        }
    }
}
