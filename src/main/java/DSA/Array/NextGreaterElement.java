package DSA.Array;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Stack;

/**
 * Created by hadoop on 26/10/17.
 */
import java.util.*;
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[i]>stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                hashMap.put(nums[i],-1);
            }
            else {
                hashMap.put(nums[i],stack.peek());
            }
            stack.push(nums[i]);

        }
        System.out.println(hashMap);
        int []ans = new int[findNums.length];
        for(int i=0;i<findNums.length;i++){
            ans[i] = hashMap.get(findNums[i]);
        }
        return ans;
    }
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer>list = new ArrayList<Integer>();
        for(int i=nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[i]>stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                list.add(0,-1);
            }
            else {
                list.add(0,stack.peek());
            }
            stack.push(nums[i]);
        }
        int []ans = new int[list.size()];
        int index=0;
        for(int a:list){
            ans[index++] = a;
        }
        return ans;
    }
    public int[] nextGreaterElementsFromFront(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int []ans = new int[n];
        for(int i=0;i<ans.length;i++){
            ans[i] =-1;
        }
        for(int i=0;i<2*nums.length;i++){
            while (!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
                ans[stack.pop()]=nums[i%n];
            }
            if(i<n){
                stack.push(nums[i]);
            }
        }
        return ans;
    }
    public int[] nextGreaterElementForward(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
        public static void main(String args[]){
        NextGreaterElement nextGreaterElement=  new NextGreaterElement();
      //  ConsoleWriter.printIntArray(nextGreaterElement.nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4}));
       // ConsoleWriter.printIntArray(nextGreaterElement.nextGreaterElements(new int[]{1,2,1}));
            System.out.println(nextGreaterElement.nextPermutation(12222333));
    }

    int nextPermutation(int n){
            char []array = String.valueOf(n).toCharArray();
            int ans = nextpermu(array);
            if(ans == -1){
                return -1;
            }
            Long finalAns= Long.valueOf(String.valueOf(array));
            if(finalAns>=Integer.MAX_VALUE){
                return -1;
            }
            return finalAns.intValue();
    }

    private int nextpermu(char[] array) {
        int breakpoint = -1;
        int i=0;
        for(i = array.length-2;i>=0;i--){
            if(array[i]<array[i+1]){
                for(int j = array.length-1;j>i;j--){
                    if(array[j]>array[i]){
                        breakpoint = j;
                        break;
                    }
                }
                break;
            }
            else if(i ==0) {
                return -1;
            }
        }
        if(breakpoint == -1){
            return -1;
        }
        System.out.println(breakpoint);
        char temp = array[i];
        array[i] = array[breakpoint];
        array[breakpoint]= temp;


        for(int p=0;p<array.length;p++){
            System.out.print(array[p]);
        }
        System.out.println();
        System.out.println(i+1);
        System.out.println(array.length-1);
        reverse(array,i+1,array.length-1);
        for(int p=0;p<array.length;p++){
            System.out.print(array[p]);
        }
        System.out.println();
        return 1;
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
            System.out.println("rev");
        }
    }
}
