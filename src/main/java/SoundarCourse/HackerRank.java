package SoundarCourse;

import java.util.Scanner;

/**
 * Created by hadoop on 16/10/17.
 */
public class HackerRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nostars = sc.nextInt();
        int views = sc.nextInt();
        int maxBrightness = sc.nextInt();
        Point [] stars= new Point[nostars];
        for(int i=0;i<nostars;i++){
            int x= sc.nextInt();
            int y = sc.nextInt();
            int bright = sc.nextInt();
            stars[i] = new Point(x,y,bright);
        }
        for(int i=0;i<views;i++){

            int ans = 0;
            int time = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            Rectangle rectangle = new Rectangle(x1,y1,Math.abs(x2-x1),Math.abs(y2-y1));
            for(int st=0;st<nostars;st++){
                if(rectangle.contains(stars[st].x,stars[st].y)){
                    ans = ans+(stars[st].bright+time)%(maxBrightness+1);
                }
            }
            System.out.println(ans);
        }
    }


    private static class Point{
        int x;
        int y;
        int bright;

        public Point(int x, int y, int bright) {
            this.x = x;
            this.y = y;
            this.bright = bright;
        }
    }
    private static class Rectangle {
        int x;
        int y;
        int width;
        int height;

        public Rectangle(int x, int y, int width, int height) {
            if(width < 0 || height < 0)
                throw new IllegalArgumentException();

            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String toString() {
            return "Rectangle[x=" + x + ",y=" + y + ",width=" + width + ",height="
                    + height + "]";
        }
        public boolean contains(int x, int y) {
            return this.x <= x && x <= this.x + width && this.y <= y &&
                    y <= this.y + height;
        }
    }

}
