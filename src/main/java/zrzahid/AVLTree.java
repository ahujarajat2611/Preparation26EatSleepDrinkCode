package zrzahid;

/**
 * Created by hadoop on 6/9/17.
 */
public class AVLTree {
    public static void main(String[] args) {

    }
    private Node leftRotate(Node root){
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;



        //root.height = Math.max(height(root.left),height(root.right))+1;
        //root.size = size(root.left)+size(root.right)+1;
        return newRoot;
    }
    private Node rightRotate(Node root){
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = setheight(root);
        root.size = setsize(root);
        newRoot.height = setheight(newRoot);
        newRoot.size = setsize(newRoot);
        return newRoot;
    }
    private int setheight(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(root.left!=null?root.left.height:0,root.right!=null?root.right.height:0);

    }
    private int setsize(Node root){
        if(root == null){
            return 0;
        }
        return 1 + (root.left!=null?root.left.size:0)+(root.right!=null?root.right.size:0);
    }
    private int height(Node root){
        return root!=null?root.size:0;
    }

    public  Node insert(Node root,int data){
        if(root == null){
            return new Node(data);
        }
        if(root.data<data){
            root.right = insert(root.right,data);
        }
        else{
            root.left = insert(root.left,data);

        }
        // i will balance after the both insertion loop
        // that's the right way to deal with this problem
        // check balance
        // check diff heights and you deal with me in certain way
        //
        int balance = balance(root.left,root.right);
        if(balance>1){
            // check which left is fucking more left left left right using
            // height ffunciton
            // storeing height and size at each node level
            if(height(root.left.left)>height(root.left.right)){
                root = rightRotate(root);
            }
            else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }
        else if(balance<-1){
            // other side balance
            // make sure to adjust heigth and size
            if(height(root.right.right)>=height(root.right.left)){
                root = leftRotate(root);
            }
            else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        // if everything gets balanced but still you needd
        // to updates hieghts and sizes since new node has been inserted in the tree
        else {
            root.height = setheight(root);
            root.size = setsize(root);
        }
        return root;
    }

    private int balance(Node left, Node right) {
        return height(left)-height(right);
    }

    private class Node{
        int data;
        int height;
        int size;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.size = 1;
            this.height = 1;
        }
    }
}
