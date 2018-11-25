package SystemDesign;
import java.util.*;

public class LFUCache {
    
    private int min;

    private final int capacity;
    private final HashMap<Integer, Integer> keyToVal;
    private final HashMap<Integer, Integer> keyToCount;
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;
    
    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        
        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key); // remove key from current count (since we will inc count)
        if (count == min && countToLRUKeys.get(count).size() == 0) min++; // nothing in the current min bucket
        
        putCount(key, count + 1);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value); // update key's value
            get(key); // update key's count
            return;
        } 
        
        if (keyToVal.size() >= capacity)
            evict(countToLRUKeys.get(min).iterator().next()); // evict LRU from this min count bucket
        
        min = 1;
        putCount(key, min); // adding new key and count
        keyToVal.put(key, value); // adding new key and value
    }
    
    private void evict(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }
    
    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }
}
/*
public class LFUCache {
    HashMap<Integer, LinkedHashSet<Integer>> keys;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, Integer> keyValue;
    int capacity;
    int minCount;
    public LFUCache(int capacity) {
        keys = new HashMap<>();
        counts = new HashMap<>();
        keyValue = new HashMap<>();
        this.capacity = capacity;
        minCount = 0;
    }

    public int get(int key) {
        if(capacity <=0) return -1;
        if (!keyValue.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key,count+1); // Update the count of this key
        Set<Integer> lhs = keys.get(count);
        lhs.remove(key);
        if(count == minCount && lhs.isEmpty()) {
            minCount++;
        }
        if(!keys.containsKey(count+1)) {
            keys.put(count+1, new LinkedHashSet<Integer>());
        }
        keys.get(count+1).add(key);
        return keyValue.get(key);
    }

    public void put(int key, int value) {
        if(capacity <= 0) return;
        if(keyValue.containsKey(key)) {
            keyValue.put(key,value);
            get(key);
            return;
        } else {
            if(keyValue.size() >= capacity) { // Eviction
                int evictionKey = keys.get(minCount).iterator().next();
                keys.get(minCount).remove(evictionKey);
                keyValue.remove(evictionKey);
                counts.remove(evictionKey);
            }
            keyValue.put(key, value); // Put the entry in the HashMap
            LinkedHashSet<Integer> lhs;
            if(keys.containsKey(1)){
                lhs = keys.get(1);
            } else {
                lhs = new LinkedHashSet<Integer>();
            }
            lhs.add(key);
            counts.put(key,1);
            keys.put(1,lhs);
            minCount = 1;
        }
    }
}
 */