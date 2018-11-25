package BasicAlgorithms.kth;

/**
 * Created by hadoop on 25/2/18.
 */
import java.util.*;
public class TopKIterator {
    private PriorityQueue<Integer> minheap;
    private int maxSize;

    public TopKIterator(int k) {
        minheap = new PriorityQueue<Integer>();
        maxSize = k;
    }

    public void add(int num) {
        if (minheap.size() < maxSize) {
            minheap.offer(num);
        } else {
            if (num > minheap.peek()) {
                minheap.poll();
                minheap.offer(num);
            }
        }

    }

    public List<Integer> topk() {
        Iterator iter = minheap.iterator();
        List<Integer> result = new ArrayList<Integer>();
        while (iter.hasNext()) {
            result.add((Integer) iter.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}

