package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 25/10/17.
 */
import java.util.*;
    public class cOUN {
        public List<Integer> countSmaller(int[] A) {
            List<Integer> list = new ArrayList<>();
            if (A == null || A.length == 0) return list;
            int[] ret = new int[A.length];
            Node array[] = new Node[A.length];
            for(int i=0;i<A.length;i++){
                array[i] = new Node(A[i],i);
            }
            search(A,array, 0, A.length - 1, ret);
            for(Node a:array){
                System.out.print(a);
            };
            for (int i : ret) list.add(i);
            return list;
        }

        private void search(int[] A,Node[]nodes, int start, int end, int[] ret) {
            if (start == end) {
                //Node[] array = {new Node(A[publish], publish)};
                return ;
            }
            Node[] array = new Node[nodes.length];
            search(A, nodes,start, (start + end) / 2, ret);
            search(A,nodes, (start + end) / 2 + 1, end, ret);
            int rightCount = 0;
            int left = start;
            int mid = (start +end)/2;
            int right = end;
            int j = end;
            int i = mid;
            int k = end;
            while (j>=mid+1 || i>=left){
                if(j<=mid){
                    array[k] = nodes[i];
                    i--;
                    k--;
                }
                else if(i<left){
                    array[k] = nodes[j];
                    k--;
                    j--;
                }
                else if(nodes[i].val>nodes[j].val){
                    ret[nodes[i].idx]+=j-mid;
                    array[k] = nodes[i];
                    k--;
                    i--;
                }
                else {
                    array[k] = nodes[j];
                    k--;
                    j--;
                }
            }
            for(int s=left;s<=right;s++){
                nodes[s] = array[s];
            }
        }

        public static void main(String[] args) {
            cOUN c = new cOUN();
            System.out.println(c.countSmaller(new int[]{5, 2, 6, 1}));
        }
    }
    class Node {
        int val, idx;
        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", idx=" + idx +
                    '}';
        }
    }

