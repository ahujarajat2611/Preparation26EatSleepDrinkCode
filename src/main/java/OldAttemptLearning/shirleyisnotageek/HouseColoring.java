package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
House coloring problem
I ask my friends to throw me a practicing problem, here it is:

There are a row of houses, each house can be painted with three colors red, blue and green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. You have to paint the houses with minimum cost. How would you do it?

No doubt the first thought is DP. However, the trick is we cannot only create an array of costs because we cannot determine which color to print except for the first house.

The idea is:
cost[color0][house] = Math.min(cost[color1][house - 1], cost[color2][house - 2]) + houseCost[color0][house].

Now here is a follow up question: what if there are n colors? I don't know a good answer because all I can think of is to go through all cost of print different colors of house - 1 and find the minimum. But that will make the whole complexity O(mn), where m is the number of houses and n is the number of colors.
 */
    class HouseColoring {
        //assume rows are the cost of each color and columns are for each house
        public  int minCost(int[][] house){
            if(house == null || house.length == 0 ||house[0].length == 0)
                return -1;
            int cols = house[0].length;
            int[][] cost = new int[3][cols];
            for(int i = 0; i < 3; i++)
                cost[i][0] = house[i][0];
            for(int j = 1; j < cols; j++){
                cost[0][j] = Math.min(cost[1][j - 1], cost[2][j - 1]) + house[0][j];
                cost[1][j] = Math.min(cost[0][j - 1], cost[2][j - 1]) + house[1][j];
                cost[2][j] = Math.min(cost[0][j - 1], cost[2][j - 1]) + house[2][j];
            }
            return Math.min(cost[0][cols - 1], Math.min(cost[1][cols - 1], cost[2][cols - 1]));
        }
        public void main(String[] args) {
            int[][] house = new int[3][];
            house[0] = new int[] {1, 3, 2, 6, 7, 8, 9};
            house[1] = new int[] {5, 4, 1, 3, 9, 8, 10};
            house[2] = new int[] {7, 6, 1, 5, 8, 2, 3};
            System.out.println(minCost(house));
        }
    }
