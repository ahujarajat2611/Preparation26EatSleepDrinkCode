package BasicAlgorithms.SlidingWindow;

import java.util.*;
public class Solution {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0){
            return result;
        }
        Stream s = new Stream();
        for(int i = 0; i < k; i++){
            s.add(nums[i]);
        }
        result.add(s.median());
        for (int i = k; i < nums.length; i++){
            s.add(nums[i]);
            s.delete(nums[i - k]);
            result.add(s.median());
        }
        return result;
    }
}

class Stream {
    HashHeap hhmin;
    HashHeap hhmax;

    public Stream() {
        this.hhmin = new HashHeap(true);
        this.hhmax = new HashHeap(false);
    }

    public void add(int a){
        hhmax.add(a);
        hhmin.add(hhmax.poll());
        if (hhmin.size() - hhmax.size() > 2){
            hhmax.add(hhmin.poll());
        }
    }

    public void delete(int a){
        // always let hhmax.size() smaller
        if (hhmax.contains(a)){
            hhmax.delete(a);
        } else {
            hhmin.delete(a);
            if (hhmax.size() > 0){
                hhmin.add(hhmax.poll());
            }
        }
        // make adjustment if necessary
        if (hhmin.size() - hhmax.size() > 2){
            hhmax.add(hhmin.poll());
        }
    }

    public int median(){
        return hhmin.peek();
    }
}

class Node {
    int pos;
    int num;

    public Node(int pos, int num){
        this.pos = pos;
        this.num = num;
    }
}

class HashHeap {
    ArrayList<Integer> heap;
    HashMap<Integer, Node> hash;
    boolean isMinHeap;
    int size;

    public HashHeap(boolean isMinHeap){
        heap = new ArrayList<Integer>();
        hash = new HashMap<Integer, Node>();
        this.isMinHeap = isMinHeap;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public boolean contains(int a){
        return hash.containsKey(a);
    }

    public int peek(){
        return heap.get(0);
    }

    // a represents value
    public void add(int a){
        size++;
        if (hash.containsKey(a)){
            Node thisVal = hash.get(a);
            hash.put(a, new Node(thisVal.pos, thisVal.num + 1));
        } else {
            heap.add(a);
            hash.put(a, new Node(heap.size() - 1, 1));
            siftUp(heap.size() - 1);
        }
    }

    public int poll(){
        size--;
        int topValue = heap.get(0);
        Node topNode = hash.get(topValue);
        if (topNode.num == 1){
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            hash.remove(topValue);
            siftDown(0);
        } else {
           hash.put(topValue, new Node(topNode.pos, topNode.num - 1)); 
        }
        return topValue;
    }

    // a represents value
    public void delete(int a){
        size--;
        Node thisVal = hash.get(a);
        if (thisVal.num == 1){
            swap(thisVal.pos, heap.size() - 1);
            heap.remove(heap.size() - 1);
            hash.remove(a);
            if (heap.size() > thisVal.pos){
                siftUp(thisVal.pos);
                siftDown(thisVal.pos);
            }
        } else {
            hash.put(a, new Node(thisVal.pos, thisVal.num - 1));
        }
    }

    // requires a valid k
    public void siftUp(int k){
        if (isMinHeap){
            while((k - 1) / 2 >= 0 && heap.get(k) < heap.get((k - 1) / 2)){
                swap(k, (k - 1) / 2);
                k = (k - 1) / 2;
            }
        } else {
            while((k - 1) / 2 >= 0 && heap.get(k) > heap.get((k - 1) / 2)){
                swap(k, (k - 1) / 2);
                k = (k - 1) / 2;
            }
        }
    }

    // does not require a valid k
    public void siftDown(int k){
        if (isMinHeap){
            while(k < heap.size()){
                int indexOfMin = k;
                if (2 * k + 1 < heap.size() && heap.get(2 * k + 1) < heap.get(indexOfMin)){
                    indexOfMin = 2 * k + 1;
                }
                if (2 * k + 2 < heap.size() && heap.get(2 * k + 2) < heap.get(indexOfMin)){
                    indexOfMin = 2 * k + 2;
                }
                if (indexOfMin == k){
                    return;
                }
                swap(k, indexOfMin);
                k = indexOfMin;
            }
        } else {
            while(k < heap.size()){
                int indexOfMax = k;
                if (2 * k + 1 < heap.size() && heap.get(2 * k + 1) > heap.get(indexOfMax)){
                    indexOfMax = 2 * k + 1;
                }
                if (2 * k + 2 < heap.size() && heap.get(2 * k + 2) > heap.get(indexOfMax)){
                    indexOfMax = 2 * k + 2;
                }
                if (indexOfMax == k){
                    return;
                }
                swap(k, indexOfMax);
                k = indexOfMax;
            }
        }
    }

    public void swap(int a, int b){
        int valA = heap.get(a);
        int valB = heap.get(b);
        Node nodeA = hash.get(valA);
        Node nodeB = hash.get(valB);
        heap.set(a, valB);
        heap.set(b, valA);
        hash.put(valA, new Node(nodeB.pos, nodeA.num));
        hash.put(valB, new Node(nodeA.pos, nodeB.num));
    }
}