package BasicAlgorithms.BinarySearch;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

class CodecAgain {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "# ";
        }
        return root.val+" "+serialize(root.left) + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String a){
        AtomicInteger index = new AtomicInteger(0);

        List<String>list = new ArrayList<String>();
        String array[] = a.split(" ");
        for(int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        System.out.println(list);
        return deserilizeHelper(list,index);
    }

    private TreeNode deserilizeHelper(List<String> list, AtomicInteger index) {
        if(index.get() >= list.size()){
            return null;
        }
        if(list.get(index.get()) .equals ("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(index.get())));
        // OMG WHAT A THING WHAT A MISCONCEPTION I HAD TILL NOW
        // GONNA INCREASE INDEX FOR BOTH LEFT AND RIGHT SUBTREE
        // GOTTA BE
        // YOU JUST CANT NOT INCREASE INDEX ON ONE SIZE AND NOT ON THE OTHER SIZE

        index.set(index.get()+1);
        node.left = deserilizeHelper(list,index);
        index.set(index.get()+1);
        node.right = deserilizeHelper(list,index);
        return node;
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