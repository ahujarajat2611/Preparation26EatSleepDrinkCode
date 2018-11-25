package BasicAlgorithms.Array;

import java.util.*;

/**
 * Created by hadoop on 16/12/17.
 */
public class PracticeArrays {
    // simple
    void checkForPairsWithSum(int a[], int n, int sum) {
        Arrays.sort(a);
        int l = 0, r = n - 1, t;
        while (l < r) {
            t = a[l] + a[r];
            if (t == sum) {
                System.out.println(a[l] + "," + a[r]);
            } else if (sum > t) {
                l++;
            } else {
                r--;
            }
        }
    }
    void checkForPairWithSumK(int a[], int n, int k) {
        boolean map[] = new boolean[100000];

        int temp;
        for (int i = 0; i < n; i++) {
            temp = k - a[i];
            if (temp >= 0 && map[temp] == true) {
                System.out.println("1st=" + a[i] + ",2nd=" + temp);
            }
            map[a[i]] = true;
        }
    }

    int findMajority(int a[], int n) {
        if (n <= 0)
            return -1;
        int count = 0, candidate = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                candidate = a[i];
            } else {
                if (candidate == a[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        // mandatory check
        count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == candidate) {
                count++;
            }
        }
        return count > n / 2 ? candidate : -1;
    }
    int findNumberOccuringOddNumberOfTimes(int a[], int n) {
        if (n <= 0)
            return -1;
        int x = a[0];
        for (int i = 1; i < n; i++) {
            x = x ^ a[i];
        }
        return x;
    }
    int largestContiguousSumUsingDp(int a[], int n) {
        int sum[] = new int[n];
        sum[0] = a[0];
        int max = sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + a[i], a[i]);
            max = Math.max(sum[i], max);
        }
        return max;
    }
    KadaneResult largestContiguousSumUsingKadane(int a[], int n) {
        int maxSum = 0;
        int maxStart = -1;
        int maxEnd = -1;

        int curSum = 0;
        int curStart = 0;

        for (int i = 0; i < n; i++) {
            curSum += a[i];
            if (curSum < 0) {
                curSum = 0;
                curStart = i + 1;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                maxStart = curStart;
                maxEnd = i;
            }
        }
        return new KadaneResult(maxSum, maxStart, maxEnd);
    }
    public int findMin(int[] nums) {
        int lo =0;
        int hi = nums.length-1;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] <=nums[hi]){
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }
        return nums[lo];

    }
    public int findMinRepeat(int[] nums) {
        int lo =0;
        int hi = nums.length-1;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] <=nums[hi]){
                if(nums[mid]<nums[hi]) {
                    hi = mid;
                }
                else {
                    hi--;
                }
            }
            else {
                lo = mid+1;
            }

        }
        return nums[lo];
    }
    private int searchRotatedrray(int []nums,int start,int end,int target){
        if(end<start){
            return -1;
        }
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=nums[end]){
                if(nums[mid]<target && target<=nums[end]){
                    start = mid +1;
                }
                else{
                    end = mid;
                }

            }
            else{
                if(nums[start]<=target && target<=nums[mid]){
                    end = mid;
                }
                else{
                    start = mid +1;
                }
            }
        }
        if(nums[start] == target){
            return start;
        }
        return -1;
    }
    int maxSumNonAdjascnent(int a[], int n) {
        if (n <= 0)
            return -1;
        int incl = a[0], excl = 0, temp;

        if (n == 1)
            return incl;

        for (int i = 1; i < n; i++) {
            temp = incl;
            // keep a not selection of exclude or not ...... vmimp

            /// check previous exclude sum ( since tht might be too negative, i will publish afresh ... thats the logic
            // vimppp
            // int temp = include
            // incl = num + exclde,num
            // excide = tem;
            incl = Math.max(excl + a[i], a[i]);
            excl = temp;
        }
        return incl;
    }
    void rotateArray(int a[], int n, int d) {
        reverse(a, 0, d - 1);
        reverse(a, d, n - 1);
        reverse(a, 0, n - 1);
    }
    void reverse(int a[], int l, int r) {
        while (l <= r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void leadersInArray(int a[], int n) {
        if (n <= 0)
            return;
        if (n == 1) {
            System.out.println(a[0]);
            return;
        }

        int maxFromRight = a[n - 1];
        System.out.print(a[n - 1] + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > maxFromRight) {
                maxFromRight = a[i];
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }
    public void sortArrayByFrequency(int a[], int n) {
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(i, a[i], 1);
        }
        Arrays.sort(elements, new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                if (e1.val == e2.val)
                    return e1.index - e2.index;
                return e1.val - e2.val;
            }
        });
        for (int i = 1; i < n; i++) {
            if (elements[i].val == elements[i - 1].val) {
                elements[i].freq = elements[i - 1].freq + 1;
                elements[i].index = elements[i - 1].index;
                elements[i - 1].freq = -1;
                // remove elements whose frequency is less .. kinda ..

            }
        }
        Arrays.sort(elements, new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                if (e1.freq == e2.freq)
                    return e1.index - e2.index;
                return e2.freq - e1.freq;
            }
        });
    }
    /*
    #include<iostream>
using namespace std;

int merge(int *a,int s,int e){
	int mid = (s+e)/2;
	int i = s;
	int j = mid+1;
	int k = s;
	int temp[1000];

	int invs = 0;

	while(i<=mid && j<=e){
		if(a[i]<=a[j]){
			temp[k++] = a[i++];
		}
		else{
			temp[k++] = a[j++];
			//This is important
			invs += (mid - i + 1);
		}
	}

	while(i<=mid){
		temp[k++] = a[i++];
	}
	while(j<=e){
		temp[k++] = a[j++];
	}
	//Copy the elements to original array a
	for(int i=s;i<=e;i++){
		a[i] = temp[i];
	}
	return invs;
}

int invCount(int *a,int i,int j){
	if(i>=j){
		return 0;
	}
	//Othewise
	int mid = (i+j)/2;
	int ans = invCount(a,i,mid) + invCount(a,mid+1,j) + merge(a,i,j);
	return ans;
}




int main(){

	int a[ ] = {5,3,1,2};
	int n = 4;

	cout<<invCount(a,0,n-1)<<endl;
	return 0;
}
     */
    // Given is unsorted array
    // Time : O(nlogn), Space: O(1)
    public void twoElementsSumCloseToZero(int a[], int n) {
        Arrays.sort(a);

        int l = 0, r = n - 1;
        int minX = -1, minY = -1;
        int minSum = Integer.MAX_VALUE, sum;
        while (l < r) {
            sum = a[l] + a[r];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minX = a[l];
                minY = a[r];
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("minX=" + minX + ",minY=" + minY);
    }
    public void findSmallestandSecondSmallestInSingleTraversal(int a[], int n) {
        int min1, min2;
        min1 = min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < min1) { //// taking care of equal cases ./// must
                min2 = min1;
                min1 = a[i];
                /// taking care of equals case of two same min vlaues ...
            } else if (a[i] < min2 && a[i] != min1) {
                min2 = a[i];
            }
        }
    }
    public boolean isMajorityInSortedArray(int a[], int n, int key) {
        int p = binarySearchForFirstOccurenceOfKey(a, 0, n - 1, key);
        if (p >= 0) {
            int k = p + n / 2;
            if (k < n && a[k] == key)
                return true;
        }
        return false;
    }

    private int binarySearchForFirstOccurenceOfKey(int[] a, int i, int i1, int key) {
        return 0;
    }

    public Pair getMinMaxInSingleTraversalUsingPairsMethod(int a[], int n) {
        if (n <= 0)
            return null;
        int max, min, i;
        if (n % 2 == 0) {
            if (a[1] > a[0]) {
                max = a[1];
                min = a[0];
            } else {
                max = a[0];
                min = a[1];
            }
            i = 2;
        } else {
            min = max = a[0];
            i = 1;
        }
        while (i < n - 1) {
            if (a[i] > a[i + 1]) {
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i + 1] < min) {
                    min = a[i + 1];
                }
            } else {
                if (a[i + 1] > max) {
                    max = a[i + 1];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }
            i = i+2;
        }

        return new Pair(max, min);
    }
    public void segregate0s1s(int a[], int n) {
        if (n <= 0)
            return;
        int l = 0, r = n - 1;
        while (l < r) {
            while (a[l] == 0 && l < r) {
                l++;
            }
            while (a[r] == 1 && l < r) {
                r--;
            }
            if (l < r) {
                swap(a, l, r);
                l++;
                r--;
            }
        }
    }
    public static int kthlargest(int []array,int k,int start,int end){

        if(end<start){
            return -1;
        }
        if(start == end){
            return array[start];
        }
        int partition = getpartition(array,k,start,end);
        if(partition-start +1 == k){
            return array[partition];
        }
        if(partition-start+1 >k){
            System.out.println("publish"+start);
            System.out.println("partition"+partition);
            return kthlargest(array,k,start,partition-1);
        }
        else {
            return kthlargest(array,k-partition-1+start,partition+1,end);
        }
    }

    private static int getpartition(int[] array, int k, int start, int end) {
        int middle = start;
        int startIndex = start;
        int endIndex = end;
        int pivot = array[start +(end - start)/2];
        while (middle<=endIndex){
            if(array[middle] == pivot){
                middle++;
            }
            else if(array[middle]<pivot){
                swap(array,startIndex,middle);
                startIndex++;
                middle++;
            }
            else if(array[middle]>pivot){
                swap(array,endIndex,middle);
                endIndex--;
            }
        }
        return startIndex;
    }
    public int maxDiff(int[] a, int n) {
        if (n <= 0)
            return -1;
        int maxDiff = Integer.MIN_VALUE;
        int minSoFar = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - minSoFar > maxDiff) {
                maxDiff = a[i] - minSoFar;
            }
            if (a[i] < minSoFar) {
                minSoFar = a[i];
            }
        }
        return maxDiff;
    }

    // maxdifffff so either travel frm front or last accordingly
    public int maxDiffVariation2(int[] a, int n) {
        if (n <= 0)
            return -1;
        int maxDiff = Integer.MIN_VALUE;
        int maxSoFar = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (maxSoFar - a[i] > maxDiff) {
                maxDiff = maxSoFar - a[i];
            }
            if (a[i] > maxSoFar) {
                maxSoFar = a[i];
            }
        }
        return maxDiff;
    }
    public void productArray(int a[], int n) {
        int left[] = new int[n];
        int right[] = new int[n];
        int prod[] = new int[n];
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = a[i - 1] * left[i - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            right[j] = right[j + 1] * a[j + 1];
        }

        for (int i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];
        }
    }
    // same as sgregate 0 and 1 .. Quite same
    public void segregateEvenAndOdd(int[] a, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && a[l] % 2 == 0) {
                l++;
            }
            while (l < r && a[r] % 2 != 0) {
                r--;
            }
            if (l < r) {
                swap(a, l, r);
                l++;
                r--;
            }
        }
    }
    // range 1 to n
    public void findTwoRepeatingNumbersUsingSignChange(int[] a, int n) {
        int index;
        for (int i = 0; i < n; i++) {
            /// taking absss is important
            // infact very imp
            index = Math.abs(a[i]) - 1; // mod index if vlaue is negative then repeated if positive make it negative
            if (a[index] < 0) {
                System.out.println("Repeated : " + (index + 1));
            } else {
                a[index] = -a[index];
            }
        }
    }
    public void findTwoRepeatingNumbers(int[] a, int n) {

        //CommonUtil.printArray(a);
        for (int i = 0; i < n; i++) {
            int index = (a[i]-1)%n;
            a[index]+=n;
            //	a[(a[i] - 1) % n] += n;
        }
        //CommonUtil.printArray(a);
        for (int i = 0; i < n; i++) {
            if (a[i] / n > 1) {
                System.out.println("Repeated : " + (i + 1));
            }
        }
    }
    public void segregate0s1s2sInSinglePass(int[] a, int n) {
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    swap(a, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a, mid, high);
                    high--;
            }
        }
    }
    public void rotateImageBy90degrees(int[][] a, int m, int n) {
        int t[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[j][m - i - 1] = a[i][j];
            }
        }
    }
    public void findEqulibriumIndexWithoutExtraSpace(int[] a, int n) {
        int sum = 0;
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        for (int i = 0; i < n; i++) {
            sum -= a[i];
            if (leftSum == sum) {
                System.out.println("Equlibrium Index : " + i);
            }
            leftSum += a[i];
        }
    }
    public String compressString(String str, int n) {
        char pre = str.charAt(0);
        int count = 1;
        char curr;
        StringBuilder ans = new StringBuilder();
        for(int i=1;i<str.length();i++){
            curr = str.charAt(i);
            if(curr == pre){
                count++;
                continue;
            }
            else {
                ans.append(pre);
                if(count>1){
                    ans.append(count);
                    count =1;
                }
                // keep movng until hit not matched
                // simply assign preivuos value
                pre = curr;
            }
        }
        ans.append(pre);
        if(count>1){
            ans.append(count);
        }
        return ans.toString();
    }
    public int reverseInteger(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + (n % 10);
            n = n / 10;
        }
        return rev;
    }
    public char findMostFrequentCharacter(char[] a, int n) {
        int t[] = new int[256];
        for (int i = 0; i < n; i++) {
            t[a[i]]++;
        }
        int maxCount = 0;
        char frequentChar = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > maxCount) {
                maxCount = t[i];
                frequentChar = (char) i;
            }
        }
        return frequentChar;
    }
    public int findLargestPairSumInArray(int a[], int n) {
        if (n < 2)
            return Integer.MIN_VALUE;
        int firstMax, secondMax;
        firstMax = a[0];
        secondMax = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (a[i] > firstMax) {
                secondMax = firstMax;
                firstMax = a[i];
                // here we can afford to have equality since max sum looking for

            } else if (a[i] > secondMax) {
                secondMax = a[i];
            }
        }
        return firstMax + secondMax;
    }
    public void findCommonElementsInThreeSortedArrays(int a[], int p, int b[], int q, int c[], int r) {
        int i, j, k;
        i = j = k = 0;
        while (i < p && j < q && k < r) {
            if (a[i] == b[j] && b[j] == a[k]) {
                System.out.print(a[i]);
                i++;
                j++;
                k++;
            }
            // move the smallest among all
            if (a[i] < b[j])
                i++;
            else if (b[j] < c[k])
                j++;
                // We reach here when x > y and z < y, i.e., z is smallest
            else
                k++;
        }
    }
    public void findPairSumCloseToK(int a[], int n, int k) {
        int l, r, x, y;
        l = 0;
        r = n - 1;

        int diff, minDiff = Integer.MAX_VALUE;
        x = y = Integer.MAX_VALUE;
        while (l < r) {
            diff = a[l] + a[r] - k;

            if (Math.abs(diff) < minDiff) {
                minDiff = diff;
                x = a[l];
                y = a[r];
            }
            // Classic use of diffffff variable
            // sum close to KKKKKKKKK
            // aweosme way it is to deal with such problem
            // take diff and counter its effect from the problem


            if (diff > 0)
                r--;
            else if (diff < 0)
                l++;
            else {
                System.out.println("x=" + x + ",y=" + y);
                return;
            }
        }
        System.out.println("x=" + x + ",y=" + y + ", diff = " + minDiff);
    }


    public void findPairSumCloseToKInTwoSortedArrays(int a[], int m, int b[], int n, int k) {
        int l1, r2, x, y;
        l1 = 0;
        r2 = n - 1;

        // first array from beginning
        // second array from end
        // pair of some close to K
        // take diff variable to take close k equation out of the picture

        int diff, minDiff = Integer.MAX_VALUE;
        x = y = Integer.MAX_VALUE;
        while (l1 < m && r2 >= 0) {
            diff = a[l1] + b[r2] - k;

            if (Math.abs(diff) < minDiff) {
                minDiff = diff;
                x = a[l1];
                y = b[r2];
            }

            if (diff > 0)
                r2--;
            else if (diff < 0)
                l1++;
            else {
                System.out.println("x=" + x + ",y=" + y);
                return;
            }
        }
        System.out.println("x=" + x + ",y=" + y + ", diff = " + minDiff);
    }
    // wiggle sort different techinie
    // increment by 2
    // i , i-1
    // i , i +1
    // publish one ahead , stop one before
    public void wiggleSort(int a[], int n) {
        for(int i=1;i<n-1;i+=2){
            if(a[i]<a[i-1]){
                swap(a,i,i-1);
            }
            if(a[i]<a[i+1]){
                swap(a,i,i+1);
            }
        }
        for (int i = 1; i < n - 1; i += 2) {
            if (a[i] < a[i - 1])
                swap(a, i, i - 1);
            if (a[i] < a[i + 1])
                swap(a, i, i + 1);

        }
    }
    public void sortArrayInWaveformUsingSorting(int a[], int n) {
        Arrays.sort(a);
        for (int i = 0; i < n - 1; i += 2) {
            swap(a, i, i + 1);
        }
    }
    public boolean checkForDuplicatesWithInKDistance(int a[], int n, int k) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            if (set.contains(a[i])) {
                return true;
            } else {
                set.add(a[i]);
                if (i >= k) {
                    // the moment set has k+1 element just remove it
                    // set alwayss should have kkkkk elemnets to check
                    // remove element whene siize of set is k + 1
                    // when i ==k we have added element hence since increaded by 1
                    // remove element from the set !!!1
                    set.remove(a[i - k]);
                }
            }
        }

        return false;
    }
    public boolean subArraysOfSumZero(int a[], int n) {
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (a[i] == 0 || sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
    public int smallestSubarrayLengthWithSumGreaterThanK(int a[], int n, int k) {
        int sum = 0;
        int l = 0;
        int minSize, subArrLeft, subArrRight;
        minSize = subArrLeft = subArrRight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] > k) {
                subArrLeft = subArrRight = i;
                return 1;
            }
            sum += a[i];
            while (sum > k && l <= i) {
                if (i + l - 1 < minSize) {
                    minSize = i + l - 1;
                    subArrLeft = l;
                    subArrRight = i;
                }
                sum -= a[l++];
            }
        }
        return minSize;
    }
    public static int minsize(int s, int []nums){
        int minlength = Integer.MAX_VALUE;
        int right=0;
        int left=0;
        int sum = 0;

        while (right<nums.length){
            sum = sum + nums[right];
            while (sum>=s){
                sum = sum-nums[left];
                minlength = Math.min(minlength,right-left+1);
                left = left+1;
            }
            right++;
        }
        return minlength;
    }
    public int countAllPairsWithGivenDifferenceX(int[] a, int n, int x) {
        Arrays.sort(a);
        int count, l, r;
        l = r = count = 0;
        int d;
        while (r < n) {
            d = a[r] - a[l];
            if (d > x) {
                l++;
            } else if (d < x) {
                r++;
            } else {
                System.out.println("1st=" + a[l] + ",2nd=" + a[r]);
                l++;
                // r++;
                count++;
            }
        }
        return count;
    }
    public int[] merge(int a[], int m, int b[], int n) {
        int c[] = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < m) {
            c[k++] = a[i++];
        }

        while (j < n) {
            c[k++] = b[j++];
        }

        return c;
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
                //printSubarray(a, l, r);
                sum = 0;
                l = r + 1;
            }
        }
    }
    public int maxProfitWithKTransactions(int a[], int n, int k) {
        if (n <= 1)
            return 0;
        int t[][] = new int[k + 1][n];
        for (int i = 0; i < n; i++) {
            t[0][i] = 0;
        }
        for (int i = 0; i <= k; i++) {
            t[i][0] = 0;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int val = 0;
                for (int m = 0; m < j; m++) {
                    val = Math.max(a[j] - a[m] + t[i - 1][m], val);
                }
                t[i][j] = Math.max(t[i - 1][j], val);
            }
        }
        return t[k][n - 1];
    }
    public int maxProfitWithAnyNumberOfTransactions(int a[], int n) {
        if (n <= 1)
            return 0;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1])
                profit += a[i] - a[i - 1];
        }
        return profit;
    }
    public void sortArrayToFormBiggestNumber(int a[], int n) {
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.toString(a[i]);
        }

        Arrays.sort(s, sortByBiggestNumber);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }

    private Comparator<String> sortByBiggestNumber = new Comparator<String>() {
        public int compare(String s1, String s2) {
            String xy = s1 + s2;
            String yx = s2 + s1;


            // if returning + means shift to right in sorting order
            // if returned -- means shift to left side
            // so if s2s1 is bigger means s1 needs to shift to right
            // hence return 1
            return yx.compareTo(xy);
        }
    };
    public void sortKSortedArrayUsingAvl(int a[], int n, int k) {
        AVLTree tree = new AVLTree();
        for (int i = 0; i < k; i++) {
            tree.root = tree.insert(tree.root, a[i]);
        }
        int val, j = 0;
        for (int i = k; i < n; i++) {
            val = tree.findMin(tree.root).data;
            a[j++] = val;
            tree.root = tree.delete(tree.root, val);
            tree.root = tree.insert(tree.root, a[i]);
        }
        for (int i = 0; i < k; i++) {
            val = tree.findMin(tree.root).data;
            a[j++] = val;
            tree.root = tree.delete(tree.root, val);
        }
    }
    public void sortKSortedArray(int a[], int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //MinHeap<Integer> minHeap = new MinHeap<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(a[i]);
        }
        int val, j = 0;
        for (int i = k; i < n; i++) {
            val = minHeap.poll();
            a[j++] = val;
            minHeap.add(a[i]);
        }
        for (int i = 0; i < k; i++) {
            val = minHeap.poll();
            a[j++] = val;
            //minHeap.remove();
        }
    }
    public int minJumpsToReachEnd(int a[], int n) {
        if (n <= 0)
            return Integer.MAX_VALUE;
        int t[] = new int[n];

        if (a[0] <= 0)
            return Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            t[i] = Integer.MAX_VALUE;
        }
        t[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + a[j] >= i) {
                    t[i] = Math.min(t[i], 1 + t[j]);
                }
            }
        }
        return t[n - 1];
    }
    public int maxLengthOfBitonic(int a[], int n) {
        int lis[] = new int[n];
        int lds[] = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = lds[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                lis[i] = lis[i - 1] + 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                lds[i] = lds[i + 1] + 1;
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxLen = Integer.max(maxLen, lis[i] + lds[i] - 1);
        }
        return maxLen;
    }
    public void findMissingAndRepeating(int a[], int n) {
        int j;

        for (int i = 0; i < n; i++) {
            j = Math.abs(a[i]) - 1;
            if (a[j] < 0) {
                System.out.println("Repeating : " + (j + 1));
            } else {
                a[j] = -a[j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                System.out.println("Missing : " + (i + 1));
                return;
            }
        }
    }



}

