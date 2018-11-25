package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
public class ZigzagIterator {
    public class CyclingIterator {

        private List<Iterator<Integer>> iterators;
        int index;
        public CyclingIterator(List<List<Integer>> lists) {
            iterators = new ArrayList<>();
            for (int i = 0; i < lists.size(); i++) {
                iterators.add(lists.get(i).iterator());
            }
        }

        public int next() {
            if (!hasNext()) {
                throw new RuntimeException("Empty iterator!");
            }
            Iterator<Integer> curr = iterators.get(index);
            int toReturn = curr.next();
            if (!curr.hasNext()) {
                iterators.remove(index);
            } else {
                index++;
            }
            if (index == iterators.size()) {
                index = 0;
            }
            return toReturn;
        }

        public boolean hasNext() {
            return iterators.size() > 0;
        }
    }
}
