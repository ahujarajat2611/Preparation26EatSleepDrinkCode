package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 25/10/17.
 */
public class FinalCompletInversionTopicPostOrder {
    private class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int value, int index) {
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Node that){
            return this.value-that.value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
    public int mergeSortWithExtraCapabilities(int []array){
        Node [] nodes = new Node[array.length];
        for(int i=0;i<array.length;i++){
            nodes[i] = new Node(array[i],i);
        }
        int []extraAns = new int[array.length];
        breakAndMerge(nodes,extraAns,0,nodes.length-1);
        int ans = 0;
        for(int num:extraAns){
            ans = ans + num;
        }
        return ans;
    }

    private void breakAndMerge(Node[] nodes, int[] extraAns, int start, int end) {
        if(start>=end) return;
        int mid = (start + end)/2;
        breakAndMerge(nodes,extraAns,start,mid);
        breakAndMerge(nodes,extraAns,mid+1,end);

        Node []cache = new Node[nodes.length];
        int i = start;
        int j = mid +1;
        while (i<=mid){
            while (j<=end && nodes[i].value>2*nodes[j].value){
                j++;
            }
            extraAns[nodes[i].index]+= (j-1)-(mid+1)+1;
            i++;
        }

        i = start;
        j = mid +1;
        int k = start;
        while (i<=mid){
            while (j<=end && nodes[i].value>nodes[j].value){
                cache[k++] = nodes[j];
                j++;
            }
            cache[k++] = nodes[i];
            i++;
        }
        while (j<=end){
            cache[k++] = nodes[j];
            j++;
        }

        for(int s = start;s<=end;s++){
            nodes[s] = cache[s];
        }
    }

    public static void main(String[] args) {
        FinalCompletInversionTopicPostOrder finalCompletInversionTopicPostOrder = new FinalCompletInversionTopicPostOrder();
        System.out.println(finalCompletInversionTopicPostOrder.mergeSortWithExtraCapabilities(new int[]{2,4,3,5,1}));

    }
}
