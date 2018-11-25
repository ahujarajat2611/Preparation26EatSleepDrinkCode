package DSA.Leetcode;

import Algorithms6hourTraining.RearrangeString;

import java.util.*;

/**
 * Created by hadoop on 20/2/18.
 */
public class RearrangeStringTaskSchedular {

    /**
     * Created by hadoop on 21/12/17.
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
            while (!maxHeap.isEmpty()){
                int n = k;
                Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
                while (!maxHeap.isEmpty() && n >0){
                    Map.Entry<Character,Integer> entry = maxHeap.poll();
                    res = res + entry.getKey();
                    n--;
                    waitQueue.add(entry);
                }
                //     System.out.println(n);
                //    System.out.println(res);
                while (!waitQueue.isEmpty()){
                    Map.Entry<Character,Integer> entry = waitQueue.poll();
                    entry.setValue(entry.getValue()-1);
                    if(entry.getValue()>0){
                        maxHeap.add(entry);
                    }
                }
                if(maxHeap.size()!=0 && n>0){
                    return "";
                }
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

    }

    /**
     * Created by hadoop on 21/12/17.
     */
    public class TaskSchedular {
        public int leastInterval(char[] tasks, int n) {
            if (tasks == null || tasks.length == 0) {
                return 0;
            }
            Map<Character, Integer> task2cnt = new HashMap<>(tasks.length * 4 / 3);
            for(char task:tasks){
                task2cnt.put(task,task2cnt.getOrDefault(task,0)+1);
            }
            Queue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });
            maxHeap.addAll(task2cnt.entrySet());
            int totalSlot=0;
            while (!maxHeap.isEmpty()){
                int k = n+1;
                List<Map.Entry<Character,Integer>> temp = new LinkedList<>();
                while (!maxHeap.isEmpty() && k >0){
                    temp.add(maxHeap.poll());
                    k--;
                }

                for(Map.Entry<Character,Integer> entry:temp){
                    entry.setValue(entry.getValue()-1);
                    if(entry.getValue()!=0) {
                        maxHeap.add(entry);
                    }
                }
                if(!maxHeap.isEmpty()){
                    // even if n
                    // i have to wait fofr n+1 time even if we have maxheap empty or not !!! as simple
                    totalSlot = totalSlot+ n+1;
                }
                else {
                    totalSlot = totalSlot+temp.size();
                }
                /*
                if(maxHeap.size()!=0 && n>0){
                return "";
            }
                 */
            }
            return totalSlot;
        }
    }

}

