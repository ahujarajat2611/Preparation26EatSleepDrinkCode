package BasicAlgorithms.Array;

/**
 * Created by hadoop on 26/10/17.
 */
public class SplitArrayLargestSum {
    // possible to find continous split with max
    // vlau
    // lets assume that is answer ...
    // we alsways assume ans and check if this ans is rigth or not
    // and then try to adjust ans .. using binary seaerch tecniquee

    private boolean canSplit(int []nums,int maxvalue,int partitions){
        int count = 1;
        int sum = 0;
        for(int a:nums){
            sum = sum +a;
            if(sum>maxvalue){
                sum = a;
                count= count+1;
            }
            if(count>partitions){
                return false;
            }
        }
        return true;
    }

    public int splitArray(int []nums, int partitions){
        if(nums.length ==0){
            return 0;
        }
        int low = maxvalue(nums);
        int high = totalsum(nums);
        while (low<high){
            int mid = (low + high)/2;
            if(canSplit(nums,mid,partitions)){
                high = mid;
            }
            else {
                low = mid +1;
            }
        }
        return low;
    }

    private int totalsum(int[] nums) {
        int sum =0;
        for(int a:nums){
            sum = sum + a;
        }
        return sum;
    }


    private int maxvalue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int a:nums){
            max = Math.max(max,a);
        }
        return max;
    }
    public int splitArrayDp(int[] nums, int m) {
        if (nums.length == 0 || nums == null || m == 0)
            return Integer.MAX_VALUE;
        return splitArray(nums, m, 0);
    }

    public int splitArray(int[] nums, int m, int start) {
        if (nums.length == 0 || nums == null || m == 0)
            return Integer.MAX_VALUE;
        if (start > nums.length)
            return Integer.MAX_VALUE;
        if (m == 1) {
            int sum = 0;
            for (int i = start; i < nums.length; i++)
                sum += nums[i];
            return sum;
        }
        int sum = 0;
        int split = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            split = Math.max(sum, splitArray(nums, m - 1, i + 1));
            min = Math.min(min, split);
        }
        return min;
    }

}
/*
M(i,j) gives us maximum number in the range (i to j)
Opt(i,j):- MIN sum starting from i into j partitions
opt(1,m) ans ...
opt(1,m) - one parttion means maximum value = M(1,n)

opt(i,j) :- for(k ->i to length of array){
                min(M((i, K) + opt(k+1,j-1)) where k ranges from i to n-j
}





public int splitArray(int[] nums, int m) {
	if (nums.length == 0 || nums == null || m == 0)
		return Integer.MAX_VALUE;
	return splitArray(nums, m, 0);
}

public int splitArray(int[] nums, int m, int publish) {
	if (nums.length == 0 || nums == null || m == 0)
		return Integer.MAX_VALUE;
	if (publish > nums.length)
		return Integer.MAX_VALUE;
	if (m == 1) {
		int sum = 0;
		for (int i = publish; i < nums.length; i++)
			sum += nums[i];
		return sum;
	}
	int sum = 0;
	int split = 0;
	int min = Integer.MAX_VALUE;
	for (int i = publish; i < nums.length; i++) {
		sum += nums[i];
		split = Math.max(sum, splitArray(nums, m - 1, i + 1));
		min = Math.min(min, split);
	}
	return min;
	Define M[n, k] to be the minimum possible cost over all
partitionings of {s1, . . . , sn} into k ranges, where the cost of
a partition is the largest sum of elements in one of its parts.
Thus defined, this function can be evaluated:
M[n, k] =
n
min
i=1
max(M[i, k − 1],
X
n
j=i+1
sj)
with the natural basis cases of
M[1, k] = s1, for all k > 0 and,
M[n, 1] =
X
n
i=1
s
}
 */
/*
 Let consider d[ i ][ j ] is solution of the problem when S = {s1, ..., si } and k = j. So it is easy to see that:

d[ 0 ][ j ] = 0 for each j from 1 to k
d[ i ][ 1 ] = sum(s1...si) for each i from 1 to n
d[ i ][ j ] = minfor t = 1 to i (max ( d[i - t][j - 1], sum(si - t + 1...si)) for i = 1 to n and j = 2 to k
Now let's see why this works:

When there is no elements in the sequence it is clear that only one interval there can be (an empty one) and sum of its elements is 0. That's why d[ 0 ][ j ] = 0 for all j from 1 to k.
When only one interval there can be, it is clear that solution is sum of all elements of the sequence. So d[ i ][ 1 ] = sum(s1...si).
Now let's consider there are i elements in the sequence and number of intervals is j, we can assume that last interval is (si - t + 1...si) where t is positive integer not greater than i, so in that case solution is max ( d[i - t][j - 1], sum(si - t + 1...si), but as we want the solution be minimal we should chose t such to minimize it, so we will get minfor t = 1 to i (max ( d[i - t][j - 1], sum(si - t + 1...si)).
Example:

S = (5,4,1,12), k = 2

d[0][1] = 0, d[0][2] = 0

d[1][1] = 5, d[1][2] = 5

d[2][1] = 9, d[2][2] = 5

d[3][1] = 10, d[3][2] = 5

d[4][1] = 22, d[4][2] = 12

Code:

#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

int main ()
{
    int n;
    const int INF = 2 * 1000 * 1000 * 1000;
    cin >> n;
    vector<int> s(n + 1);
    for(int i = 1; i <= n; ++i)
        cin >> s[i];
    vector<int> first_sum(n + 1, 0);
    for(int i = 1; i <= n; ++i)
        first_sum[i] = first_sum[i - 1] + s[i];
    int k;
    cin >> k;
    vector<vector<int> > d(n + 1);
    for(int i = 0; i <= n; ++i)
        d[i].resize(k + 1);
    //point 1
    for(int j = 0; j <= k; ++j)
        d[0][j] = 0;
    //point 2
    for(int i = 1; i <= n; ++i)
        d[i][1] = d[i - 1][1] + s[i]; //sum of integers from s[1] to s[i]
    //point 3
    for(int i = 1; i <= n; ++i)
        for(int j = 2; j <= k; ++j)
        {
            d[i][j] = INF;
            for(int t = 1; t <= i; ++t)
                d[i][j] = min(d[i][j], max(d[i - t][j - 1], first_sum[i] - first_sum[i - t]));
        }


    cout << d[n][k] << endl;
    return 0;*/
/*
public int maxProfit(int[] prices) {
    return dfs(prices, 2);
}
private int dfs(int[] prices, int pos, int k) {
    if (k == 0 || pos == prices.length)
        return 0;
    int min = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = pos; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        int diff = prices[i] - min;
        if (diff > 0) {
            diff += dfs(prices, i+1, k-1);
        }
        profit = Math.max(profit, diff);
    }
    return profit;
}
 */