package Algorithms6hourTraining;
import java.util.*;

/**
 * Created by hadoop on 21/12/17.
 */
//Picking things based pn max frequency. It is clear Cut greedy algorithm
  /*

    put into max heap all ENtry set and pop things as per max entry until queue becomes empty or you reach cooling period
    // if queue becommes emppty and you have not reached cooling period then wait
    // else queue is not empty and you reach cooling period ( ideal case )

    // may be queue itself becomes empty all items processsed, you no need to wait until cooling period
     */
//
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
                // Temp is being recreated at each step of the iteration
                // so in case your main queue gets empty just addd the size of temp
                // in case main heap is not empty then irreesp of k zero or not you have to wait until n+1( cooling period)
                // so addd n +1
                if(!maxHeap.isEmpty()){
                    // even if n
                    totalSlot = totalSlot+ n+1;
                }
                else {
                    totalSlot = totalSlot+temp.size();
                }
                /*
                // kind of cooling period in next question !!!
                if(maxHeap.size()!=0 && k>0){
                return "";
            }
                 */
            }
            return totalSlot;
        }
}
