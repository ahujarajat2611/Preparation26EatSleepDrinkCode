package zrzahid;
//
///**
// * Created by hadoop on 6/9/17.
// */
//public class TreeOperations {
//}
//
//
//class TreeNode {
//    int key;
//    int height;
//    int size;
//    TreeNode left;
//    TreeNode right;
//    TreeNode parent;
//
//    TreeNode(int key){
//        this.key = key;
//        this.size = 1;
//        this.height = 1;
//        this.left = null;
//        this.right = null;
//    }
//
//    public int size(TreeNode node){
//        return node == null ?0:node.size;
//    }
//    public int height(TreeNode node){
//        return node == null?0:node.height;
//    }
//    public TreeNode rotateLeft(TreeNode root){
//        TreeNode newroot = root.right;
//        TreeNode leftSubtree  = newroot.left;
//        root.right = leftSubtree;
//        newroot.left = root;
//        root.size
//        return newroot;
//    }
//}
public class TreeOperations {

    public static long find_Ways(int N)
    {

        int [][] array = new int[N+1][3];
        array[1][0]= 1;
        array[1][2]= 1;

        array[2][0] = array[1][2];
        array[2][2] = array[1][0];
        for( int i=3;i<=N;i++){
            array[i][0]= array[i-2][2] +array[i-1][2];
            array[i][2]= array[i-2][0] +array[i-1][0];
        }
        return array[N][0]+array[N][2];
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */

    }

    public static void main(String[] args) {
        System.out.println(find_Ways(4));
    }
}