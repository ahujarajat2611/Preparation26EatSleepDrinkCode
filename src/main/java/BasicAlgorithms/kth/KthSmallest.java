package BasicAlgorithms.kth;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 24/10/17.
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k){
        PriorityQueue<Entry> priorityQueue = new PriorityQueue<>(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o1.value-o2.value;
            }
        });
        int m = matrix.length;
        int n = matrix[0].length;
        boolean visited[][] = new boolean[m][n];
        k =k-1;
        visited[0][0] = true;
        priorityQueue.add(new Entry(0,0,matrix[0][0]));
        int kthelement = -1;
        while (k-->0){
            Entry polled = priorityQueue.poll();
            if(isValid(polled.row +1,polled.column,visited)){
                priorityQueue.add(new Entry(polled.row+1,polled.column,matrix[polled.row+1][polled.column]));
                visited[polled.row+1][polled.column] = true;
            }

            if(isValid(polled.row,polled.column+1,visited)){
                priorityQueue.add(new Entry(polled.row,polled.column+1,matrix[polled.row][polled.column+1]));
                visited[polled.row][polled.column+1] = true;
            }
            kthelement = polled.value;
        }
        return kthelement;
    }

    private boolean isValid(int row, int column, boolean[][] visited) {
        int m = visited.length;
        int n = visited[0].length;
        if(row>=0 && row<m && column>=0 && column<n && !visited[row][column])
            return true;
        return false;
    }

    private class Entry{
        int row;
        int column;
        int value;

        public Entry(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
