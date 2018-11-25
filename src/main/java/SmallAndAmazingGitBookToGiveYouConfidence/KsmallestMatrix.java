package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.PriorityQueue;

/**
 * Created by hadoop on 21/9/17.
 */
public class KsmallestMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        return searchHorizonal(matrix,k);
    }

    private int searchHorizonal(int[][] matrix, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            minHeap.add(new Cell(i,0,matrix[i][0]));
        }
        for(int i=1;i<k;i++){
            Cell ans = minHeap.poll();
            if(ans.column+1<matrix[ans.row].length){
                minHeap.add(new Cell(ans.row,ans.column+1,matrix[ans.row][ans.column+1]));
            }
        }
        return minHeap.poll().value;
    }
    private class Cell implements Comparable<Cell>{
        int row;
        int column;
        int value;
        Cell(int row,int column,int k){
            this.row = row;
            this.column = column;
            this.value = k;
        }
        @Override
        public int compareTo(Cell that){
            return this.value-that.value;
        }
    }
    private int searchVertical(int[][] matrix, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        for (int j = 0; j < matrix[0].length; j++) {
            pq.offer(new Cell(0, j, matrix[0][j]));
        }
        Cell cell = null;
        for (int i = 0; i < k; i++) {
            cell = pq.poll();
            if (cell.row + 1 < matrix.length) {
                pq.offer(new Cell(cell.row + 1, cell.column, matrix[cell.row + 1][cell.column]));
            }
        }
        return cell.value;
    }
}