package BasicAlgorithms.Array;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Arrays;

/**
 * Created by hadoop on 5/12/17.
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {

        int maxpro[] = new int[nums.length];
        int minpro[] = new int [nums.length];
        maxpro[0] = nums[0];
        minpro[0] = nums[0];

        int max = nums[0];
        int []a = nums;
        for(int i=1;i<nums.length;i++){
            maxpro[i] = Math.max(Math.max(maxpro[i-1]*a[i],minpro[i-1]*a[i]),a[i]);
            minpro[i] = Math.min(a[i],Math.min(minpro[i-1]*a[i],maxpro[i-1]*a[i]));
            max = Math.max(maxpro[i],Math.max(max,minpro[i]));
        }
        //ConsoleWriter.printIntArray(maxpro);
        //ConsoleWriter.printIntArray(minpro);
        return max;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{-1,-2,-9,6,0,109}));
        System.out.println(maxProductagain(new int[]{-1,-2,-9,-6,0,45,87}));
    }
    public static int maxProductagain(int[] nums) {

        int maxpro[] = new int[nums.length];
        int minpro[] = new int [nums.length];
        maxpro[0] = nums[0];
        minpro[0] = nums[0];

        int max = nums[0];
        int []a = nums;
        for(int i=1;i<nums.length;i++){
            maxpro[i] = Math.max(a[i],Math.max(maxpro[i-1]*a[i],minpro[i-1]*a[i]));
            minpro[i] = Math.min(a[i],Math.min(minpro[i-1]*a[i],maxpro[i-1]*a[i]));
            max = Math.max(maxpro[i],Math.max(max,minpro[i]));
        }
        return max;
    }
}
