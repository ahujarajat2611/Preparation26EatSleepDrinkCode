package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
/*
Use any-order traversal to serialize the tree and then deserialize it. Note for serialization we cannot save any state so no global variable can be used. I convert the whole string to an iterator for deserialization.

 */
public class SerializeTree {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "#,";
            return String.valueOf(root.val) + "," + serialize(root.left) + serialize(root.right);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return getNode(Arrays.asList(data.substring(0, data.length() - 1).split(",")).iterator());
        }
        private TreeNode getNode(Iterator<String> tree) {
            if (!tree.hasNext()) {
                return null;
            }
            String c = tree.next();
            if ("#".equals(c)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(c));
            root.left = getNode(tree);
            root.right = getNode(tree);
            return root;
        }
    }
}
/*
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*import java.util.concurrent.atomic.AtomicInteger;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "# ";
        }
        return root.val+" "+serialize(root.left) + serialize(root.right);

    }
    AtomicInteger index = new AtomicInteger(0);

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String a){
        // AtomicInteger index = new AtomicInteger(0);

        List<String>list = new ArrayList<String>();
        String array[] = a.split(" ");
        for(int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        System.out.println(list);
        return deserilizeHelper(list);
    }

    private TreeNode deserilizeHelper(List<String> list) {
        if(index.get() >= list.size()){
            return null;
        }
        if(list.get(index.get()) .equals ("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(index.get())));
        index.set(index.get()+1);
        node.left = deserilizeHelper(list);
        index.set(index.get()+1);
        node.right = deserilizeHelper(list);
        return node;
    }
}
*/

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
