package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 10/10/17.
 */
public class SegmentTree {


    private class SegmentTreeNode {
        public int start;
        public int end;
        public int max;
        SegmentTreeNode left;
        SegmentTreeNode right;

        SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
        }
        SegmentTreeNode(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    SegmentTreeNode build(int a[],int start,int end){
        if(start>end){
            return null;
        }
        if(start == end){
            return  new SegmentTreeNode(start,end,a[start]);
        }
        int mid = (start+end)/2;
        SegmentTreeNode node = new SegmentTreeNode(start,end,Integer.MIN_VALUE);
        node.left = build(a,start,mid);
        node.right = build(a,mid+1,end);
        node.max = Math.max(node.left!=null ? node.left.max:Integer.MIN_VALUE,node.right!=null ?node.right.max:Integer.MIN_VALUE);
        return node;
    }
}