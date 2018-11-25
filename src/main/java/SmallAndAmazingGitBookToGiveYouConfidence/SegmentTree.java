package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 23/9/17.
 */
public class SegmentTree {

    private class SegmentTreeNode{
        int start;
        int end;
        int max;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start,int end){
            this.start=start;
            this.end= end;
        }
        public SegmentTreeNode(int start,int end,int max){
            this.start = start;
            this.end = end;
            this.max = max;
        }
    }
    SegmentTreeNode build(int start,int end){
        if(start>end){
            return null;
        }
        if(start == end){
            return new SegmentTreeNode(start,start);
        }
        int mid = (start+end)/2;
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        root.left = build(start,mid);
        root.right = build(mid+1,end);
        return root;
    }

    SegmentTreeNode build(int []a,int start,int end){
        if(start >end){
            return null;
        }
        if(start == end){
            return new SegmentTreeNode(start,end,a[start]);
        }
        Integer leftMax = Integer.MIN_VALUE;
        Integer rightMax = Integer.MIN_VALUE;
        SegmentTreeNode root = new SegmentTreeNode(start,end,0);
        int mid = (start+end)/2;
        root.left = build(a,start,mid);
        root.right = build(a,mid+1,end);
        if(root.left!=null){
            leftMax = root.left.max;
        }
        if(root.right!=null){
            rightMax = root.right.max;
        }
        Integer rootMaxValue = Math.max(leftMax,rightMax);
        root.max = rootMaxValue;
        return root;
    }

    Integer  query(SegmentTreeNode root,int start,int end){
        if(start>end){
            return -1;
        }
        if(root.start == root.end){
            return root.max;
        }
        if(root.start == start && root.end ==end){
            return root.max;
        }
        int mid = (root.start + root.end) /2;
        if(end<=mid){
            return query(root.left,start,end);
        }
        else if(start>=mid+1){
            return query(root.right,start,end);
        }
        else {
            int leftans = query(root.left,start,mid);
            int rightans = query(root.right,mid+1,end);
            return Math.max(leftans,rightans);
        }
    }
}