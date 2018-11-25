package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class ReconstructTreeFromInorderPostoder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHepler(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeHepler(int[] postorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(pstart>pend){
            return null;
        }
        if(pstart == pend){
            return new TreeNode(postorder[pstart]);
        }
        int root = postorder[pend];
        int position = find(inorder,istart,iend,root);
        int numberofelementsinleft = position-1 -istart + 1;
        int numberofelementsinright = iend-position-1 +1;
        TreeNode node = new TreeNode(root);
        node.left = buildTreeHepler(postorder,pstart,pstart+numberofelementsinleft-1,inorder,istart,position-1);
        node.right = buildTreeHepler(postorder,pstart+numberofelementsinleft,pend-1,inorder,position+1,iend);
        return node;
    }

    private int find(int[] inorder, int istart, int iend, int root) {
        for(int i=istart;i<=iend;i++){
            if(inorder[i] == root){
                return i;
            }
        }
        return -1;
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val = x;
        }
    }
}
