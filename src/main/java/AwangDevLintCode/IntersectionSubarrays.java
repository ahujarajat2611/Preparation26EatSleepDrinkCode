package AwangDevLintCode;

/**
 * Created by hadoop on 25/2/18.
 */
import java.util.*;
public class IntersectionSubarrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i])  + 1);
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                map.put(nums2[j], map.get(nums2[j]) - 1);
                if (!resultMap.containsKey(nums2[j])) {
                    // why there is a need to addd
                    // into the result map
                    // better we put into list directly !!!
                    resultMap.put(nums2[j], 1);
                } else {
                    resultMap.put(nums2[j], resultMap.get(nums2[j]) + 1);
                }
            }
        }

        int sum = 0;
        for (Integer e : resultMap.keySet()) {
            int count = resultMap.get(e);
            sum += count;
            for (int i = 0; i < count; i++) {
                list.add(e);
            }
        }
        // could have taken size from list straight forward !
        int[] result = new int[sum];
        for (int i = 0; i < sum; i++) {
            result[i] = (int) list.get(i);
        }
        return result;
    }
}
