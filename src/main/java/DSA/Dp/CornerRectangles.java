package DSA.Dp;
import java.util.*;

/**
 * Created by hadoop on 24/12/17.
 */
public class CornerRectangles {
    private class Point{
        int c1;
        int c2;
        Point(int c1,int c2){
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (c1 != point.c1) return false;
            return c2 == point.c2;
        }

        @Override
        public int hashCode() {
            int result = c1;
            result = 31 * result + c2;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "c1=" + c1 +
                    ", c2=" + c2 +
                    '}';
        }
    }
    public int countCornerRectangles(int[][] grid) {
        Map<Point, Integer> count = new HashMap();
        int ans = 0;

        for(int []row:grid){
            for(int c1=0;c1<row.length;c1++){
                if(row[c1] ==1){
                    for(int c2 = c1+1;c2<row.length;c2++){
                        if(row[c2] ==1){
                            Point p = new Point(c1,c2);
                            System.out.println(p);
                            // first count wowww
                            ans = ans + count.getOrDefault(p,0);
                            System.out.println(ans);
                            // then add it wowwww wat a logic
                            count.put(p,count.getOrDefault(p,0)+1);
                        }
                    }
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int array[][]= {{0,1,0},{1,0,1},{1,0,1},{0,1,0}};
        CornerRectangles cornerRectangles = new CornerRectangles();
        System.out.println(cornerRectangles.countCornerRectangles(array));
        String word = "a".toLowerCase();
    }
}