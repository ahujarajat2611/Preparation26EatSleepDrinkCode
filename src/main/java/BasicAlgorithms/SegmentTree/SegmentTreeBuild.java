package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 24/10/17.
 */
public class SegmentTreeBuild {


    private class SegmentTreeNode{
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public SegmentTreeNode build(int start, int end) {
        if(start>end){
            return null;
        }
        if(start == end){
            SegmentTreeNode root = new SegmentTreeNode(start,start);
            return root;
        }
        int mid = start + (end-start)/2;
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        root.left = build(start,mid);
        root.right = build(mid+1,end);
        return root;
    }

}
