package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

*/
/*
Follow the above rule:
1. Loop over houses.
2. Start radius = 0, and find the minmimum feasible (when comparing, pick the larger distance becuase it'll cover both side of house)
3. Calculate abs value of distance, because house can be ahead of 1st heater, in middle of two heaters or after last heater.
4. Keep while loop for each heater, until the house-to-right-heater distance is at least equal to the left-heater-to-house.
*/
 import java.util.*;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int heaterIndex = 0;
        int radius = 0;
        int heatersLength = heaters.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int housePos = houses[i];
            // Keeps looping until this position status: leftHeaterPos - housePos - rightHeaterPos,
            // and the diff of two direction is at least equal
            // when equal, heaterIndex+1 beacuse it will be used to calculate the minimum feasible distance right after
            //// BAD CONDITION
            /// THATS THE USUAL TWO POINTERS APPORACH
            // THAT'S STRAIGHT FORWARD 2 POINTERS APPROACH
        // until condition is not valid !!! keep movingheaters
            // we move if current heater distance is more than next !!!!
            while (heaterIndex < heatersLength - 1 && Math.abs(heaters[heaterIndex + 1] - housePos) <= Math.abs(heaters[heaterIndex] - housePos)) {
                heaterIndex++;
            }
            // once you find consition then note down distance !!!
            // heaterPos will be exactly the one after current housePos, so use this as the radius
            radius = Math.max(radius, Math.abs(heaters[heaterIndex] - housePos));
        }
        return radius;
    }
}
