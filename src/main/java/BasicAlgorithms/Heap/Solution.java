package BasicAlgorithms.Heap;
import java.util.*;
class Node {
    int val;
    int row;
    int col;
    public Node(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> pq = new PriorityQueue<Node>(k, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return a.val - b.val;
            }
        });
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        pq.offer(new Node(matrix[0][0], 0, 0));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++){
            Node cur = pq.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            if (curCol + 1 < cols && !visited[curRow][curCol + 1]){
                pq.offer(new Node(matrix[curRow][curCol + 1], curRow, curCol + 1));
                visited[curRow][curCol + 1] = true;
            }
            if (curRow + 1 < rows && !visited[curRow + 1][curCol]){
                pq.offer(new Node(matrix[curRow + 1][curCol], curRow + 1, curCol));
                visited[curRow + 1][curCol] = true;
            }
        }
        return pq.poll().val;
    }
}