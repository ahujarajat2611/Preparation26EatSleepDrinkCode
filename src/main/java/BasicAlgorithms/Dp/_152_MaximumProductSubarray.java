package BasicAlgorithms.Dp;

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int maxHerePre = nums[0];
		int minHerePre = nums[0];
		int maxSoFar = nums[0];
		int maxHere, minHere;
		for (int i = 1; i < nums.length; i++) {
			maxHere = Math.max(Math.max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
			minHere = Math.min(Math.min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i]);
			maxSoFar = Math.max(maxSoFar, maxHere);
			maxHerePre = maxHere;
			minHerePre = minHere;
		}
		return maxSoFar;
	}
}