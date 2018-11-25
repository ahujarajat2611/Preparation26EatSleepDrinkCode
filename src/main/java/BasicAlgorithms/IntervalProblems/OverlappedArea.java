package BasicAlgorithms.IntervalProblems;

/**
 * Created by hadoop on 15/1/18.
 */
public class OverlappedArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
            overlap = (right - left) * (top - bottom);

        return areaOfSqrA + areaOfSqrB - overlap;
    }
}
class overlappedagain{

    public int overlapArea(int A, int B, int C, int D,
                           int E, int F, int G, int H) {
	/* Check if there is indeed an overlap.
     * e.g.  E >= C  i.e. the most left point of the rectangle (EFGH) is
     *       on the right side of the most right point of the rectangle (ABCD),
     *       therefore there is no overlapping.
     */
        if ( (E>=C) || (F>= D) || (A>=G) || (B >= H) )
            return 0;

	/* bottom left point of the overlapping area. */
        int bl_x = Math.max(A, E);
        int bl_y = Math.max(B, F);

	/* top right point of the overlapping area. */
        int tr_x = Math.min(C, G);
        int tr_y = Math.min(D, H);

        return (tr_x - bl_x) * (tr_y - bl_y);
    }

    /**
     * Calculate the area of a single rectangle.
     */
    public int computeArea(int A, int B, int C, int D) {
        return (C-A) * (D-B);
    }

    /**
     * Find the total area covered by two rectilinear rectangles in a 2D plane.
     * Each rectangle is defined by its bottom left corner and top right corner.
     */
    public int computeArea(int A, int B, int C, int D,
                           int E, int F, int G, int H) {
        // The addition of area of the two rectangles minus the overlapping area.
        return computeArea(A, B, C, D) + computeArea(E, F, G, H) -
                overlapArea(A, B, C, D, E, F, G, H);
    }
}
