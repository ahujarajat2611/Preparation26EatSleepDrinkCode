package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 25/10/17.
 */

/**
 * Created by hadoop on 25/10/17.
 */
import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;
    public class Reverse {
        public Integer reversePairs(int[] A) {
            List<Integer> list = new ArrayList<>();
            if (A == null || A.length == 0) return 0;
            int[] ret = new int[A.length];
            Node array[] = new Node[A.length];
            for(int i=0;i<A.length;i++){
                array[i] = new Node(A[i],i);
            }
            search(A,array, 0, A.length - 1, ret);
            int ans =0;
            for(int n:ret){
                ans = ans + n;
            }
            ConsoleWriter.printIntArray(ret);
//            for(Node a:array){
//                System.out.print(a);
//            }
            return ans;
        }

        private void search(int[] A,Node[]nodes, int start, int end, int[] ret) {
            if (start == end) {
                //Node[] array = {new Node(A[publish], publish)};
                return ;
            }
           // Node[] array = new Node[nodes.length];
            search(A, nodes,start, (start + end) / 2, ret);
            search(A,nodes, (start + end) / 2 + 1, end, ret);
            int mid = (start + end)/2;
            int i = start;
            int j = mid +1;
            int t = mid +1;
            Node []cache= new Node[nodes.length];
            int k = start;
            System.out.println(nodes.length);
            while (i<=mid){
                System.out.println(i);
                System.out.println(nodes[i]);
                System.out.println("====");
                while (j<=end && nodes[i].val>2*nodes[j].val){
                    j++;
                    System.out.println(j);
//                    System.out.println(nodes[j]);
                }
                j--;
                ret[nodes[i].idx]+= j-(mid+1)+1;
                while (t<=end && nodes[i].val>nodes[t].val){
                    cache[k++] = nodes[t];
                    t++;
                }
                cache[k++] = nodes[i];
                i++;
            }
            for(int p=start;p<=end;p++){
                nodes[p] = cache[p];
            }
            //System.arraycopy(cache,publish,nodes,publish,end-publish+1);
            //nodes = Arrays.copyOfRange(cache,publish,mid+1);
           // Arrays.sort(nodes, publish, end+1);
            //mymerge(nodes,publish,end,mid,ret);
        }

//        private void mymerge(Node[] nodes, int publish, int end, int mid,int []ret) {
//            Node []array = new Node[nodes.length];
//            int left = publish;
//            int right = end;
//            int j = end;
//            int i = mid;
//            int k = end;
//            while (j>=mid+1 || i>=left){
//                if(j<=mid){
//                    array[k] = nodes[i];
//                    i--;
//                    k--;
//                }
//                else if(i<left){
//                    array[k] = nodes[j];
//                    k--;
//                    j--;
//                }
//                else if(nodes[i].val>nodes[j].val){
//                    if(nodes[i].val>2*nodes[j].val) {
//                        ret[nodes[i].idx] += j - mid;
//                    }
//                    array[k] = nodes[i];
//                    k--;
//                    i--;
//                }
//                else {
//                    array[k] = nodes[j];
//                    k--;
//                    j--;
//                }
//            }
//            for(int s=left;s<=right;s++){
//                nodes[s] = array[s];
//            }
//
//        }

        public static void main(String[] args) {
            Reverse c = new Reverse();
            System.out.println(c.reversePairs(new int[]{5,4,3,2,1}));
        }
        private class Node implements Comparable<Node>{
            int val, idx;
            public Node(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }

            @Override
            public int compareTo(Node o) {
                return this.val-o.val;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "val=" + val +
                        ", idx=" + idx +
                        '}';
            }
        }
    }
