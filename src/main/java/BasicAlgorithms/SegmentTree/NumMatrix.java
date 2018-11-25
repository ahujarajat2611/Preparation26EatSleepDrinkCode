package BasicAlgorithms.SegmentTree;

/**
 * Created by hadoop on 24/10/17.
 */
public class NumMatrix {
    TreeNode root;
    int [][]matrix ;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) {
            root = null;
        } else {
            root = buildTree(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
        }
    }

    public void update(int row, int col, int val) {
        update(root, row, col, val);
    }

    private void update(TreeNode root, int row, int col, int val) {
        if (root.row1 == root.row2 && root.row1 == row && root.col1 == root.col2 && root.col1 == col) {
            root.sum = val;
            return;
        }
        int rowMid = (root.row1 + root.row2) / 2;
        int colMid = (root.col1 + root.col2) / 2;
        TreeNode next;
        if(row<=rowMid && col<=colMid) {
            update(root.c1,row,col,val);
        }
        if(row>rowMid && col<=colMid){
            update(root.c2,row,col,val);
        }
        if(row<=rowMid && col>colMid) {
            update(root.c3,row,col,val);
        }
        if(row>rowMid && col>colMid) {
            update(root.c4,row,col,val);
        }
        root.sum =( root.c1!=null?root.c1.sum:0) + (root.c2!=null?root.c2.sum:0) +(root.c3!=null?root.c3.sum:0) + (root.c4!=null?root.c4.sum:0);
        return;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(root, row1, col1, row2, col2);
    }

    private int sumRegion(TreeNode root, int row1, int col1, int row2, int col2) {
        if(row1>row2 || col1>col2){
            return 0;
        }
        if (root.row1 == row1 && root.col1 == col1 && root.row2 == row2 && root.col2 == col2)
            return root.sum;
        int rowMid = (root.row1 + root.row2) / 2;
        int colMid = (root.col1 + root.col2) / 2;
        int leftquatersum = 0;
        int leftbottomquatersum =0;
        int rightquatersum = 0;
        int rightbottomquatersum = 0;

        if(row1<=rowMid && col1<=colMid){
            leftquatersum = sumRegion(root.c1,row1,col1,Math.min(row2,rowMid),Math.min(col2,colMid));
        }
        if(row2>rowMid && col1<=colMid){
            leftbottomquatersum = sumRegion(root.c2,Math.max(row1,rowMid+1),col1,row2,Math.min(col2,colMid));
        }
        if(row1<=rowMid && col2>colMid){
            rightquatersum = sumRegion(root.c3,row1,Math.max(colMid+1,col1),Math.min(row2,rowMid),col2);
        }
        if(row2>rowMid && col2>colMid){
            rightbottomquatersum = sumRegion(root.c4,Math.max(rowMid+1,row1),Math.max(colMid+1,col1),row2,col2);
        }
        return leftquatersum+ leftbottomquatersum + rightquatersum + rightbottomquatersum;
    }

    private TreeNode buildTree(int[][] matrix, int row1, int col1, int row2, int col2) {
        if (row2 < row1 || col2 < col1)
            return null;
        TreeNode node = new TreeNode(row1, col1, row2, col2);
        if (row1 == row2 && col1 == col2) {
            node.sum = matrix[row1][col1];
            return node;
        }
        int rowMid = (row1 + row2) / 2;
        int colMid = (col1 + col2) / 2;
        node.c1 = buildTree(matrix, row1, col1, rowMid, colMid);
        node.c2 = buildTree(matrix, rowMid+1, col1, row2,colMid );
        node.c3 = buildTree(matrix, row1, colMid+1, rowMid, col2);
        node.c4 = buildTree(matrix, rowMid+1, colMid+1, row2, col2);
        node.sum += node.c1 != null ? node.c1.sum : 0;
        node.sum += node.c2 != null ? node.c2.sum : 0;
        node.sum += node.c3 != null ? node.c3.sum : 0;
        node.sum += node.c4 != null ? node.c4.sum : 0;
        return node;
    }

    public class TreeNode {
        int row1, row2, col1, col2, sum;
        TreeNode c1, c2, c3, c4;
        public TreeNode (int row1, int col1, int row2, int col2) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.sum = 0;
        }
    }

    public static void main(String[] args) {
        int matrix [][]= {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        numMatrix.update(3,2,2);
        System.out.println(numMatrix.sumRegion(2,1,4,3));

    }
}
