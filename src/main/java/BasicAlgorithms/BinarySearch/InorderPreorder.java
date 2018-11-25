package BasicAlgorithms.BinarySearch;

/**
 * Created by hadoop on 18/10/17.
 */
public class InorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(pstart>pend){
            return null;
        }
        if(pstart == pend){
            return new TreeNode(preorder[pstart]);
        }
        int root = preorder[pstart];
        int findindexinorder = find(root,inorder,istart,iend);
        if(findindexinorder == -1){
            System.out.println("NO root found");
            System.exit(1);
        }
        int nummberofelementinleftsubtree = findindexinorder-1 -istart+1;
     //   int numberofelementsinrightsubtree = iend -findindexinorder-1+1;
        TreeNode node = new TreeNode(root);
        node.left = helper(preorder,pstart+1,pstart+nummberofelementinleftsubtree,inorder,istart,findindexinorder-1);
        node.right = helper(preorder,pstart+nummberofelementinleftsubtree+1,pend,inorder,findindexinorder+1,iend);
        return node;
    }

    private int find(int root, int[] inorder, int istart, int iend) {
        for (int i=istart;i<=iend;i++){
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
        TreeNode(int val){
            this.val = val;
        }
    }
}
