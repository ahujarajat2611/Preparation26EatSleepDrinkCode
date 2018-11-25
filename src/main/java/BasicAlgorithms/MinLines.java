package BasicAlgorithms;

import java.util.HashSet;

/**
 * Created by hadoofgvp on 17/11/17.
 */
public class MinLines {
    public int solution(Point2D[] A) {
        HashSet<slope> slopes = new HashSet<>();
        int lines = 0;
        for (int i = 0; i < A.length; i++) {
            int xcor = A[i].x;
            int ycor = A[i].y;
            slope s = slopewithgcd(xcor, ycor);
            if (!slopes.contains(s)) {
                slopes.add(s);
                lines++;
            }
        }
        return lines;
    }

    slope slopewithgcd(int x, int y) {
        int gcd = getGCD(Math.abs(x), Math.abs(y));
        if(x ==0 && y>0){
            return new slope(1,0);
        }
        if(x ==0 && y <0){
            return new slope(-1,0);
        }
        if( y ==0 && x >0){
            return new slope(0,1);
        }
        if( y ==0 && x<0){
            return new slope(0,-1);
        }


        if (x < 0 && y < 0) {
            return new slope(-1 * Math.abs(y) / gcd, -1 * Math.abs(x) / gcd);
        } else if (x > 0 && y > 0) {
            return new slope(1 * Math.abs(y) / gcd, 1 * Math.abs(x) / gcd);
        } else if (x < 0) {
            return new slope(Math.abs(y) / gcd, -1 * Math.abs(x) / gcd);
        } else {
            return new slope(-1 * Math.abs(y) / gcd, 1 * Math.abs(x) / gcd);
        }

    }

    int getGCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return getGCD(y, x % y);
    }

//    public static void main(String[] args) {
//        Point2D A[] = new Point2D[5];
//        for (int i = 0; i < 5; i++) {
//            A[i] = new Point2D();
//        }
//        A[0].x = -1;
//        A[0].y = -2;
//        A[1].x = 1;
//        A[1].y = 2;
//        A[2].x = 2;
//        A[2].y = 4;
//        A[3].x = -3;
//        A[3].y = 2;
//        A[4].x = 2;
//        A[4].y = -2;
//        MinLines minLines = new MinLines();
//        System.out.println(minLines.solution(A));
//    }

    private class slope {
        int yslope;
        int xslope;

        public slope(int yslope, int xslope) {
            this.yslope = yslope;
            this.xslope = xslope;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            slope slope = (slope) o;

            if (yslope != slope.yslope) return false;
            return xslope == slope.xslope;
        }

        @Override
        public int hashCode() {
            int result = yslope;
            result = 31 * result + xslope;
            return result;
        }
    }
}
class Point2D{
    int x;
    int y;
}