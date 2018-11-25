package BasicAlgorithms.SlidingWindow;

import java.util.TreeSet;

/**
 * 
 * Problem:
 *
 * There is a garden with N slots.
 * In each slot, there is a flower. The N
 * flowers will bloom one by one in N days. In each day, there will be exactly
 * one flower blooming and it will be in the status of blooming since then.
 * 
 * Given an array flowers consists of number from 1 to N. Each number in the
 * array represents the place where the flower will open in that day.
 * 
 * For example, flowers[i] = x means that the unique flower that blooms at day i
 * will be at position x, where i and x will be in the range from 1 to N.
 * 
 * Also given an integer k, you need to output in which day there exists two
 * flowers in the status of blooming, and also the number of flowers between
 * them is k and these flowers are not blooming.
 * 
 * If there isn't such day, output -1.
 * 
 * Example 1: Input: flowers: [1,3,2] k: 1 Output: 2 Explanation: In the second
 * day, the first and the third flower have become blooming.
 * 
 * Example 2: Input: flowers: [1,2,3] k: 1 Output: -1 Solution:
 * 
 */
public class _683_KEmptySlots {
	public int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		if (flowers == null) {
			return -1;
		}
		for (int i = 0; i < flowers.length; i++) {
			int curPosition = flowers[i];
			treeSet.add(curPosition);
			Integer left = treeSet.lower(curPosition);
			//treeSet.last();
			// floor ceil could have beeen used here ddidrecctly beore insertion of current position
			// tahts why we are using lower hgher
			Integer right = treeSet.higher(curPosition);
			if ((left != null && curPosition - left - 1 == k) || (right != null && right - curPosition - 1 == k)) {
				return i + 1;
			}
		}
		return -1;
	}
}
