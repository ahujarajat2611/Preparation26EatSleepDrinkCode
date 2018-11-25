package BasicAlgorithms.Greedy;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class Candy {
    // go from left and take care of condition
    // go frmo right and take care of condition
    // that simple it is
    // then take max of both and add
    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        int right[] = new int[ratings.length];

        left[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }
            else {
                left[i] =1;
            }
        }
        right[ratings.length-1] = 1;
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            else {
                right[i] = 1;
            }
        }
        int ans =0;

        for(int i=0;i<ratings.length;i++){
            ans = ans+ Math.max(left[i],right[i]);
        }
        return ans;
    }
    public int candy2(int[] score) {
        if (score == null || score.length == 0) {
            return 0;
        }

        int[] candies = new int[score.length];
        Arrays.fill(candies, 1);

        int left, right;
        int result = 0;
        for (int i = 0; i < score.length; i++) {
            left = right = candies[i];
            if (i > 0 && score[i] > score[i - 1]) {
                left = candies[i - 1] + 1;
            }
            if (i < score.length - 1 && score[i] > score[i + 1]) {
                right = candies[i + 1] + 1;
            }
            candies[i] = Math.max(left, right);
            result += candies[i];
        }
        System.out.println(Arrays.toString(candies));
        return result;
    }
}
