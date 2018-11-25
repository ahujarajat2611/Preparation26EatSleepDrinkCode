package BasicAlgorithms.Math;

import java.util.Arrays;

public class Rectangle {

public class Point {
/*
* This is a 2D point with coordinate (x,y)
*/
double x;
double y;

Point() {
this.x = 0;
this.y = 0;
}

Point(double x, double y) {
this.x = x;
this.y = y;
}

public String show() {
return "( " + x + " , " + y + " )";
}

public boolean isEqual(Point p) {
return this.x == p.x && this.y == p.y;
}

}

/**
* Rectangle is constructed by any two corner points p1 and p2
*/
Point p1, p2;

public Rectangle() {
this.p1 = new Point();
this.p2 = new Point();
}

public Rectangle(double x1, double y1, double x2, double y2) {
this.p1 = new Point(x1, y1);
this.p2 = new Point(x2, y2);

}

public Rectangle(Point p1, Point p2) {
this.p1 = p1;
this.p2 = p2;
}

public void show() {

System.out.println("———- " + this + " ————");
System.out.println("Point p1 is : " + p1.show());
System.out.println("Point p2 is : " + p2.show());

}

public boolean validate() {

if (this.p1.x != this.p2.x && this.p1.y != this.p2.y)
return true;
else
return false;
}

public double getArea() {

double height = Math.abs(p1.y - p2.y);
double width = Math.abs(p1.x - p2.x);

return height * width;
}

/**
* This is like a utility method
*
* @param rect1
* @param rect2
* @return
*/
public static Rectangle getIntersectedRectangle(Rectangle rect1,
Rectangle rect2) {

if (!hasCommonArea(rect1, rect2))
return null;

/*
* If Common area exists then find Rectangle
*
* Two x-coordinate of intersected rectangle will be middle two
* x-coordinate of four x-coordinates
*/
double[] dXArr = new double[] { rect1.p1.x, rect1.p2.x, rect2.p1.x,
rect2.p2.x };
double[] dYArr = new double[] { rect1.p1.y, rect1.p2.y, rect2.p1.y,
rect2.p2.y };

Arrays.sort(dXArr);
Arrays.sort(dYArr);

Rectangle inRect = new Rectangle(dXArr[1], dYArr[1], dXArr[2], dYArr[2]);

inRect.show();
return inRect;
}

/**
* This is like a utility method
*
* @param rect1
* @param rect2
* @return
*/
public static boolean hasCommonArea(Rectangle rect1, Rectangle rect2) {

boolean flag1 = true, flag2 = true;
if ((Math.min(rect1.p1.x, rect1.p2.x) >= Math.max(rect2.p1.x,
rect2.p2.x)) || (Math.max(rect1.p2.x,rect1.p2.x) == Math.max(rect2.p1.y, rect2.p2.y)) || (Math.max(rect1.p2.y, rect1.p2.y) <= Math.min(rect2.p1.y,
rect2.p2.y))) {

flag2 = false;
}

if (!(flag1 && flag2))
System.out.println("Common Area doesnot exist");

// System.out.println("flag1 😡 " + flag1 + " flag2 :y " + flag2);

return flag1 && flag2;
}

public static void main(String[] args) {
// TODO Auto-generated method stub

Rectangle rect1 = new Rectangle(1, 1, 6, 6);
Rectangle rect2 = new Rectangle(1, 16, 6, 20);

if (null != getIntersectedRectangle(rect1, rect2))
System.out.println("Area is : "
+ getIntersectedRectangle(rect1, rect2).getArea()
+ " sq unit");

}

}

// intersection of rectangles !!



/*



bool BoxesIntersect(const Box2D &a, const Box2D &b)
{
    if (a.max.x < b.min.x) return false; // a is left of b
    if (a.min.x > b.max.x) return false; // a is right of b
    if (a.max.y < b.min.y) return false; // a is above b
    if (a.min.y > b.max.y) return false; // a is below b
    return true; // boxes overlap
}

struct Vec2D
{
    float x,y;
};

// 2D axially-aligned bounding box.
struct Box2D
{
    Vec2D min, max;
};

bool BoxesIntersect(const Box2D &a, const Box2D &b);


(By the way, whether “<” and “>” should be “<=” and “>=” depends on exactly what you mean by boxes “intersecting.” If you are using floating point coordinates and this distinction matters, you are probably doing something wrong.)




http://gamemath.com/2011/09/detecting-whether-two-boxes-overlap/

https://articles.leetcode.com/determine-if-two-rectangles-overlap/


! ( P2.y < P3.y || P1.y > P4.y || P2.x < P3.x || P1.x > P4.x )


 */
