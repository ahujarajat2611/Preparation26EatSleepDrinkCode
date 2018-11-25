package BasicAlgorithms.Array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by hadoop on 15/12/17.
 */
public class AllSubArraysProblem {
    public int maxAverageOfSubarraySizeK(int[] a, int n, int k) {
        int maxSum = Integer.MIN_VALUE;
        int maxStart = -1;
        int maxEnd = -1;

        int sum = 0;
        int start = 0;
        int i;
        for (i = 0; i < k; i++) {
            sum = sum + a[i];
        }
        maxSum = sum;
        maxStart = 0;
        maxEnd = k - 1;
        for (i = k; i < n; i++) {
            sum = sum + a[i] - a[start];
            if (sum > maxSum) {
                maxSum = sum;
                // not down its publish + 1( gotta give attention )
                maxStart = start + 1;
                maxEnd = i;
            }
            start++;
        }
        return maxSum;
    }

    public int maxSubArrayLen(int[] a, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        // index and just before starting index
        map.put(0,-1);

        int sum =0;
        int maxlength  =0;
        for(int i=0;i<a.length;i++){
            sum = sum +a[i];
            if(map.containsKey(sum-k)){
                // we finding largestttttt
                // if we had to find number
                // then we had to store the frequencies instead of  index
                // very nice
                maxlength = Math.max(maxlength,i-(map.get(k-sum)+1)-1);
            }
            else {
                map.put(sum,i);
            }
        }
        return maxlength;
    }
    //public class Solution {
        public int subarraySuma(int[] nums, int k) {
            int count = 0, sum = 0;
            HashMap < Integer, Integer > map = new HashMap < > ();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    // we getting how many arrays have that sum ..
                    // so that many ans we need to addd in our count variable
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    public boolean subArraysOfSumZero(int[] a, int n) {

        int sum = 0;
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (a[i] == 0 || sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
            System.out.println(set);
        }
        return false;
    }
    public int largestSubarrayWithEqual0s1s(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                a[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0,maxLen=0;
        map.put(0, -1);
        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i-map.get(sum));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    public int subarraySumCount(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int element : a) {
            sum += element;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int rst = max[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);//the nums[i] could just be the best option
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            rst = Math.max(rst, max[i]);
        }
        return rst;
    }
    public int maxProductAgain(int[] a) {
        if (a.length <= 0) {
            return 0;
        }
        int min, max, res;
        min = max = res = a[0];
        for (int i = 1; i < a.length; i++) {
            int curMax = Math.max(a[i], Math.max(a[i] * min, a[i] * max));
            int curMin = Math.min(a[i], Math.min(a[i] * min, a[i] * max));
            res = Math.max(curMax, res);
            max = curMax;
            min = curMin;
        }
        return res;
    }
    public int findMaxLength2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // the subarray starts from the beginning
        int sum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
    public void maxOfAllSubarraysOfSizeK(int a[], int n, int k) {

        Deque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for (int i = k; i < n; i++) {
            System.out.print(a[dq.peekFirst()] + " ");
            while (!dq.isEmpty() && i - dq.peekFirst() >= k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.println(a[dq.peekFirst()] + " ");

    }
    //		// Time : O(n), This works only for non-negative values

    public int findSubArraySum(int[] a, int n, int k) {
        int minLength = Integer.MAX_VALUE;

        if (n <= 0)
            return -1;
        int start = 0, sum = a[0];
        for (int i = 1; i <= n; i++) {

            while (sum > k && start < i - 1) {
                sum = sum - a[start];
                start++;
            }
            if (sum == k) {
                System.out.println("From=" + start + ",To=" + (i - 1) + " :: Sum=" + k);
                minLength = Math.min(minLength, (i - 1) - start + 1);

                sum -= a[start];
                start++;
            }
            if (i < n) {
                sum += a[i];
            }
        }

        if (sum == k) {
            System.out.println("From=" + start + ",To=" + (n - 1) + " :: Sum=" + k);
        }

        return minLength;
    }
    public int findSubArraySumSlidingWinMy(int[] nums, int n, int k) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end<nums.length){
            sum = sum + nums[end];
            while (sum >k){
                sum = sum - nums[start];
                start++;
            }
            if(sum == k) {
                System.out.println("publish" + start);
                System.out.println("end" + end);
                min = Math.min(min,end-start+1);
            }
            end++;
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }


    public int findSubArraySumBruteForce(int[] a, int n, int k) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum = a[i];
            if (sum == k) {
                minLength = Math.min(minLength, i - i + 1);
                // System.out.println("From=" + i + ",To=" + i + " :: Sum=" +
                // k);
            }
            for (int j = i + 1; j < n; j++) {
                sum += a[j];
                if (sum == k) {
                    minLength = Math.min(minLength, j - i + 1);
                    // System.out.println("From=" + i + ",To=" + j + " :: Sum="
                    // + k);
                }
            }

        }
        return minLength;
    }
    public int smallestSubArraysOfSumGreatherThanK(int[] a, int n, int k) {

        int sum = 0;
        int l = 0;
        int minSize = Integer.MAX_VALUE;
        int minSizeLeft = Integer.MAX_VALUE;
        int minSizeRight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] > k) {
                return 1;
            }
            sum += a[i];
            while (sum > k && l <= i) {
                if (i - l + 1 < minSize) {
                    minSize = i - l + 1;
                    minSizeLeft = l;
                    minSizeRight = i;
                }
                sum -= a[l++];
            }
        }
        if (minSize != Integer.MAX_VALUE)
            printSubarray(a, minSizeLeft, minSizeRight);

        return minSize;
    }
    public void subArraysOfSum2(int[] a, int k) {

        int l = 0, r = 0;
        int sum = a[r];

        while (true) {
            if (sum < k) {
                r++;
                if (r == a.length) {
                    return;
                }
                sum += a[r];
            } else if (sum > k) {
                sum -= a[l++];
            } else {
                printSubarray(a, l, r);
                sum = 0;
                l = r + 1;
            }
        }

    }

    // assumption is k >=1


    public int minSubArrayA(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int curMin = nums.get(0);
        int minRst = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            curMin = Math.min(nums.get(i), curMin + nums.get(i));
            minRst = Math.min(curMin, minRst);
        }
        return minRst;
    }
    public static int minsize(int s, int []nums){
        int minlength = Integer.MAX_VALUE;
        int right=0;
        int left=0;
        int sum = 0;

        while (right<nums.length){
            sum = sum + nums[right];
            while (sum>=s){
                minlength = Math.min(minlength,right-left+1);
                sum = sum-nums[left];
                left = left+1;
            }
            right++;
        }
        return minlength;
    }

    public void subArraysOfSum(int[] a, int k) {

        int sum = 0;
        int l = 0;

        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum > k && l <= r) {
                sum -= a[l++];
            }
            if (sum == k) {
                printSubarray(a, l, r);
                sum = 0;
                l = r + 1;
            }
        }
    }

    public int minimumSize_a(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++;
            }
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    // assumption is k >=1
    public void subArraysOfSumK(int[] a, int n, int k) {

        int sum = 0;
        int l = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                printSubarray(a, i, i);
                l = i + 1;
                sum = 0;
                continue;
            }

            sum += a[i];

            while (l <= i && sum > k) {
                sum -= a[l++];
            }

            if (sum == k) {
                printSubarray(a, l, i);
                sum = 0;
                l = i + 1;
            }

        }
    }

    private void printSubarray(int[] a, int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    private static int find_sum(int[] num) {
        int i=0;
        int total = 0;
        int maxlocal = 0;
        int minlocal = 0;
        int maxglobal=0;
        int minglobal=0;
        while(i<num.length){
            maxlocal = maxlocal+ num[i];
            minlocal = minlocal + num[i];
            total = total + num[i];

            if(maxlocal >maxglobal){
                maxglobal = maxlocal;
            }
            if(minlocal<minglobal){
                minglobal = minlocal;
            }
            if(minlocal>=0){
                minlocal =0;
            }
            if(maxlocal<0){
                maxglobal = 0;
            }
        }
        if(total - minglobal>maxglobal){
            return total-minglobal;
        }
        else {
            return maxglobal;
        }
    }
    private static int kadanesAlgoAgain(int[] rowsum) {
        int left[] = new int[rowsum.length];
        int currentmax = 0;
        int globalmax = 0;
        for (int i = 0; i < rowsum.length; i++) {
            if (i == 0) {
                left[i] = rowsum[i];
                currentmax = rowsum[i];
            } else {
                currentmax = Math.max(rowsum[i], currentmax + rowsum[i]);
                left[i] = Math.max(left[i - 1], currentmax);
            }
            globalmax = Math.max(globalmax, left[i]);
        }
        return globalmax;
    }
    public static int maxSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int rowsum[] = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {

                for (int k = 0; k < matrix[0].length; k++) {
                    rowsum[k] = rowsum[k] + matrix[j][k];
                }

                max = Math.max(max, kadanesAlgo(rowsum));
            }
        }
        return max;
    }

    private static int kadanesAlgo(int[] rowsum) {
        int left[] = new int[rowsum.length];
        int currentmax = 0;
        int globalmax = 0;
        for (int i = 0; i < rowsum.length; i++) {
            if (i == 0) {
                left[i] = rowsum[i];
                currentmax = rowsum[i];
            } else {
                currentmax = Math.max(rowsum[i], currentmax + rowsum[i]);
                left[i] = Math.max(left[i - 1], currentmax);
            }
            globalmax = Math.max(globalmax, left[i]);
        }
        return globalmax;
    }
