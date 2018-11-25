package DSA;
import java.util.*;
public class Solution {
    public class HashHeap {

        // simple as hell
        // we need to store index in the hashMap
        // so that i can keep track of element while deletion
        //. now why just store index
        // we can store number of times elemen repeating
        // since keps are uniue in hashmap
        // can insert duplicates entries in that !!
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
            // id is nothing but index!!!!!

            // which we are storing in the hashmap
            // !!!!
            // get index at which it got insertedd
            int id = heap.size()-1;
            while (parent(id) > -1) {
                int parentId = parent(id);
                if (heap.get(id) > heap.get(parentId)) {
                    // swap two heights
                    swap(id, parentId);
                    // update hashmap
                    // i think here parent index should have been updates not id's
                    // but we have swapped values at id's index
                    // so at id's index its parent value we fetch parent value
                    //and insertiing at child index
                     // this is fucking awesome correct !!!!
                    // find correct index of of height that we inserted
                    // unti lthen correct [arents value  with correct index
                    // since values got swapped
                    // id, and vlaue at id is correcct
                    hashmap.put(heap.get(id), new Node(id, 1));
                    // update id
                    // hold on
                    // we have not updated parent's value index // since that also got modified
                    // not sure why there is mistake!1
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
    
    public class Edge {
        int index;
        int height;
        boolean left;
        public Edge(int index, int height, boolean left) {
            this.index = index;
            this.height = height;
            this.left = left;
        }
    }
    
    // Used for searching through hashmap
    public class Height {
        int index;
        int height;
        public Height(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        // Solution: use a max heap to store the heights of buildings
        //           add the height when reaches the left edge, and delete it when reaches the right edge
        //           if the current height changes, add the point to final list
        //           use hash heap to reduce time complextity
        List<int[]> ret = new ArrayList<int[]>();
        // number of buildings
        int n = buildings.length;
        if (n == 0) return ret;
        Edge[] buildingNodes = new Edge[2*n];
        // add buildings
        for (int i=0; i<n; i++) {
            buildingNodes[2*i] = new Edge(buildings[i][0], buildings[i][2], true);
            buildingNodes[2*i+1] = new Edge(buildings[i][1], buildings[i][2], false);
        }
        // Sort by node.index
        Arrays.sort(buildingNodes, new Comparator<Edge>() {
            public int compare(Edge a, Edge b) {
                // if index is the same
                if (a.index == b.index) {
                    // all the right edges go before left edges
                    // all the right edges go from short to tall
                    // all the left edges go from tall to short
                    if (a.left == false) {
                        if (b.left == true) {
                            return -1;
                        } else {
                            return a.height - b.height;
                        }
                    } else {
                        if (b.left == false) {
                            return 1;
                        } else {
                            return b.height - a.height;
                        }
                    }
                } else {
                    return a.index - b.index;
                }
            }
        });
        // add nodes to heap
        HashHeap heap = new HashHeap();
        int prevHeight = 0;
        for (int i=0; i<2*n; i++) {
            if (buildingNodes[i].left) {
                // add height
                heap.add(buildingNodes[i].height);
            } else {
                heap.delete(buildingNodes[i].height);
            }
            int height = heap.peek();
            if (height != prevHeight) {
                int[] point = new int[]{buildingNodes[i].index, height};
                // check the prev pair's index part
                if (ret.size() >0 && ret.get(ret.size()-1)[0] == buildingNodes[i].index) {
                    // if previous one is right, this one is left and their heights are the same
                    if (buildingNodes[i-1].left == false && buildingNodes[i].left == true && buildingNodes[i].height == buildingNodes[i-1].height) {
                        ret.remove(ret.size()-1);
                    } else {
                        ret.set(ret.size()-1, point);
                    }
                } else {
                    ret.add(point);
                }
                prevHeight = height;
            }
        }
        return ret;
    }
}