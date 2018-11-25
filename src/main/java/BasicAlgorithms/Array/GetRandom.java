package BasicAlgorithms.Array;

import java.util.*;
/**
 * Created by hadoop on 24/1/18.
 */
/*
Insert Delete GetRandom O(1) I and II
Design a data structure that supports all following operations in average O(1) time.
insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 1 is the only number in the set, getRandom always return 1.
randomSet.getRandom();

 */


/*


There are lots of ways to achieve the functionality. My way is to use two maps. The first one uses index as the key and value as the value. The second one is reverse to the first one: value as the key and index as the value. When we insert an element, we increase the index and insert the element to both maps. When we remove it, we get the index of the element from the second map. We then get the last element we insert from the first map. We assign the index of the last element to the one we need to remove. And then remove the element to be deleted from both maps. To get a random element, we get a random key from all indices and get the value from the first map.


 */
public class GetRandom {
    class RandomizedSet {
        // reverse mapping also availabl e
        private Map<Integer, Integer> ordered;
        private Map<Integer, Integer> reverse;
        private int size;
        private Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            ordered = new HashMap<>();
            reverse = new HashMap<>();
            size = 0;
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (reverse.containsKey(val)) {
                return false;
            }
            ordered.put(size, val);
            reverse.put(val, size);
            size++;
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!reverse.containsKey(val)) {
                return false;
            }
            int pos = reverse.get(val);
            int switchNumber = ordered.get(size - 1);
            ordered.put(pos, switchNumber);
            reverse.put(switchNumber, pos);
            ordered.remove(size - 1);
            reverse.remove(val);
            size--;
            return true;

        }

        /** Get a random element from the set. */
        public int getRandom() {
            int pos = random.nextInt(size);
            return ordered.get(pos);
        }
    }
    /*
    The second problem is similar to the first one, the only difference is that for the value map, we need to use a data structure for different indices with the same value. Any data structure is ok as long as you can ensure O(1) get. Here I'm using a stack. The rest is the same as the first one.
     */
    class RandomizedCollection {
        Map<Integer, Stack<Integer>> vals;
        Map<Integer, Integer> index;
        int size;
        Random random;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            vals = new HashMap<>();
            index = new HashMap<>();
            random = new Random();
            size = 0;
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if (vals.containsKey(val)) {
                vals.get(val).add(size);
                index.put(size, val);
                size++;
                return false;
            } else {
                vals.put(val, new Stack<>());
                vals.get(val).add(size);
                index.put(size, val);
                size++;
                return true;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!vals.containsKey(val)) {
                return false;
            }
            int pos = vals.get(val).pop();
            int toSwitch = index.get(size - 1);
            if (toSwitch != val) {
                vals.get(toSwitch).pop();
                vals.get(toSwitch).push(pos);
                index.put(pos, toSwitch);
            }

            if (vals.get(val).isEmpty()) {
                vals.remove(val);
            }
            size--;
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int pos = random.nextInt(size);
            return index.get(pos);
        }
    }
}
