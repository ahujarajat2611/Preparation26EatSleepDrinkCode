package BasicAlgorithms.Sort;
import java.util.*;

/**
 * Created by hadoop on 15/1/18.
 */
public class Heaters {
        // ANother way to look at this problem its only findng floor and ceil and then min of this and with final max !!!
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(heaters);
            int result = Integer.MIN_VALUE;

            for (int house : houses) {
                int index = Arrays.binarySearch(heaters, house);
                if (index < 0) {
                    index = -(index + 1);
                }
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dist1, dist2));
            }

            return result;
        }


        public int findRadiusMine(int[] houses, int[] heaters) {
           // Arrays.sort(heaters);
            TreeSet<Integer> set = new TreeSet<>();
            for(int heater:heaters){
               set.add(heater);
            }
            int ans = 0;
            for(int house:houses){
                Integer floor = set.floor(house);
                Integer ceil = set.ceiling(house);
                System.out.println(floor);
                System.out.println(ceil);
                if(floor == null){
                    floor = Integer.MAX_VALUE;
                }
                if(ceil == null){
                    ceil = Integer.MAX_VALUE;
                }
                int localans = Math.min(Math.abs(house-floor),Math.abs(ceil-house));
                ans = Math.max(ans,localans);
            }
            return ans;
        }
    public static void main(String args[]){
        Heaters heaters = new Heaters();
        int []houses = {1,2,3};
        int []heater = {2};
        heaters.findRadiusMine(houses,heater);
      //  [1,2,3]
       //     [2]
    }
}
/*
public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int heater : heaters) tree.add(heater);
        for (int house : houses) {
            Integer closestHeater = 0, min = Integer.MAX_VALUE;
            if ((closestHeater = tree.floor(house)) != null)
                min = Math.min(min, house - closestHeater);
            if ((closestHeater = tree.ceiling(house)) != null)
                min = Math.min(min, closestHeater - house);
            radius = Math.max(radius, min);
        }
        return radius;
    }
 */
/*
The idea is to leverage decent Arrays.binarySearch() function provided by Java.

For each house, find its position between those heaters (thus we need the heaters array to be sorted).
Calculate the distances between this house and left heater and right heater, get a MIN value of those two values. Corner cases are there is no left or right heater.
Get MAX value among distances in step 2. It's the answer.
Time complexity: max(O(nlogn), O(mlogn)) - m is the length of houses, n is the length of heaters.
 */
