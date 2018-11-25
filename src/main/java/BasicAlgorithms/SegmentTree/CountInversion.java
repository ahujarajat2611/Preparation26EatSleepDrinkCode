package BasicAlgorithms.SegmentTree;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 24/10/17.
 */
public class CountInversion {
    class Node{
        int value;
        int index;
        public Node(int value,int index){
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
    public int[] generateInversionCount(int[] A){
        Node [] nodes = new Node[A.length];
        int []B  = new int[A.length];
        for(int i=0;i<A.length;i++){
            nodes[i] = new Node(A[i],i);
        }
        Node aux[] = new Node[A.length];
        mergeSort(nodes,aux,B,0,A.length-1);
//        for(Node a:nodes){
//            System.out.print(a.value);
//        }
//        System.out.println();
        return B;
    }

    private void mergeSort(Node[] nodes, Node[] aux, int[] b, int low, int high) {
        if(low>=high){
            return;
        }
        int mid = low + (high-low)/2;
        mergeSort(nodes,aux,b,low,mid);
        mergeSort(nodes,aux,b,mid+1,high);
        merge(nodes,aux,b,low,mid,high);
    }

    private void merge(Node[] nodes, Node[] aux, int[] b, int low, int mid, int high) {
        int left = low;
        int right = high;
        int j = high;
        int i = mid;
        int k = high;
        while (j>=mid+1 || i>=left){
            if(j<=mid){
                aux[k] = nodes[i];
                i--;
                k--;
            }
            else if(i<left){
                aux[k] = nodes[j];
                k--;
                j--;
            }
            else if(nodes[i].value>nodes[j].value){
                b[nodes[i].index]+=j-mid;
                aux[k] = nodes[i];
                k--;
                i--;
            }
            else {
                aux[k] = nodes[j];
                k--;
                j--;
            }
        }
        for(int s=left;s<=right;s++){
            nodes[s] = aux[s];
        }
//        ConsoleWriter.printIntArray(b);
//        for(int s= low;s<=high;s++){
//            System.out.print(nodes[s]);
//        }
    }

    public static void main(String[] args) {
        CountInversion countInversion = new CountInversion();
        int[] A = new int[]{5, 2, 6, 1};
        ConsoleWriter.printIntArray(countInversion.generateInversionCount(A));
    }
}
/*
1, 0, 0, 0, 0,
2, 0, 0, 0, 0,
2, 0, 1, 1, 0,
4, 0, 1, 1, 0,
4, 0, 1, 1, 0,
 */
/*
1, 0, 0, 0, 0,
2, 0, 0, 0, 0,
2, 0, 0, 1, 0,
2, 0, 0, 1, 0,
2, 0, 0, 1, 0,
 */