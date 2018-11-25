package PracticeOneWeek26;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
/**
 * Created by hadoop on 7/12/17.
 */
public class SerializeTree {
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
        // both left right needs to be incremented
        index.set(index.get()+1);
        node.left = deserilizeHelper(list,index);
        index.set(index.get()+1);
        node.right = deserilizeHelper(list,index);
        return node;
    }
}
