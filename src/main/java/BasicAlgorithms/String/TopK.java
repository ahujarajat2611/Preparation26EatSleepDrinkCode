package BasicAlgorithms.String;

import java.util.*;

/**
 * Created by hadoop on 21/10/17.
 */
public class TopK {
    private static class Node implements Comparable <Node>{
        String str;
        Integer freq;

        Node(String str, Integer freq) {
            this.str = str;
            this.freq = freq;
        }
        public int compareTo(Node that){

            if(this.freq == that.freq){
                return this.str.compareTo(that.str);
            }
            return this.freq-that.freq;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return str != null ? str.equals(node.str) : node.str == null;
        }
    }

        public String[] topKFrequentWords(String[] words, int k) {
            String[] rst = new String[k];
// better method wud be creating min heap
            HashMap<String,Node> hashMap = new HashMap<>();
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.freq-o1.freq;
                }
            });
            for(String word:words){
                if(!hashMap.containsKey(word)){
                    hashMap.put(word,new Node(word,0));
                }
                hashMap.get(word).freq = hashMap.get(word).freq +1;
            }

            for(Map.Entry<String,Node> entry:hashMap.entrySet()){
                priorityQueue.add(entry.getValue());
            }
            for(int i=0;i<k;i++){
                rst[i] = priorityQueue.poll().str;
            }
            return rst;
        }




//        // this will not work since map can have duplicates !!!
//
//        public String[] topKFrequentWordsMinHeap(String[] words, int k) {
//            String[] rst = new String[k];
//// better method wud be creating min heap
//            HashMap<String,Node> hashMap = new HashMap<>();
//            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
//            for(String word:words){
//                if(!hashMap.containsKey(word)){
//                    hashMap.put(word,new Node(word,0));
//                }
//                hashMap.get(word).freq = hashMap.get(word).freq +1;
//                if(priorityQueue.peek().freq<hashMap.get(word).freq){
//                    priorityQueue.poll();
//                    priorityQueue.add(hashMap.get(word));
//                }
//            }
//      //      for(Map.Entry<String,Node> entry:hashMap.entrySet()){
//        //        priorityQueue.add(entry.getValue());
//       //     }
//            for(int i=0;i<k;i++){
//                rst[i] = priorityQueue.poll().str;
//            }
//            return rst;
//        }

      //  There is new file to refer this

//        public List<String> topKFrequentWordsMinHeapNew(String[] words, int k) {
//            List<String> rst = new ArrayList<String>();
//            // better method wud be creating min heap
//            HashMap<String,Node> hashMap = new HashMap<>();
//            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
//            for(String word:words){
//                if(!hashMap.containsKey(word)){
//                    hashMap.put(word,new Node(word,0));
//                }
//                hashMap.get(word).freq = hashMap.get(word).freq +1;
//                if(priorityQueue.contains(hashMap.get(word))){
//                    System.out.println("coming heer");
//                    priorityQueue.remove(hashMap.get(word));
//                    priorityQueue.add(hashMap.get(word));
//                }
//                else if(priorityQueue.size()<k){
//                    priorityQueue.add(hashMap.get(word));
//                }
//                else if(priorityQueue.peek().freq<hashMap.get(word).freq){
//                    priorityQueue.poll();
//                    priorityQueue.add(hashMap.get(word));
//                }
//            }
//            for(int i=0;i<k;i++){
//                rst.add(priorityQueue.poll().str);
//            }
//            return rst;
//        }
        public static void main(String args[]){

        String []array  = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int x =  4;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node("rajat",1));
            System.out.println(pq);
            System.out.println(pq.size());
            System.out.println(pq.contains(new Node("ahu",2)));
        TopK topK = new TopK();
           // System.out.println(topK.topKFrequentWordsMinHeapNew(array,4));
    }
    }
