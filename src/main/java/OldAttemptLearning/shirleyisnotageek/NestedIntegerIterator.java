package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 19/1/18.
 */
public class NestedIntegerIterator {
    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedIntegers) {
            for (int i = nestedIntegers.size() - 1; i >= 0; i--) {
                stack.push(nestedIntegers.get(i));
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }

            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
            return !stack.isEmpty();
        }
    }
    private class NestedInteger{
        public boolean isInteger(){
            return true;
        }

        public Integer getInteger(){
            return 1;
        }
         public List<NestedInteger> getList(){
            return new ArrayList<>();
         }
    }
}
