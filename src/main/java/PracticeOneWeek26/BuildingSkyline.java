package PracticeOneWeek26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by hadoop on 7/12/17.
 */
public class BuildingSkyline {
    private class BuildingPoint implements Comparable<BuildingPoint> {
        boolean isStart;
        int x;
        int h;

        public int compareTo(BuildingPoint that) {
            if (this.x != that.x) {
                return this.x - that.x;
            } else {
                if (this.isStart && that.isStart) {
                    return that.h - this.h;
                } else if (!this.isStart && !that.isStart) {
                    return this.h - that.h;
                } else if (this.isStart && !that.isStart) {
                    return -this.h - that.h;
                } else {
                    return this.h + that.h;
                }
            }
        }

        public BuildingPoint(int x, boolean isStart, int h) {
            this.x = x;
            this.h = h;
            this.isStart = isStart;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] bps = new BuildingPoint[buildings.length * 2];
        int index =0;
        for(int []building: buildings ){
            bps[index++] = new BuildingPoint(building[0],true,building[2]);
            bps[index++] = new BuildingPoint(building[1],false,building[2]);
        }

        Arrays.sort(bps);

        List<int[]> result = new ArrayList();
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        int prevMaxH = 0;
        for (BuildingPoint bp : bps) {
            if (bp.isStart) {
                if (treeMap.containsKey(bp.h)) {
                    treeMap.put(bp.h,treeMap.get(bp.h)+1);
                }
                else {
                    treeMap.put(bp.h, 1);
                }
            }
            else {

                if (treeMap.containsKey(bp.h) && treeMap.get(bp.h) > 1) {
                    treeMap.put(bp.h, treeMap.get(bp.h) - 1);
                } else {
                    treeMap.remove(bp.h);
                }
            }

            //// get max key in the tree and post that compare with previous .. max height

            int currentMax = treeMap.lastKey();
            if(currentMax !=prevMaxH){
                // keep storing height current max ...
                result.add(new int[]{bp.x,currentMax});
                prevMaxH = currentMax;
            }
        }
        return result;
    }
}