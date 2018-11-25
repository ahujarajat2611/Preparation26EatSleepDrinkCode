package Algorithms6hourTraining;
import java.util.*;

/**
 * Created by hadoop on 21/12/17.
 */
public class TopKWords {

    // top k words means min heap no brainer it is !!!!
    // need count go through the hashmap that keeps count of each word
    // onnce i have that that it is no brainer simple put in map with count as key
    // if size of map gets more than k poll keep doin it at the end your min heap would have everything !!!!
    List<String> topK(String []words,int k){
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        // Remember you cannot create ENtry Object on your own // you have to rely on map entry set to provide
        // you set of entriies objecct
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o2.getKey().compareTo(o1.getKey());
                }
                else {
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            // Keep addding and polling if size is more than K that simple it is
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey());
        }
        return result;
    }
}
