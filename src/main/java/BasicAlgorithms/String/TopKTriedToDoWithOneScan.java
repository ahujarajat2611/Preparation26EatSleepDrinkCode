package BasicAlgorithms.String;

import java.util.*;
/**
 * Created by hadoop on 27/2/18.
 */
public class TopKTriedToDoWithOneScan {
        public List<String> topKFrequent(String[] words, int k) {
            //String[] rst = new String[k];
            List<Node> rst = new ArrayList<Node>();
            // better method wud be creating min heap
            HashMap<String,Node> hashMap = new HashMap<>();
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            for(String word:words){
                if(!hashMap.containsKey(word)){
                    hashMap.put(word,new Node(word,0));
                }
                hashMap.get(word).freq = hashMap.get(word).freq +1;
                if(priorityQueue.contains(hashMap.get(word))){
                    // System.out.println("coming heer");
                    priorityQueue.remove(hashMap.get(word));
                    priorityQueue.add(hashMap.get(word));
                }
                else if(priorityQueue.size()<k){
                    priorityQueue.add(hashMap.get(word));
                }
                else if(priorityQueue.peek().freq==hashMap.get(word).freq ){
                    int freq = priorityQueue.peek().freq;
                    //&& word.compareTo(priorityQueue.peek().str)<0
                    List<String> wordlist = new ArrayList<String>();
                    wordlist.add(word);
                    while(!priorityQueue.isEmpty() && priorityQueue.peek().freq == hashMap.get(word).freq){
                        wordlist.add(priorityQueue.poll().str);
                    }
                    Collections.sort(wordlist, new Comparator<String>(){
                        @Override
                        public int compare(String a, String b){
                            return b.compareTo(a);
                        }
                    });
                    String toBeRemoved = wordlist.get(0);
                    priorityQueue.remove(toBeRemoved);
                    wordlist.remove(0);
                    for(String insert:wordlist){
                        priorityQueue.add(new Node(insert,freq));
                    }
                    //priorityQueue.poll();
                    //priorityQueue.add(hashMap.get(word));
                }
                else if(priorityQueue.peek().freq<hashMap.get(word).freq){
                    priorityQueue.poll();
                    priorityQueue.add(hashMap.get(word));
                }
            }
            for(int i=0;i<k;i++){
                rst.add(priorityQueue.poll());
            }
            Collections.sort(rst,new Comparator<Node>(){

                @Override
                public int compare(Node a,Node b){
                    return b.freq-a.freq;
                }
            });
            List<String>ans = new ArrayList<String>();
            for(Node x:rst){
                ans.add(x.str);
            }

            return ans;
        }
        private class Node implements Comparable<Node>{
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

            @Override
            public int hashCode() {
                return str != null ? str.hashCode() : 0;
            }
        }
}
