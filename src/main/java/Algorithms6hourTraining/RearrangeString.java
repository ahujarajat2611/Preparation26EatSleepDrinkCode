package Algorithms6hourTraining;
import java.util.*;

/**
 * Created by hadoop on 21/12/17.
 */
/*
 Get the frequency of all in the map of char to int
 we first try to place k ...whole frequency is higher ( k is cool off perriod)
 while doing this map gets empty and k >0 then there are two cases possible whhether actually map got empty
 or it has elements once we copy bak from temp list that we storing with us !!
 now at the end check if we got all chars covered


 // Also for time slot thing if after copying it is the last case means no data in the my priority queue then

 // then for sure !!! last case else addd time and wait for cool down !!! even if my n >0 ( since i will pick tasks which are not
 same .. 3 tasks but time is 10 ... then after dooung 3 tasks i wait for 7 seocnd so .. if i have 10 tasks and 10 second cool down
 i do not wait !!! in any case u adding 10 unless it is the last case !!!!!
 */
public class RearrangeString {
    public String rearrangeString(String str, int k) {
        if( k ==0){
            return str;
        }
        if(str.length() ==1){
            return str;
        }

        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                 if(entry2.getValue() ==entry1.getValue()){
                    return entry1.getKey()-entry2.getKey();
                }
                else return entry2.getValue()-entry1.getValue();
            }
        });

        maxHeap.addAll(map.entrySet());
        String res ="";
        // while heap is not empty () !!  thts the starting condition
        while (!maxHeap.isEmpty()){
            int n = k;
            Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
            while (!maxHeap.isEmpty() && n >0){
                Map.Entry<Character,Integer> entry = maxHeap.poll();
                res = res + entry.getKey();
                n--;
                waitQueue.add(entry);
                // saving thing in my waiteueue and later copy it to wait queue
            }
       //     System.out.println(n);
        //    System.out.println(res);
            while (!waitQueue.isEmpty()){
                Map.Entry<Character,Integer> entry = waitQueue.poll();
                entry.setValue(entry.getValue()-1);
                // reduce 1 and see if things remaining to be done
                if(entry.getValue()>0){
                    maxHeap.add(entry);
                }
            }
            //thats the only condition that needs to be dealt here !!!!!
            // things remainung to be done and n>0 fuck there is problem we can not rearrage
            if(maxHeap.size()!=0 && n>0){
                return "";
            }
            /*
            if(maxheap.size() == 0 and what ever)
            it will break inn while loop

            if(maxheap.size()!= 0 and n ==0){
                thats what we want idedall so that rearrnagemend of string happens properly
                do nothing !!!
            }



             */
            /*
            if(!maxHeap.isEmpty()){
                    totalSlot = totalSlot+ n+1;
                }
                else {
                    totalSlot = totalSlot+temp.size();
                }
             */
        }
      //  System.out.println(res);
        return res.length() == str.length() ? res:"";
    }

    public static void main(String[] args) {
        RearrangeString rearrangeString = new RearrangeString();
        System.out.println(rearrangeString.rearrangeString("ababb",2));
    }
}