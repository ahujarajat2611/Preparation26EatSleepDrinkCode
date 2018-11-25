package BasicAlgorithms.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 18/10/17.
 */
public class Closest2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        AtomicInteger integer = new AtomicInteger();
        closestKValuesHelper(root,target,integer,k,priorityQueue);
        List<Integer> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll());
        }
        return list;
    }

    private void closestKValuesHelper(TreeNode root, double target, AtomicInteger integer, int k,PriorityQueue<Integer> priorityQueue) {
        if(root == null){
            return;
        }
        closestKValuesHelper(root.left,target,integer,k,priorityQueue);
        if(integer.get()<k){

            priorityQueue.add(root.val);
            integer.set(integer.get()+1);
        }
        else {
            // to be honest
            ///here min priority queue does not make any sense
            // having a sorted list and delete frmo list is better option
            //take first element of list and compare it with new incoming element
            if(Math.abs(priorityQueue.peek()-target)>Math.abs(root.val-target)){
                Integer remove = priorityQueue.poll();
                priorityQueue.add(root.val);
            }
        }
        closestKValuesHelper(root.right,target,integer,k,priorityQueue);
    }

    private class  TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
}
/*
min heap solution


public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer arg0, Integer arg1){
                if(Math.abs(arg0-target) > Math.abs(arg1-target)) return 1;
                else if(Math.abs(arg0-target) < Math.abs(arg1-target)) return -1;
                else return 0;
            }
        });
        addToHeap(root, heap);
        for(int i=0; i<k; i++) {
            list.add(heap.poll());
        }
        return list;
    }

    public void addToHeap(TreeNode root, Queue<Integer> heap) {
        if(root == null) return;
        heap.offer(root.val);
        addToHeap(root.left, heap);
        addToHeap(root.right, heap);
    }
}


wow solution


public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();

        if(root == null) return ret;

        helper(root, ret, target, k);

        return ret;
    }
    // in order traversal保证遍历的数是增序的
    private void helper(TreeNode root, List<Integer> list, double target, int k){
        if(root == null) return;

        helper(root.left, list, target, k);

        if(list.size() < k){
            // 如果list里面的数量还不到K，可以直接放进去等待以后处理
            list.add(root.val);
        }else{
            // 如果list已经满了，且当前的数小于target，
            // 因为前序遍历的数是增序的，这个当前数肯定比list里面最前面的数
            // 接近target
            if(root.val <= target){
                list.remove(0);
                list.add(root.val);
            }else{
                // 如果这个当前的数大于target, 且距离list里面最小的数相对target的距离更大
                // 就可以不用再往后搜了，因为后面的数还是增序的

                if(Math.abs(list.get(0) - target) > Math.abs(root.val - target)){
                    list.remove(0);
                    list.add(root.val);
                }else{
                    return;
                }
            }
        }

        helper(root.right, list, target, k);
    }
}
 */