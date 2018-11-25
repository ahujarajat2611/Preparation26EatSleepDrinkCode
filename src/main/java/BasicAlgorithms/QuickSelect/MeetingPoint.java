package BasicAlgorithms.QuickSelect;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by hadoop on 16/10/17.
 */
// if length is even  then median is up to you what you want to choose
    // (nums.length +1)/2 or (nums.length/2 +1)
    // if odd above both equations will give same anwswer !!!
public class MeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> listx = new ArrayList<>();
        List<Integer> listy = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0) {
                    listx.add(i);
                    listy.add(j);
                }
            }
        }

        int xmedian = getmedian(listx);
        int ymedian = getmedian(listy);


        int dis=0;
        for(int i=0;i<listx.size();i++){
            dis = dis+ Math.abs(listx.get(i)-xmedian);
            dis = dis+ Math.abs(listy.get(i)-ymedian);
        // find distance from medians and keep a track of that !!!!
            // since distance from median will be always smalleer
            // to find median  use quickkselect !!!
        }
        System.out.println(dis);

        return dis;
    }

    private int getmedian(List<Integer> listx) {
        int xmed = KthSmallestElement(listx,0,listx.size()-1,listx.size()/2 +1);
        return xmed;
    }

    private int KthSmallestElement(List<Integer> listx, int lo, int hi, int k) {
        if(lo>hi){
            return -1;
        }
        int partitionedindex = partitiondutch(listx,lo,hi);
        int sizeofpartition = partitionedindex-lo+1;
        if(sizeofpartition == k){
            return listx.get(partitionedindex);
        }
        if(sizeofpartition<k){
            return KthSmallestElement(listx,partitionedindex+1,hi,k-sizeofpartition);
        }
        else {
            return KthSmallestElement(listx,lo,partitionedindex-1,k);
        }
    }

    private int partitiondutch(List<Integer> listx, int lo, int hi) {

        int pivot = listx.get((lo+hi)/2);
        int start = lo;
        int middle = lo;
        int high = hi;
        while (middle<=high){
            if(listx.get(middle)>pivot) {
                Collections.swap(listx,high,middle);
                high--;
            }
            else if(listx.get(middle)<pivot){
                Collections.swap(listx,start,middle);
                start++;
                middle++;
            }
            else {
                middle++;
            }
        }
        return start;
    }
    public static void main(String args[]){
        int array[][]={{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        MeetingPoint meetingPoint = new MeetingPoint();
        meetingPoint.minTotalDistance(array);
    }
}