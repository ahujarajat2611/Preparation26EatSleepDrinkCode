package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class Candies {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        // scan from left to right
        int[] leftCandy = new int[ratings.length];
        leftCandy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftCandy[i] = leftCandy[i - 1] + 1;
            } else {
                leftCandy[i] = 1;
            }
        }
        // scan from right to left
        int rightCandy = 1;
        int numCandies = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                rightCandy += 1;
            } else {
                rightCandy = 1;
            }
            numCandies += Math.max(leftCandy[i], rightCandy);
        }
        return numCandies;
    }
}
