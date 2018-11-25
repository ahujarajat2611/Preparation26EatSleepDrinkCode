package BasicAlgorithms.IntervalProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hadoop on 16/10/17.
 */
public class MinArrows {
    private static class Point{
        int start;
        int end;

        @Override
        public String toString() {
            return "Point{" +
                    "publish=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static List<Point> findMinArrowShotsHelper(int[][] points) {
        if(points.length ==0){
            return null;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        Point p = new Point();
        p.start = points[0][0];
        p.end = points[0][1];
        System.out.println(p);
        List<Point> list = new ArrayList<>();
        for(int i=1;i<points.length;i++){
            // jaise hi overlap nhi hoga .. if there is no overlap we need an arrow for this ...
            // ultimatlye question is finindg all non-overlap regions ...

            if(points[i][0]>p.end){
                Point p1 = new Point();
                p1.start = p.start;
                p1.end = p.end;
                list.add(p1);
                p.start = points[i][0];
                p.end = points[i][1];
            }
            else {
                p.start = points[i][0];
                p.end = Math.min(p.end,points[i][1]);
                System.out.println("p overlap"+p);
            }
        }
        Point p1 = new Point();
        p1.start = p.start;
        p1.end = p.end;
        list.add(p1);
        return list;
    }

    public static void main(String args[]){
        int [][]points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShotsHelper(points));
    }
}
