package zrzahid;

import java.util.PriorityQueue;

/**
 * Created by hadoop on 10/9/17.
 */
public class MergeKSorted {

    private class QueueNode implements Comparable<QueueNode> {
        int row, column,value;

        public QueueNode(int array, int index, int value) {
            this.row = array;
            this.column = index;
            this.value = value;
        }

        public int compareTo(QueueNode a){
            return value-a.value;
        }
    }

    // put first column of all rows !!!
    public int[] merge(int [][] merge){
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        int size=0 ;
        for(int i=0;i<merge.length;i++){
            size = size + merge[i].length;
            if(merge[i].length>0) {
                pq.add(new QueueNode(i, 0, merge[i][0]));
            }
        }
        int [] result = new int[size];
        for(int i=0;!pq.isEmpty();i++){
            QueueNode node = pq.poll();
            result[i] = node.value;
            int newindex = node.column +1;
            if(newindex<merge[node.row].length){
                pq.add(new QueueNode(node.row,newindex,merge[node.row][newindex]));
            }
        }
        return result;
    }
}
