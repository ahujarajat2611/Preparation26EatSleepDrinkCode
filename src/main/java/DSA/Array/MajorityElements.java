package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class MajorityElements {
    public List<Integer> majorityElementBruteForce(int[] nums) {
        Map<Integer, Integer> counterMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (counterMap.containsKey(nums[i])) {
                counterMap.put(nums[i], counterMap.get(nums[i]) + 1);
            } else {
                counterMap.put(nums[i], 1);
            }
        }
        int size = nums.length;
        List<Integer> result = new ArrayList<>();
        for (Integer i : counterMap.keySet()) {
            int threshold = size / 3;
            if (counterMap.get(i) > threshold) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> majorityElementMoreThanNBy3(int[] a) {
        List<Integer> res = new ArrayList<>();
        int cand1 = 0, cand2 = 0, c1 = 0, c2 = 0;

        for (int n : a) {
            if (n == cand1) {
                c1++;
                // v.imp
            } else if (n == cand2) {
                c2++;
                //v.imp
            } else if (c1 == 0) {
                cand1 = n;
                c1 = 1;
                //v.imp
            } else if (c2 == 0) {
                cand2 = n;
                c2 = 1;
                //v .imp
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int n : a) {
            if (n == cand1) {
                c1++;
            } else if (n == cand2) {
                c2++;
            }
        }
        if (c1 > a.length / 3) {
            res.add(cand1);
        }
        if (c2 > a.length / 3) {
            res.add(cand2);
        }
        return res;

    }
    public int majorityElementMoreThanN2(int[] a) {
        int count = 0, candidate = 0;
        for (int n : a) {
            if (candidate == n) {
                count++;
            } else if (count == 0) {
                candidate = n;
                count = 1;
            } else {
                count--;
            }
        }

        count = 0;
        for (int n : a) {
            if (n == candidate) {
                count++;
            }
        }
        return count > a.length / 2 ? candidate : -1;
    }


    //Given an array of integers and a number k, the majority number is the number
//that occurs more than 1/k of the size of the array. Find it.
//
//Note
//There is only one majority number in the array.
//
//Example
//For [3,1,2,3,2,3,3,4,4,4] and k = 3, return 3
//
//Challenge
//O(n) time and O(k) extra space
//
//*/
//
///*
//Thinking process:
//Very similar to Majority I, II, except
// we can use a HashMap to store information (value, count).
//Having a HashMap we have one advantage:
// when checking if current value matches any previously recorded val, just do a map.containsKey(val).
//When a pair in hashMap has count ==0, remove this pair.
//Note, to learn how to use iterator in HashMap.

    //Note: when map.containsKey(currVal) == false, the code checks map.size() == k before count-- perations. This is because:
//We first need to put k candidates into HashMap before we count-- from all of them. If map.size() < k, that means we still have free spot for candidate in the HashMap, so in this case we do: map.put(candidateKey, 1).
//
//*/
    public int majorityNumberMoreThanNk(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {//Found duplicates, count++
                map.put(num, map.get(num) + 1);
            } else if(map.size() == k) {
                //Enough candidates added, do count--
                Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    // See how are we rmeoving elements // heer
                     // i could have used
                    Map.Entry<Integer, Integer> entry = iter.next();
                    if (entry.getValue() - 1 == 0) {
                        iter.remove();
                    } else {
                        map.put(entry.getKey(), entry.getValue() - 1);
                    }
                }//While
            }
            else {
                map.put(num, 1);
            }
        }//For

        int result = 0;
        int max = 0;

        // Ideally have one more loop to and map to get actual count of those K elements and then get the answwer ... if //count i
        // more than nbyk

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
