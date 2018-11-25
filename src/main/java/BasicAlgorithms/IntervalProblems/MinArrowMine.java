package BasicAlgorithms.IntervalProblems;

/**
 * Created by hadoop on 28/2/18.
 */
import java.util.*;
public class MinArrowMine {


    public int findMinArrowShots(int[][] points) {
        if(points.length ==0){
            return 0;
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
        //Point p = new Point();
        int start = points[0][0];
        int end = points[0][1];
        int ans =  0;
        //System.out.println(p);
//        List<Point> list = new ArrayList<>();
        for(int i=1;i<points.length;i++){
            // jaise hi overlap nhi hoga .. if there is no overlap we need an arrow for this ...
            // ultimatlye question is finindg all non-overlap regions ...

            if(points[i][0]>end){
                // Point p1 = new Point();
                //p1.publish = p.publish;
                //p1.end = p.end;
                //list.add(p1);
                ans++;
                start = points[i][0];
                end = points[i][1];
            }
            else {
                //p.publish = points[i][0];
                end = Math.min(end,points[i][1]);
                //  System.out.println("p overlap"+p);
            }
        }
//        Point p1 = new Point();
        //p1.publish = p.publish;
        //p1.end = p.end;
        //list.add(p1);
        return ans+1;

    }
}