package OldAttemptLearning.shirleyisnotageek;

import BasicAlgorithms.utils.ConsoleWriter;

/*
Maximum Gap
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Try to solve it in linear time/space.
Return 0 if the array contains less than 2 elements.
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
New LeetCode problem. The algorithm is referred from the application of Pigeonhole principle. It is beautiful, smart and very easy to understand.

Ah, that's why I love math (even though I am not good at it): it always solves the hard problem by the simplest principles.

Update: 2015 - 03 - 04
Briefly, the maximum gap between two successive integers must lie between the maximum number in one bucket and the minimum number in the next bucket.


 */
public class MaxGap {
    public int maximumGap(int[] nums) {
         if (nums == null || nums.length < 2)
             return 0;
         if (nums.length == 2) {
             return Math.abs(nums[0] - nums[1]);
         }
         int max = nums[0];
         int min = nums[0];
         int len = nums.length;
         for (int i = 0; i < len; i++) {
             max = Math.max(nums[i], max);
             min = Math.min(nums[i], min);
         }
         int[] max_buckets = new int[len - 1];
         int[] min_buckets = new int[len - 1];
         for (int i = 0; i < len - 1; i++) {
             max_buckets[i] = -1;
             min_buckets[i] = Integer.MAX_VALUE;
         }
         double interval = ((double)max - (double)min) / (double)(len - 1);
         for (int i = 0; i < len; i++) {
             if (nums[i] == max) {
                 max_buckets[len - 2] = nums[i];
                 continue;
             }
             int b = (int)((nums[i] - min) / interval);
             max_buckets[b] = Math.max(max_buckets[b], nums[i]);
             min_buckets[b] = Math.min(min_buckets[b], nums[i]);
         } 
          
         if (min_buckets[len - 2] == Integer.MAX_VALUE) {
             min_buckets[len - 2] = max;
         }
         int max_gap = 0;
         int index1 = len - 2, index2 = len - 3;
         while (index2 >= 0 && index1 > index2) {
             while (index2 >= 0 && max_buckets[index2] == -1) {
                 index2--;
             }
             while (index1 > index2 && min_buckets[index1] == Integer.MAX_VALUE) {
                 index1--;
             }
             max_gap = Math.max(max_gap, min_buckets[index1] - max_buckets[index2]);
             index2--;
             index1--;
         }
         return max_gap;
     }



/**
 * Created by hadoop on 17/10/17.
 */
    //http://opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
    int maxgapCountSortBased(int []num){
        int maxvalue = Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            maxvalue = Math.max(maxvalue,num[i]);
        }
        // we will use radix / count sort method to sort
        int radix = 10; // 10 base system

        int exp = 1; // 1, 10 , 100 .... digits
        while (maxvalue/exp >0){
            int []count = new int[radix];
            for(int i=0;i<num.length;i++){
                count[(num[i]/exp)%10]+=1;
            }
            for(int i=1;i<radix;i++){
                // addding up indexex to get the latest indexes of elements
                count[i] += count[i-1];
            }
            int aux[] = new int[num.length];

            for(int i=num.length-1;i>=0;i--){
                // System.out.println(count[(num[i]/exp)%10]);
                aux[--count[(num[i]/exp)%10]] = num[i];
            }
            for(int i=0;i<num.length;i++){
                num[i]= aux[i];
            }
            exp = exp*10;
        }
        int maxdif = Integer.MIN_VALUE;
        for(int i=1;i<num.length;i++){
            maxdif = Math.max(maxdif,num[i]-num[i-1]);
        }
        return maxdif;
    }
    /*


    http://opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
     int[] countingSort(int[] a, int k) {
        int c[] = new int[k];
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;
        for (int i = 1; i < k; i++)
            c[i] += c[i-1];
        int b[] = new int[a.length];
        for (int i = a.length-1; i >= 0; i--)
            b[--c[a[i]]] = a[i];
        return b;
    }
     */
    public static void main(String args[]){
        MaxGap countSort_radixSort = new MaxGap();
        System.out.println(countSort_radixSort.maxgapCountSortBased(new int[]{3,1,5,0,9,3,14}));
        System.out.println(countSort_radixSort.maxGap(new int[]{3,1,5,0,9,3,14}));
    }


    int maxGap(int []array){

        int maxvalue =Integer.MIN_VALUE;
        for(int x:array){
            maxvalue = Math.max(maxvalue,x);
        }

        int factor =1;

        while (maxvalue/factor >0){
            int []count = new int[10];
            for (int i=0;i<array.length;i++){
                count[(array[i]/factor)%10]+=1;
            }
            for(int i=1;i<10;i++){
                count[i] = count[i]+count[i-1];
            }

            int []result = new int[array.length];
            for(int i = array.length-1;i>=0;i--){
                result[--count[(array[i]/factor)%10]]  = array[i];
            }
            for(int i=0;i<array.length;i++){
                array[i]= result[i];
            }
            factor = factor*10;
        }

        ConsoleWriter.printArray(array);
        int max = Integer.MIN_VALUE;
        for(int i=1;i<array.length;i++){
            max = Math.max(max,array[i]-array[i-1]);
        }
        return max;
    }
}
