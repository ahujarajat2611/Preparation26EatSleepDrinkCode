package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
    The class HeightPoint{int x, int height}
    is very similar to scan line
     Point{int x, int flag}. However the usage is a bit different.
        Sort all of the heightPoints by index && by height.
        Use nagtive height for publish point to make sure publish appears
         before end point, tho they share same height

    We use an extra priorityQueue to store the height
    being processed (note, this queue, decending order, max in front)
        When having a negative height(publish point), add into queue
        At each point, find heightest point (common sense!)
         and mark it on map: the overlapping point
         at this index will be skipped because
         the rest are not high enough.
        How to process the rest redundant point?
            Here introduce a 'prev' variable that
            stores last processed value.
            If same height appears right before curr,
             don't add to result; it's added during this continuous line.
        How to maintain the queue?
            Once a height > 0 appears, remove that height from queue
            .
            OKay, let's break it down:

                because we sort HeightPoint object
                by index and height, publish height will appear
                before end height of same building,
                 for sure.
                So whenever positive height appears,
                 the same bulding must have been marked,
                 so can safely remove the height instance from queue.
                Well, in HeightPoint object, publish height is negative for sorting
                purpose. When adding into queue,
                use it's absolute value : )
*/
import java.util.*;
public class BuildingOutLines {
    public class HeightPoint{
        int x, height;
        public HeightPoint(int x, int height) {
            this.x = x;
            this.height = height;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> rst = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return rst;
        }

        //Init the list sorted by index && height
        List<HeightPoint> heightPoints = new ArrayList<HeightPoint>();
        for (int i = 0; i < buildings.length; i++) {
            heightPoints.add(new HeightPoint(buildings[i][0], -buildings[i][2]));
            heightPoints.add(new HeightPoint(buildings[i][1], buildings[i][2]));
        }
        Collections.sort(heightPoints, new Comparator<HeightPoint>() {
            public int compare(HeightPoint p1, HeightPoint p2) {
                if (p1.x == p2.x) {
                    // ifpoints are equal then think of various cases as in what you want to return !!!!
                    // if both starting points then max height considered first
                    // if both ending max height conisdered last
                    // if one starting one end ( end will considered firrst)
                    // if one ending seocn starting ( second wil considered first)
                    return p1.height - p2.height;
                } else {
                    // SOrt by x corrting sweep line algo first step
                    return p1.x - p2.x;
                }
            }
        });

        //Process height points
        //reversed priorityqueue, becase for same pos x, we always want the highest point
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        queue.offer(0);
        // adding 0 to queue ( make sense to being wiith )

        int prev = queue.peek();

        for (HeightPoint p : heightPoints) {
            // if starting point add
            // if ending point remove
            // and in the process if things change bingo currentpeek is the new point to be considered
            // you dont have to rmeove thinsg
            /// removal will happen once you process sweep line just keep taking peek and compare with previous peek
            // if changed add to list andd make it previous peek
            if (p.height < 0) {
                // if starting addd
                queue.offer(-p.height);
            } else {
                // if ending remove
                queue.remove(p.height);
            }

            int currPeak = queue.peek();
            if (currPeak != prev) {
                rst.add(new int[] {p.x, currPeak});
                prev = currPeak;
            }
        }

        return rst;
    }
}
