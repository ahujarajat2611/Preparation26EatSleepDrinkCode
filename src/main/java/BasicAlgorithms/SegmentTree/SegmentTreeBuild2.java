package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 24/10/17.
 */
public class SegmentTreeBuild2 {
    private class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int start;
        int end;
        int max;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public SegmentTreeNode build(int[] A) {
        int start = 0;
        int end = A.length-1;
        return buildHelper(A,start,end);
    }

    private SegmentTreeNode buildHelper(int[] a, int start, int end) {
        if(start>end){
            return null;
        }
        if(start == end){
            SegmentTreeNode root =  new SegmentTreeNode(start,start);
            root.max = a[start];
            return root;
        }
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        int mid = start + (end-start)/2;
        root.left = buildHelper(a,start,mid);
        root.right = buildHelper(a,mid+1,end);
        if(root.left!=null){
            root.max = Math.max(root.max,root.left.max);
        }
        if(root.right!=null){
            root.max = Math.max(root.max,root.right.max);
        }
        return root;
    }
}