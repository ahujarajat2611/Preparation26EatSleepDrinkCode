package BasicAlgorithms.IntervalProblems;

import java.util.*;
/**
 * Created by hadoop on 15/1/18.
 */
public class Overlaprectangles {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            return false;
        }
        int n = rectangles.length;
        List<int[]> list = new ArrayList<>();
        for (int[] rec: rectangles) {
            list.add(rec);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < list.size(); i++) {
            int[] pre = list.get(i - 1);
            int[] cur = list.get(i);
            if (cur[0] < pre[2] && ((cur[1] < pre[3] && cur[1] >= pre[1]) || (cur[3] <= pre[3] && cur[3] > pre[1]))) {
                return false;
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        long area = 0;
        int[] leftPoint = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] bottomPoint = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] rightPoint = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] upPoint = {Integer.MIN_VALUE, Integer.MIN_VALUE};

        int[] pre = new int[4];
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            if (i > 0 && cur[1] < pre[3] && ((cur[0] < pre[2] && cur[0] >= pre[0]) || (cur[2] <= pre[2] && cur[2] > pre[0]))) {
                return false;
            }
            int[] rec = cur;
            if (rec[0] < leftPoint[0] || (rec[0] == leftPoint[0] && rec[1] < leftPoint[1])) {
                leftPoint = new int[] {rec[0], rec[1]};
            }
            if (rec[1] < bottomPoint[1] || (rec[1] == bottomPoint[1] && rec[0] < bottomPoint[0])) {
                bottomPoint = new int[] {rec[0], rec[1]};
            }
            if (rec[2] > rightPoint[0] || (rec[2] == rightPoint[0] && rec[3] > rightPoint[1])) {

                rightPoint = new int[] {rec[2], rec[3]};
            }
            if (rec[3] > upPoint[1] || (rec[3] == upPoint[1] && rec[2] > upPoint[0])) {
                upPoint = new int[] {rec[2], rec[3]};
            }
            area += (rec[3] - rec[1]) * (rec[2] - rec[0]);
            pre = cur;
        }

        if (leftPoint[0] != bottomPoint[0] || leftPoint[1] != bottomPoint[1] || rightPoint[0] != upPoint[0] || rightPoint[1] != upPoint[1]) {
            return false;
        }

        return area == (long) (rightPoint[1] - leftPoint[1]) * (long) (rightPoint[0] - leftPoint[0]);
    }
}
