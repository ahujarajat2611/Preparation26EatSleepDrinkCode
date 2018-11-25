package DSA.Dp;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * House Robber http://www.programcreek.com/2014/03/leetcode-house-robber-java/
 * 
 * @author Raj
 *
 */
public class HouseRobberWithHousesInCircle {

	// Time :O(n) Space :O(1)
	public int houseRobberWithMaxAmount(int[] a) {
		int n = a.length;
		if (1 == n)
			return a[0];

		// Rob house including 1stHouse, excluding last house
		int amt1 = houseRobberWithMaxAmountHousesFromItoJInConstantSpace(a, 0, a.length - 2);
		// Rob house excluding 1stHouse, including last house
		int amt2 = houseRobberWithMaxAmountHousesFromItoJInConstantSpace(a, 1, a.length - 1);

		return Math.max(amt1, amt2);
	}

	// Time :O(n) Space :O(1)
	private int houseRobberWithMaxAmountHousesFromItoJInConstantSpace(int[] a, int i, int j) {
		if (null == a || i > j)
			return 0;

		if (j - i == 0)
			return a[i];

		int incl = a[i];
		int excl = 0, temp;

		for (int k = i + 1; k <= j; k++) {
			temp = incl;
			incl = Math.max(excl + a[k], incl);
			excl = temp;
		}
		return incl;
	}


	public int robMyAnswer(int[] nums) {
		if(nums.length ==0){
			return 0;
		}
		return Math.max(robfirstselected(nums),roblastselected(nums));
	}
	public int robfirstselected(int[] nums) {

		int include = nums[0];
		int exclude = 0;

		for(int i=1;i<nums.length-1;i++){
			int previnclude = include;
			int prevexclude = exclude;
			include = nums[i]+prevexclude;
			exclude = Math.max(prevexclude,previnclude);
		}
		return Math.max(include,exclude);
	}
	public int roblastselected(int[] nums) {

		int include = 0;
		int exclude = 0;

		for(int i=1;i<nums.length-1;i++){
			int previnclude = include;
			int prevexclude = exclude;
			include = nums[i]+prevexclude;
			exclude = Math.max(prevexclude,previnclude);
		}
		return Math.max(include,exclude+nums[nums.length-1]);
	}


	public static void main(String[] args) {
		// int a[] = { 2, 1, 2, 3, 1 };
		// int a[] = { 5, 5, 10, 40, 50, 35 };
		int a[] = { 2, 10, 13, 4, 2, 15, 10 };

		HouseRobberWithHousesInCircle obj = new HouseRobberWithHousesInCircle();
		int result = -1;
		// Time : O(n), Space : O(1)

		result = obj.houseRobberWithMaxAmount(a);
		System.out.println(result);

	}

}
