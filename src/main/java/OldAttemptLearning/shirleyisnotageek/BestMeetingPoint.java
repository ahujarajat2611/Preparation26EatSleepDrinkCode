package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
/*
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
For example, given three people living at (0,0), (0,4), and (2,2):
1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 */
/*
Naive solution can use
dfs to update all points and find the minimum distance.
 However, since we are dealing with Manhattan distance,

  we can solve the problem separately for two dimensions.
   Given one dimension, the shortest Manhattan distance for all
    points (sorted) is the middle point.
    So we can calculate the middle point for both x and y coordinates
     separately, then add them together.
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xCoords = new ArrayList<>();
        List<Integer> yCoords = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xCoords.add(i);
                    yCoords.add(j);
                }
            }
        }
        Collections.sort(xCoords);
        Collections.sort(yCoords);
        int mid = xCoords.size() / 2;
        int x0 = xCoords.get(mid);
        int y0 = yCoords.get(mid);
        int distance = 0;
        for (int i = 0; i < xCoords.size(); i++) {
            distance += Math.abs(xCoords.get(i) - x0);
            distance += Math.abs(yCoords.get(i) - y0);
        }
        return distance;
    }
}
