package BasicAlgorithms.Heap;
import java.util.*;
public class HashHeap {
        ArrayList<Integer> heap;
        HashMap<Integer,Node> hashmap;
        
        public class Node {
            int id;
            int num;    // number of same integers
            public Node(int id, int num) {
                this.id = id;
                this.num = num;
            }
        }
        
        public HashHeap() {
            heap = new ArrayList<Integer>();
            hashmap = new HashMap<Integer,Node>();
        }
        
        public int peek() {
            if (heap.size() > 0) return heap.get(0).intValue();
            else return 0;
        }
        
        public void add(Integer height) {
            // if the hashmap already contains the height(height is not unique, so this is possible), update the num of such height
            if (hashmap.containsKey(height)) {
                hashmap.put(height, new Node(hashmap.get(height).id, hashmap.get(height).num+1));
                return;
            }
            // else add the height
            heap.add(height);
            int id = heap.size()-1;
            while (parent(id) > -1) {
                int parentId = parent(id);
                if (heap.get(id) > heap.get(parentId)) {
                    // swap two heights
                    swap(id, parentId);
                    // update hashmap
                    hashmap.put(heap.get(id), new Node(id, 1));
                    // update id
                    id = parentId;
                } else {
                    break;
                }
            }
            // final update
            hashmap.put(heap.get(id), new Node(id, 1));
        }
        
        public void delete(Integer height) {
            // if num of the height is bigger than 1(height is not unique, so this is possible), just update the num of such height
            if (hashmap.get(height).num > 1) {
                hashmap.put(height, new Node(hashmap.get(height).id, hashmap.get(height).num-1));
                return;
            }
            // else delete the height
            int id = hashmap.get(height).id;
            // swap two heights
            swap(id, heap.size()-1);
            hashmap.put(heap.get(heap.size()-1), new Node(heap.size()-1, 1));
            hashmap.put(heap.get(id), new Node(id, 1));
            // while left child's id is less than last id
            while (id*2+1 < heap.size()-1) {
                // if left child has bigger height or right child is last node
                int son;
                if (heap.get(id*2+1) > heap.get(id*2+2) || (id*2+2) == (heap.size()-1)) {
                    son = id*2+1;
                } else {
                    son = id*2+2;
                }
                // if son's height is bigger, then swap
                if (heap.get(son) > heap.get(id)) {
                    swap(son, id);
                    hashmap.put(heap.get(son), new Node(son, 1));
                    hashmap.put(heap.get(id), new Node(id, 1));
                    id = son;
                } else {
                    hashmap.put(heap.get(id), new Node(id, 1));
                    break;
                }
            }
            hashmap.remove(heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
        }
        
        public int parent(int id) {
            return (id-1)/2;
        }
        
        public void swap(int a, int b) {
            Integer temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        }
    }