//    Submatrix Sum
//    Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.
//
//    Example
//    Given matrix
//
//            [
//	  [1 ,5 ,7],
//              [3 ,7 ,-8],
//              [4 ,-8 ,9],
//              ]
//              return [(1,1), (2,2)]
//
//    Challenge
//    O(n3) time.
//if max sum asked then kadan's approach if zero asked then this approach

    public int[][] submatrixSum(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[][]{};
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int sum[][] = new int[rows + 1][columns + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int row1 = 1;
        int col1 = 2;
        int row2 = 2;
        int col2 = 3;
        int sumsub = getSum(row1, col1, row2, col2, sum);
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j <= rows; j++) {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                hashMap.put(0, 0);
                for (int k = 1; k <= columns; k++) {
                    int diff = sum[j][k] - sum[i][k];
                    if (hashMap.containsKey(diff)) {
                        // please see why are we doing this ... with index
                        return new int[][]{{i, hashMap.get(diff)}, {j - 1, k - 1}};
                    }
                }
            }
        }
        return new int[][]{{}};
    }
    public int[][] submatrixSumEasyMethod(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[][]{};
        }
        for(int i=0;i<matrix.length;i++){
            int []cumulativeRow = new int[matrix[0].length];
            for(int j=i;j<matrix.length;j++){

                for(int k =0;k<matrix[0].length;k++){
                    cumulativeRow[k] = cumulativeRow[k] + matrix[j][k];
                }
                int []ans = getAnsFromOneD(cumulativeRow);
                if(ans!=null){
                    return new int[][]{{i,ans[0]},{j,ans[1]}};
                }
            }
        }
        // how to return empry array
        //int []emptyarray = new int[]{};
        int [][]empty2darray = new int [][]{{}};
        return new int[][]{{}};
    }

    private int[] getAnsFromOneD(int[] cumulativeRow) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0;
        for(int i=0;i<cumulativeRow.length;i++){
            sum = sum +cumulativeRow[i];
            if(hm.containsKey(sum)){
                return new int[]{hm.get(sum)+1,i};
            }
            hm.put(sum,i);
        }
        return null;
    }


    private int getSum(int row1, int col1, int row2, int col2, int[][] sum) {
        return sum[row2 + 1][col2 + 1] + sum[row1][col1] - sum[row2][col1] - sum[row1][col2];
    }

    public static int[] sumZero(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum +nums[i];
            if(hm.containsKey(sum)){
                return new int[]{hm.get(sum)+1,i};
            }
            hm.put(sum,i);
        }
        return new int[]{};
    }
    private static kadaneResult Kadane(int array[]){
        int max = 0;
        int maxstart = -1;
        int maxend = -1;
        int currentstart = 0;
        int maxsofar = 0;
        for( int i=0;i<array.length;i++){
            maxsofar = maxsofar + array[i];
            if(maxsofar<0){
                maxsofar = 0;
                currentstart = i+1;
            }
            if(max <maxsofar){
                maxstart = currentstart;
                max = maxsofar;
                maxend = i;
            }
        }
        return new kadaneResult(max,maxstart,maxend);

    }
    static class kadaneResult{
        int maxsum;
        int start;
        int end;
        public kadaneResult(int maxsum,int start,int end){
            this.maxsum = maxsum;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "kadaneResult{" +
                    "maxsum=" + maxsum +
                    ", publish=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int toppedHeight = heights[stack.pop()];
                int width = 0;
                if (!stack.isEmpty()) {
                    width = i - stack.peek() - 1;
                } else {
                    width = i;
                }
                max = Math.max(max, toppedHeight * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int toppedHeight = heights[stack.pop()];
            int width = 0;
            if (!stack.isEmpty()) {
                width = heights.length - stack.peek() - 1;
            } else {
                width = heights.length;
            }
            max = Math.max(max, toppedHeight * width);
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[] histogram = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j]++;
                }
            }
            max = Math.max(max, largestRectangleArea(histogram));
        }
        return max;
    }

    public static int maxSumagain(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            int rowsum[] = new int[matrix[0].length];
            for(int j=0;j<matrix.length;j++){

                for(int k=0;k<matrix[0].length;k++){
                    rowsum[k] = rowsum[k]+matrix[j][k];
                }

                max = Math.max(max,kadanesAlgo(rowsum));
            }
        }
        return max;
    }

    private static int kadanesAlgoAga(int[] rowsum) {
        int left[] = new int[rowsum.length];
        int currentmax = 0;
        int globalmax = 0;
        for(int i=0;i<rowsum.length;i++){
            if(i ==0){
                left[i] = rowsum[i];
                currentmax = rowsum[i];
            }
            else {
                currentmax = Math.max(rowsum[i],currentmax +rowsum[i]);
                left[i] =Math.max(left[i-1],currentmax);
            }
            globalmax = Math.max(globalmax,left[i]);
        }
        return globalmax;
    }
    public static void kadanemin(int []temp){
        int currentMin =0;
        int globalMin = Integer.MAX_VALUE;
        int globalLeft = 0;
        int globalRight = 0;
        int localleft = 0;
        for(int i=0;i<temp.length;i++){
            currentMin = currentMin + temp[i];
            if(currentMin>0){
                currentMin = 0;
                localleft = i+1;
            }
            if(currentMin<globalMin){
                globalMin = currentMin;
                globalLeft = localleft;
                globalRight = i;
            }
        }
        System.out.println("Globalmin"+globalMin);
        System.out.println("Globalleft"+globalLeft);
        System.out.println("GlobalRight"+globalRight);
    }
    public static void kadanonedim( int [] temp){
        int max = Integer.MIN_VALUE;
        int startcolumn = -1;
        int startcolumntemp = 0;
        int endcolumn = -1;
        int maxsofar=0;

        for( int i=0;i<temp.length;i++){
            maxsofar = maxsofar +temp[i];
            if(maxsofar<0){
                maxsofar=0;
                startcolumntemp = i+1;
            }
            if(maxsofar>max){
                max = maxsofar;
                endcolumn = i;
                startcolumn = startcolumntemp;
            }
        }
//        return new kadane(startcolumn,endcolumn,max);
    }
    public void kadan(int []temp){
        int maxSum = Integer.MAX_VALUE;
        int curretSum = 0;
        for(int num:temp){
            curretSum = Math.max(curretSum+num,num);
            maxSum = Math.max(curretSum,maxSum);
        }
        System.out.println("Max Sum" +maxSum);
    }
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int curMin = nums.get(0);
        int minRst = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            curMin = Math.min(nums.get(i), curMin + nums.get(i));
            minRst = Math.min(curMin, minRst);
        }
        return minRst;
    }
    /*
        def minSubArrayLen(self, s, nums):
        total = l = 0
        res = len(nums) + 1

        for r, elem in enumerate(nums):
            total += elem
            while total >= s:
                res = min(res, r - l + 1)
                total -= nums[l]
                l += 1

        return res if res <= len(nums) else 0
     */

    public ArrayList<Integer> subarraySum(int []nums){
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            // to check sum s
            // check for sum-s in hashmap

            if(map.containsKey(sum)){
                int startIndex = map.get(sum)+1;
                int endIndex = i;
                result.add(startIndex);
                result.add(endIndex);
                return result;
            }
            map.put(sum,i);
        }
        return result;
    }
    public ArrayList<Integer> subarraySum(int[] nums,int sum) {
        HashMap<Integer,Integer> index = new HashMap<>();
        index.put(0,-1);
        int currsum = 0;
        for(int i =0;i<nums.length;i++){
            currsum = currsum + nums[i];
            if(index.containsKey(currsum-sum)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(index.get(currsum-sum)+1);
                list.add(i);
                return list;
            }
            index.put(currsum,i);
        }
        return null;
    }
    public int maxSubArray(ArrayList<Integer> list ,int k){

        int [][]sum = new int[k+1][list.size()+1];
        for(int i=1;i<=k;i++){
            for(int j=i-1;j<list.size();j++){
                int currentSum=0;
                int max = Integer.MIN_VALUE;
                for(int partition = j;partition>=i;partition--){
                    currentSum = Math.max(currentSum+list.get(partition),list.get(partition));
                    max = Math.max(max,currentSum);
                    sum[i][j] = Math.max(sum[i][j],sum[i-1][partition-1] +max);
                }
            }
        }
        return sum[k][list.size()-1];

    }
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++;
            }
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    // all positive number
    void findSubarray(int []num,int n,int sum){
        int windowsum = num[0];
        int low = 0;
        int high =0;
        int count =0;
        // low pointer
        // high pointer
        // take low pointer and then move forward forward high pointer ...
        // caluclutae some window andd see ...
        while (low<n){
            while(windowsum<sum && high<n) {
                high++;
                windowsum = windowsum + num[high];
            }
            if(windowsum == sum){
                System.out.println(low);
                // since we have incremented high
                System.out.println(high);
                //windowsum = windowsum-num[low];
                //low++;
            }
            // while (windowsum>sum && low<n) {
            windowsum = windowsum - num[low];
            low++;
            //}
        }
    }

    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < nums.length; ) {
            for (j = Math.max(j, i + 1); j < nums.length && nums[j] - nums[i] < k; ) {
                j++;
            }
            if (j < nums.length && nums[j] - nums[i] == k) ans++;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            i++;
            System.out.println("END"+j);
            System.out.println("START"+i);
        }
        return ans;
    }
    public int findPairsWorkingAndAccepted(int[] nums, int k) {

        // if( k ==0){
        //     HashSet<Integer> hash = new HashSet<Integer>();
        //     for(int x:nums){
        //         hash.add(x);
        //     }
        //     return nums.length-hash.size();
        // }
        int start = 0;
        int end = 0;
        if(nums.length==0 || nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        while (end < nums.length) {
            while (start < end && nums[end] - nums[start] > k) {
                start++;
            }
            if (start < nums.length && start !=end && nums[end] - nums[start] == k) {
                count++;
                while (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end++;
                }
            }
            end++;
        }
        return count;
    }


    /*
    public class MinSizeSubarraySumMorethans {
    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null){
            return 0;
        }
        int end =0;
        int publish = 0;
        int sum=0;
        int ans= Integer.MAX_VALUE;
        while (end<nums.length){
            sum = sum + nums[end];
            while (sum>=s){
                ans = Math.min(ans,end-publish+1);
                sum = sum-nums[publish];
                publish++;
            }
            end++;
        }
        return ans;
    }
}
     */
    public int maxSubArray(ArrayList<Integer> num){
        int len = num.size();
        int leftmax[]= new int[len];
        int leftmin[] = new int[len];

        int rightmax[] = new int[len];
        int rightmin[] = new int[len];
        int currentMax = 0;
        int currentMin = 0;
        for(int i=0;i<len;i++){
            currentMax = Math.max(currentMax+num.get(i),num.get(i));
            currentMin = Math.min(currentMin+num.get(i),num.get(i));
            if(i==0){
                leftmax[i] = currentMax;
                leftmin[i] = currentMin;
            }
            leftmax[i] = Math.max(leftmax[i-1],currentMax);
            leftmin[i] = Math.min(leftmin[i-1],currentMin);
        }

        return 0;
    }
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        int len = nums.size();
        int[] leftMax = new int[len];
        int[] leftMin = new int[len];
        int curMaxSum = 0;
        int curMinSum = 0;
        // scan from left to right
        for (int i = 0; i < len; i++) {
            curMaxSum = Math.max(curMaxSum + nums.get(i), nums.get(i));
            curMinSum = Math.min(curMinSum + nums.get(i), nums.get(i));
            if (i == 0) {
                leftMax[i] = curMaxSum;
                leftMin[i] = curMinSum;
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], curMaxSum);
                leftMin[i] = Math.min(leftMin[i - 1], curMinSum);
            }
        }
        // scan from right to left
        curMaxSum = 0;
        curMinSum = 0;
        int rightMax = 0;
        int rightMin = 0;
        int maxDiff = 0;
        for (int i = len - 1; i > 0; i--) {
            curMaxSum = Math.max(curMaxSum + nums.get(i), nums.get(i));
            curMinSum = Math.min(curMinSum + nums.get(i), nums.get(i));
            if (i == len - 1) {
                rightMax = curMaxSum;
                rightMin = curMinSum;
            } else {
                rightMax = Math.max(rightMax, curMaxSum);
                rightMin = Math.min(rightMin, curMinSum);
            }
            maxDiff = Math.max(
                    maxDiff,
                    Math.max(
                            Math.abs(leftMax[i - 1] - rightMin),
                            Math.abs(rightMax - leftMin[i - 1])));
        }
        return maxDiff;
    }
    public int maxSub2arrays(int []temp){
        int size = temp.length;
        int []left = new int[size];
        int []right = new int[size];
        int currentSum=0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<temp.length;i++) {
            currentSum = Math.max(temp[i], currentSum + temp[i]);
            maxSum = Math.max(currentSum, maxSum);
            left[i] = maxSum;
        }
        currentSum = 0;
        maxSum = Integer.MAX_VALUE;
        for(int i=temp.length-1;i>=0;i--){
            currentSum = Math.max(currentSum+temp[i],temp[i]);
            maxSum = Math.max(maxSum,currentSum);
            right[i] = maxSum;
        }
        maxSum = Integer.MIN_VALUE;
        for(int i=0;i<temp.length-1;i++){
            maxSum= Math.max(maxSum,left[i]+right[i+1]);
        }
        return maxSum;
    }
//    * Created by hadoop on 11/12/17.
//            * Thoughts:
//    Note: sub-array has order. It's not sub-set
//            1. On each index: decide to add with nums.get(i), to use the new lowest value nums.get(i). That means:
//    If the new value is negative (it has decresing impact on sum) and the sum is larger than new value, just use the new value.
//    In another case, if sum has been nagative, so sum + new value will be even smaller, then use sum.
// 2. Every time compare the currMin with the overall minimum value, call it minRst.
//            */
public int minSubArrayAgainx(ArrayList<Integer> nums) {
    if (nums == null || nums.size() == 0) {
        return 0;
    }
    int curMin = nums.get(0);
    int minRst = nums.get(0);
    for (int i = 1; i < nums.size(); i++) {
        curMin = Math.min(nums.get(i), curMin + nums.get(i));
        minRst = Math.min(curMin, minRst);
    }
    return minRst;
}
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = br.read();
        while (test-->0){
            String[] ar = br.readLine().split(" ");

            int n = Integer.parseInt(ar[0]);
            int []array = new int[n];

            int sum = Integer.parseInt(ar[1]);
            for(int i=0;i<n;i++){
                array[i] = br.read();
            }

        }
        //code
    }
}