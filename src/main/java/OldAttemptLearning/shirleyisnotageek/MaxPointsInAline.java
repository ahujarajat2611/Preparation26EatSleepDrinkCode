package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
I don't think this one is a very hard one as long as all the conditions are considered:

1. duplicate points;
2. share lines parallel to y-axis;
3. share lines parallel to x-axis;
4. slopes.

Use a HashMap to store <slope, number of points> pair.
 */
public class MaxPointsInAline {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public class MaxPointsonALine {
        public int maxPoints(Point[] points) {
            if (points == null || points.length == 0)
                return 0;
            HashMap<Double,Integer> hm = new HashMap<Double,Integer>();
            int max = 1;

            for (int i = 0; i < points.length; i++)
            {
                //Reinitialize the map since the shared points of each point are different
                hm.clear();
                //put the point itself into the map, use Integer_MIN_VALUE as the key
                hm.put((double)Integer.MIN_VALUE, 1);
                //in case there are duplicates in the array
                int dupli = 0;
                //all the shared points prior to i has been checked in the previous loops, thus we only need to
                //consider shared points after i
                for (int j = i + 1; j < points.length; j++)
                {
                    //here comes the duplicates
                    if (points[j].x == points[i].x && points[j].y == points[i].y)
                    {
                        dupli++;
                        continue;
                    }
                    double key = 0.0;
                    //share a line parallel to y-axis, we know the slop = infinity
                    if (points[j].x == points[i].x)
                        key = (double)Integer.MAX_VALUE;
                        //just the slope
                        // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                        // problem
                    else
                        key = 0.0 +
                                (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                    if (!hm.containsKey(key))
                        hm.put(key, 2);
                    else
                        hm.put(key, hm.get(key) + 1);

                }
                //now we add duplicates to the values in the map and compare them with the max
                for (int tmp : hm.values())
                {
                    if (tmp + dupli > max)
                        max = tmp + dupli;
                }
            }
            return max;
        }
    }
}
