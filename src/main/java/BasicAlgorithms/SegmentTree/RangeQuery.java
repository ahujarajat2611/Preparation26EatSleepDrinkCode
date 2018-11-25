package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 24/10/17.
 */
public class RangeQuery {
    SegmentTreeNode root= null;
    private class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int start;
        int end;
        int sum;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private SegmentTreeNode buildHelper(int[] a, int start, int end) {
        if(start>end){
            return null;
        }
        if(start == end){
            SegmentTreeNode root =  new SegmentTreeNode(start,start);
            root.sum = a[start];
            return root;
        }
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        int mid = start + (end-start)/2;
        root.left = buildHelper(a,start,mid);
        root.right = buildHelper(a,mid+1,end);
        root.sum = 0;
        if(root.left!=null){
            root.sum += root.left.sum;
        }
        if(root.right!=null){
            root.sum += root.right.sum;
        }
        return root;
    }
    public RangeQuery(int[] nums){
        root = buildHelper(nums,0,nums.length-1);
    }
    public int sumRange(int i, int j){
        return sumRangeHelper(root,i,j);
    }
    void update(int i, int val){
        updateHelper(root,i,val);
    }
    SegmentTreeNode updateHelper(SegmentTreeNode node,int index,int value){
        if(node == null){
            return null;
        }
        if(node.start == index && node.end == index){
            node.sum = value;
            return node;
        }

        int mid = node.start + (node.end-node.start)/2;
        if(index<=mid){
            SegmentTreeNode left = updateHelper(node.left,index,value);
        }
        else if(index>mid){
            SegmentTreeNode right = updateHelper(node.right,index,value);
        }
        node.sum = node.left.sum +node.right.sum;
        return node;
    }

    int sumRangeHelper(SegmentTreeNode node,int startrange,int endrange){
        if(node == null){
            return 0;
        }
        if(startrange ==node.start && endrange == node.end){
            return node.sum;
        }
        int mid = node.start + (node.end-node.start)/2;
        if(endrange<=mid){
            return sumRangeHelper(node.left,startrange,endrange);
        }
        else if(startrange>mid){
            return sumRangeHelper(node.right,startrange,endrange);
        }
        return sumRangeHelper(node.left,startrange,mid) + sumRangeHelper(node.right,mid+1,endrange);

    }
}
