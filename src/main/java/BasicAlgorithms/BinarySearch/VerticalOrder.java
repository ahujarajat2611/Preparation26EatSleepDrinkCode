package BasicAlgorithms.BinarySearch;

import java.util.*;

/**
 * Created by hadoop on 17/10/17.
 */
public class VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> treeMap = new TreeMap<>();
        dfs(root,0,0,treeMap);
        Iterator<TreeMap<Integer,List<Integer>>> it = treeMap.values().iterator();
        while (it.hasNext()){
            TreeMap<Integer,List<Integer>> integerListTreeMap = it.next();
            List<Integer> path = new ArrayList<>();
            Iterator<List<Integer>> list = integerListTreeMap.values().iterator();
            while (list.hasNext()){
                path.addAll(list.next());
            }
            result.add(path);
        }
        return result;
    }

    private void dfs(TreeNode root, int level,int height, TreeMap<Integer, TreeMap<Integer,List<Integer>>> treeMap) {
        if(root == null){
            return;
        }
        if(!treeMap.containsKey(level)){
            treeMap.put(level,new TreeMap<>());
        }
        if(!treeMap.get(level).containsKey(height)){
            treeMap.get(level).put(height,new ArrayList<>());
        }
        treeMap.get(level).get(height).add(root.val);
        dfs(root.left,level-1,height+1,treeMap);
        dfs(root.right,level+1,height+1,treeMap);
    }

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            this.val = x;
        }
    }
}
