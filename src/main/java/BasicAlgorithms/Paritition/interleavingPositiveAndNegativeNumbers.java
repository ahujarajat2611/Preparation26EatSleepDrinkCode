package BasicAlgorithms.Paritition;

import java.util.Arrays;

/*
 * Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
Note
You are not necessary to keep the original order or positive integers or negative integers.

Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other legal answer.

Challenge
Do it in-place and without extra memory.
 */

//Two pointer, from head to tail
public class interleavingPositiveAndNegativeNumbers {
	public static int[] rerange(int[] A) {
		if (A == null || A.length <= 2)
			return A;
		int pos = 0;
		int neg = 0;
		for (int v : A) {
			if (v < 0)
				neg++;
			else
				pos++;
		}
		pos = pos >= neg ? 0 : 1;
		neg = pos == 0 ? 1 : 0;
		while (pos < A.length && neg < A.length) {
			if (A[pos] > 0)
				pos += 2;
			else if (A[neg] < 0)
				neg += 2;
			else
				swap(A, pos, neg);
		}
		return A;
	}

	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		int[] a = {-1, -1, -2, -2, -6, -9, -2, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] a1 = {-1, -1, -2, -2, -6, -9, -2, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		System.out.println(Arrays.toString(rerange(a)));
		System.out.println(Arrays.toString(rerangeMine(a1)));

	}


	/**
	 * Created by hadoop on 14/12/17.
	 */
	public static int[] rerangeMine(int[] A) {
		if (A == null || A.length == 0) {
			return A;
		}
		int posIndex = 0;
		int negIndex = 1;
		int posNum = 0;
		int negNum = 0;
		for (int num : A) {
			if (num > 0) {
				posNum++;
			} else {
				negNum++;
			}
		}
		if (posNum > negNum) {
			posIndex = 0;
			negIndex = 1;
		} else {
			posIndex = 1;
			negIndex = 0;
		}

		while (posIndex < A.length && negIndex < A.length) {
			while (posIndex < A.length && A[posIndex] >= 0) {
				posIndex += 2;
			}
			while (negIndex < A.length && A[negIndex] < 0) {
				negIndex += 2;
			}
			if (posIndex < A.length && negIndex < A.length) {
				swap(A, posIndex, negIndex);
				posIndex = posIndex + 2;
				negIndex = negIndex + 2;
			}
		}

	return A;
	}
}

//		public static void main(String[] args) {
//			int []ar = new int[]{-2,1,4,-1,-1,2,2};
//			ob.rerange(ar);
//			ConsoleWriter.printArray(ar);
//		}
//		public void rerangeWorking(int[] A) {
//			int cntPos = 0;
//			for (int i : A) {
//				if (i > 0) cntPos++;
//			}
//
//			if (cntPos > A.length - cntPos) {
//				// even: pos, odd: neg
//				int i = 0, j = 1;
//				while (i < A.length && j < A.length) {
//					while (A[i] > 0 && i + 2 < A.length) i += 2;
//					while (A[j] < 0 && j + 2 < A.length) j += 2;
//					if (A[i] < 0 && A[j] > 0) {
//						int tmp = A[i];
//						A[i] = A[j];
//						A[j] = tmp;
//					}
//					i += 2;
//					j += 2;
//				}
//			} else {
//				// even: neg, odd: pos
//				int i = 0, j = 1;
//				while (i < A.length && j < A.length) {
//					while (A[i] < 0 && i + 2 < A.length) i += 2;
//					while (A[j] > 0 && j + 2 < A.length) j += 2;
//					if (A[i] > 0 && A[j] < 0) {
//						int tmp = A[i];
//						A[i] = A[j];
//						A[j] = tmp;
//					}
//					i += 2;
//					j += 2;
//				}
//			}
//		}
//
