package BasicAlgorithms.Math;

import java.util.Arrays;

/**
 * @author Baofeng Xue at 2016/3/22 21:11.
 */
public class Triangle {

    public static void main(String[] args) {

        Triangle triangle = new Triangle();
        System.out.println(Arrays.toString(triangle.getTriangleSides(new int[]{6, 4, 5})));
        System.out.println(Arrays.toString(triangle.getTriangleSides(new int[]{10, 2, 7})));
        System.out.println(Arrays.toString(triangle.getTriangleSides(new int[]{1, 2, 3, 4})));
    }

    /**
     * Three segments of lengths A, B, C form a triangle iff
     * <p>
     * A + B > C
     * B + C > A
     * A + C > B
     * <p>
     * e.g.
     * 6, 4, 5 can form a triangle
     * 10, 2, 7 can't
     * <p>
     * Given a list of segments lengths algorithm should find at least one triplet of segments that form a triangle (if any).
     * <p>
     * Method should return an array of either:
     * - 3 elements: segments that form a triangle (i.e. satisfy the condition above)
     * - empty array if there are no such segments
     */
    int[] getTriangleSides(int[] segments) {

        int[] result = {};

        if (segments == null || segments.length < 3) return result;

        Arrays.sort(segments);

        // if c > a + b then for sure there is triangle with sides and return those since we are asked to find any one triplet
        for (int i = 0; i < segments.length - 2; i++) {
            int a = segments[i];
            int b = segments[i + 1];
            int c = segments[i + 2];
            if (a + b > c) {
                result = new int[3];
                result[0] = a;
                result[1] = b;
                result[2] = c;
                return result;
            }
        }
        return result;
    }
}