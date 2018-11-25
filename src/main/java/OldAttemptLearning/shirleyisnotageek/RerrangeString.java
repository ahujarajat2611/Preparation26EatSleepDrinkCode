package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
Using a greedy approach. Every time we add the character with the highest frequency to the string. If there is no k distinct characters left in the queue, we return "". For all characters that have remaining frequency larger than 0, we add them back to queue.
 */
public class RerrangeString {
    public String rerrange(String s, int k) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!tempMap.containsKey(c)) {
                tempMap.put(c, 1);
            } else {
                tempMap.put(c, tempMap.get(c) + 1);
            }
        }

        PriorityQueue<Frequency> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
            queue.add(new Frequency(entry.getValue(), entry.getKey()));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Queue<Frequency> tempQueue = new LinkedList<>();
            for (int i = 0; i < k && sb.length() < s.length(); i++) {
                if (queue.isEmpty()) {
                    return "";
                }
                Frequency curr = queue.poll();
                sb.append(curr.c);
                curr.freq--;
                if (curr.freq > 0) {
                    tempQueue.add(curr);
                }
            }
            while (!tempQueue.isEmpty()) {
                queue.add(tempQueue.poll());
            }
        }
        return sb.toString();
    }

    private class Frequency implements Comparable<Frequency> {
        int freq;
        char c;

        public Frequency(int freq, char c) {
            this.c = c;
            this.freq = freq;
        }

        @Override 
        public int compareTo(Frequency o) {
            return o.freq - this.freq;
        }
    }
}