class KadaneResult {

    int maxSum;
    int maxStart;
    int maxEnd;

    public KadaneResult(int maxSum, int maxStart, int maxEnd) {
        super();
        this.maxSum = maxSum;
        this.maxStart = maxStart;
        this.maxEnd = maxEnd;
    }

    @Override
    public String toString() {
        return "KadaneResult [maxSum=" + maxSum + ", maxStart=" + maxStart + ", maxEnd=" + maxEnd + "]";
    }

}
class HeapNode {
    int value;
    int listNumber;

    public HeapNode(int value, int listNumber) {
        super();
        this.value = value;
        this.listNumber = listNumber;
    }
}

class Pair {
    int max;
    int min;

    @Override
    public String toString() {
        return "Pair [max=" + max + ", min=" + min + "]";
    }

    public Pair(int max, int min) {
        super();
        this.max = max;
        this.min = min;
    }
}

class Elem {
    int value;
    int first;
    int second;

    public Elem(int value, int first, int second) {
        super();
        this.value = value;
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Elem [value=" + value + ", first=" + first + ", second=" + second + "]";
    }

}

class Element {
    int index;
    int val;
    int freq;

    public Element(int index, int val, int freq) {
        super();
        this.index = index;
        this.val = val;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Element [index=" + index + ", val=" + val + ", freq=" + freq + "]";
    }

}
