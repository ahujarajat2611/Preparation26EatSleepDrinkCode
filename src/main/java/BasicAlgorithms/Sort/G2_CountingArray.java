package BasicAlgorithms.Sort;


import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created_By: stefanie
 * Date: 14-12-29
 * Time: 下午4:59
 */
public class G2_CountingArray {
    class Node{
        int value;
        int index;
        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }

    public int[] generate(int[] A){
        int[] B = new int[A.length];
        Node[] nodes = new Node[A.length];
        for(int i = 0; i < A.length; i++) nodes[i] = new Node(A[i], i);
        Node[] aux = new Node[A.length];
//        System.out.println("=====");
//        for(Node a:nodes){
//            System.out.print(a.value);
//        }

        mergeSort(nodes, aux, B, 0, A.length - 1);
        ConsoleWriter.printArray(B);
        for(int i=0;i<A.length;i++){
            System.out.println(nodes[i].value);
        }
        return B;
////        System.out.println("=====");
//        for(Node a:nodes){
//            System.out.print(a.value);
//        }
//        System.out.println();
//        return B;
    }

    public int[] generateDif(int[] A){
        int[] B = new int[A.length];
        Node[] nodes = new Node[A.length];
        for(int i = 0; i < A.length; i++) nodes[i] = new Node(A[i], i);
        Node[] aux = new Node[A.length];
//        System.out.println("=====");
//        for(Node a:nodes){
//            System.out.print(a.value);
//        }

        mergeSortDif(nodes, aux, B, 0, A.length - 1);
        //ConsoleWriter.printArray(B);
//        for(int i=0;i<A.length;i++){
//            System.out.println(nodes[i].value);
//        }
        return B;
////        System.out.println("=====");
//        for(Node a:nodes){
//            System.out.print(a.value);
//        }
//        System.out.println();
//        return B;
    }
    public void mergeSort(Node[] A, Node[] aux, int[] B, int low, int high){
        if(low >= high) return;
        int mid = low + (high - low)/2;
        mergeSort(A, aux, B, low, mid);
        mergeSort(A, aux, B, mid + 1, high);
        mergeEnd(A, aux, B, low, mid, high);
    }
    public void mergeSortDif(Node[] A, Node[] aux, int[] B, int low, int high){
        if(low >= high) return;
        int mid = low + (high - low)/2;
        mergeSortDif(A, aux, B, low, mid);
        mergeSortDif(A, aux, B, mid + 1, high);
        merge(A, aux, B, low, mid, high);
    }

    // ALways ddivide and conqueer approach woul dhave publish + end/2 = mid
    // range broken into publish to mind
    // mid + 1 to end !!!
    // if preorder kind of thing
    // then process at mid and range borkne to publish,mid-1, mid+1 to end
    public void merge(Node[] A, Node[] aux, int[] B, int low, int mid, int high) {
//        for (int i = low; i <= high; i++) aux[i] = A[i];
//        int i = mid;
//        int j = high;
//        for (int k = high; k >= low; k--) {
//            if (i < 0) A[k] = aux[j--];
//            else if (j < 0) A[k] = aux[i--];
//            else if (aux[j].value >= aux[i].value) A[k] = aux[j--];
//            else {
//                B[aux[i].index] += j - mid;
//                A[k] = aux[i--];
//            }
//        }

//        System.out.println("call coming here "+low);
//        System.out.println("mid "+mid);
//        System.out.println("hugh "+high);
        int i = low;
        int j = mid+1;
        int k = i;
        while (i<=mid && j<=high){
            if(A[i].value<=A[j].value){
                //System.out.println("copy");
                aux[k++] = A[i];
                i++;
            }
            else {
                //System.out.println("em");
                B[A[j].index]+= mid-i+1;
                aux[k++] = A[j];
                j++;
            }
        }
        if(i<=mid){
            aux[k++] = A[i];
            i++;
        }
        if(j<=high){
           // System.out.println("copy outer");
            aux[k++] = A[j];
            j++;
        }
        for(int p=low;p<=high;p++){
            A[p] = aux[p];
        }
//        for(int c=low;c<=high;c++){
//            System.out.print("print");
//            System.out.print(A[c].value);
//        }
//        System.out.println();
    }


    public void mergeEnd(Node[] A, Node[] aux, int[] B, int low, int mid, int high) {
//        for (int i = low; i <= high; i++) aux[i] = A[i];
//        int i = mid;
//        int j = high;
//        for (int k = high; k >= low; k--) {
//            if (i < 0) A[k] = aux[j--];
//            else if (j < 0) A[k] = aux[i--];
//            else if (aux[j].value >= aux[i].value) A[k] = aux[j--];
//            else {
//                B[aux[i].index] += j - mid;
//                A[k] = aux[i--];
//            }
//        }
//
//        System.out.println("call coming here "+low);
//        System.out.println("mid "+mid);
//        System.out.println("hugh "+high);
        int i = mid;
        int j = high;
        int k = i;
        k = high;
        while (i>=low && j>=mid+1){
            if(A[i].value<=A[j].value){
                //System.out.println("copy");
                aux[k--] = A[j];
                j--;
            }
            else {
                //System.out.println("em");
                B[A[i].index]+= j-mid -1 +1;
                aux[k--] = A[i];
                i--;
            }
        }
        if(i>=low){
            aux[k--] = A[i];
            i--;
        }
        if(j>=mid+1){
            // System.out.println("copy outer");
            aux[k--] = A[j];
            j--;
        }
        for(int p=low;p<=high;p++){
            A[p] = aux[p];
        }
//        for(int c=low;c<=high;c++){
//            System.out.print("print");
//            System.out.print(A[c].value);
//        }
       // System.out.println();
    }
//            }
//        }
//        ConsoleWriter.printIntArray(B);
//        for(int s= low;s<=high;s++){
//            System.out.print(A[s]);
//        }


    public static void main(String[] args){
        G2_CountingArray generator = new G2_CountingArray();
        int[] A = new int[]{5, 2,6,1,2,3,1,9,10,1,2};
        //4,0,1,1,0
        ConsoleWriter.printIntArray(generator.generate(A));
        ConsoleWriter.printIntArray(generator.generateDif(A));

        for(int i=0;i<A.length;i++){
            int count  =0;
            for(int k =0;k<A.length;k++){
                if(A[i] >A[k]  && i<k){
                    count++;
                }
            }
            System.out.print(count);
        }
    }
}
/*
1, 0, 0, 0, 0,
2, 0, 0, 0, 0,
2, 0, 1, 1, 0,
4, 0, 1, 1, 0,
4, 0, 1, 1, 0,
 */