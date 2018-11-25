package OldAttemptLearning.VideoLectures;

/**
 * Created by hadoop on 28/8/17.
 */
public class RearrangeString {
    private static class point{
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double distance(point p2, point p1){
            return Math.sqrt((p1.x -p2.x) * (p1.x-p2.x) +(p1.y-p2.y)*(p1.y-p2.y));
        }
        double cost(point p1,point p2){
            return distance(this,p1) + distance(this,p2)+distance(p1,p2);
        }
    }


    public static void main(String[] args) {
        point points [] = {
                new point(0,0),
        new point(1,0),new point(2,1),new point(1,2),new point(0,2)
        };

        double ans = mtc(points,0,points.length-1);
        System.out.println(ans);

}

    private static double mtc(point[] points, int i, int j) {
        if(j-i+1<=2){
            return 0;
        }
        double cost = Integer.MAX_VALUE;
        for( int k=i+1;k<j;k++){
            cost = Math.min(cost,mtc(points,i,k)+mtc(points,k,j)+points[k].cost(points[i],points[j]));
            System.out.println("cost"+cost);
        }
        return cost;
    }
}
