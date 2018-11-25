package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HashMapCustom<K, V> {

    private int ENTRYSET_ARRAY_SIZE = 256;
    @SuppressWarnings("unchecked")
    private EntrySet<K, V>[] entrySetArray
            = new EntrySet[ENTRYSET_ARRAY_SIZE];

    public void put(K key, V value) {
        // create hash from the key and do modulo
        // over the length of the entry set array size
        int hashCode = getHashFromKey(key);
        EntrySet<K, V> entrySet = new EntrySet<K, V>(key, value);

        // If the entry is free we store the entrySet in the free array position
        if (entrySetArray[hashCode] == null) {
            entrySetArray[hashCode] = entrySet;
            return;
        }

        // here we are not hcecking if that key already exists or not
        // that like basic thing not implemented here
        // idea is to create entry class( next pointter as well ) and entry set
        // we have a "collision" so we have to append the entrySet to the linkedList
        // we go to the end of the linkedList and then we append the new entrySet there
        EntrySet<K, V> currentEntrySet = entrySetArray[hashCode];
        while (currentEntrySet.next() != null) {
            currentEntrySet = currentEntrySet.next();
        }
        currentEntrySet.setNext(entrySet);
    }

    public V get(K key) throws Exception {
        int hashCode = getHashFromKey(key);
        EntrySet<K, V> entrySet = entrySetArray[hashCode];

        // We need to iterate over the linkedList and see which one is
        // the hash of our key
        while (entrySet != null) {
            if (entrySet.getKey().equals(key)) {
                return entrySet.getValue();
            }
            entrySet = entrySet.next();
        }

        throw new Exception(String.format("Key %s does not exist", key.toString()));
    }

    protected int getHashFromKey(K key) {
        return Math.abs(key.hashCode() % ENTRYSET_ARRAY_SIZE);
    }

    public Set<K> keySet(){
        Set<K> keys = new HashSet<K>();
        for(int i = 0; i < ENTRYSET_ARRAY_SIZE; i++){
            EntrySet<K, V> entry = entrySetArray[i];
            while(entry != null){
                keys.add(entry.getKey());
                entry = entry.next();
            }
        }
        return keys;
    }
}

class EntrySet<K, V> {
    private K key;
    private V value;
    private EntrySet<K, V> next;

    public EntrySet(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public EntrySet<K, V> next() {
        return next;
    }

    public void setNext(EntrySet<K,V> next){
        this.next = next;
    }
}
// class HashMap<K,V>
//{
//    private double loadFactor = 0.75;
//    private Entry[] table;
//    private int elemCount;;
//
//    public static class Entry
//    {
//        K key;
//        V value;
//        Entry<K,V> next;
////contructors, getters and setters below
//...
//    }
//    /**
//     * Insert your super-mega-hash-function below :)
//     */
//    static int hash(int h)
//    {
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
//
//    public void put(K key, V value)
//    {
//        if (elemCount>table.length*loadFactor) resize();//resize the table, if elements> above len*loadfactor
//
//        int index = hash(key.hashCode())%table.length;
//        if (table[index]==null) table[index] = new Entry(key,value);
//        else
//        {
//            Entry cur = table[index];
//            while(true)
//            {
//                if (cur.getKey().equals(key))
//                {
//                    cur.setValue(value);
//                    break;
//                }
//                if (cur.next()==null) break;
//                cur = cur.next();// end and the element does not exist in table!
//            }
//
//            cur.setNext(new Entry(key,value));//add it to end of table
//        }
//    }
//
//    public V get(K key)
//    {
//        int index = hash(key.hashCode())%table.length;
//        if (table[index]==null) return null;//if value at index==null, return null
//        else
//        {
//            Entry cur = table[index];
//            while(true)
//            {
//                if (cur.getKey().equals(key))// check if it exists in table
//                {
//                    return cur.getValue();
//                }
//                if (cur.next()==null)
//                    break;
//                cur = cur.next();
//            }
//            return null;// not in map!
//        }
//    }
//
//    public void resize()// resize the table by creating a new table of length=1.5* old table length
////instantiate new table
////copy all elements from old table to new table and return it
//    {
//        int newSize = table.length*1.5;
//        Entry[] newTable = new Entry[newSize];
//        for (int i=0; i<table.length; i++)
//            newTable[i]=table[i];
//        table = newTable;
//    }
////contructors, getters and setters below
//...
//}




//    public V put(K key, V value){
//        if(key == null)
//            return putForNullKey(value);
//        int hash = hash(key.hashCode());
//        int i = indexFor(hash, table.length);
//        for(Entry<K, V> e = table[i]; e != null; e = e.next){
//            Object k;
//            // Collision
//            if(e.hash == hash && K == e.key || key.equals(k)){
//                V oldValue = e.value;
//                e.value = value;
//                e.recordAccess(this);
//                return oldValue;
//            }
//        }
//        modCount++;
//        addEntry(hash, key, value, i);
//        return null;
//    }

//import static java.util.Collections.*;
//
//        import java.util.Collection;
//        import java.util.HashMap;
//        import java.util.Map;
//        import java.util.Set;
//        import java.util.concurrent.TimeUnit;

/**
 * A hash map that expires and removes items if they are older than a given
 * time-to-live.
 * <p>
 * The expiry is a passive process, items aren't removed until they are
 * retrieved and deemed to be expired by {@link #get(Object)}.
 */
//class TtlHashMap<K, V> implements Map<K, V> {
//
//    private final HashMap<K, V> store = new HashMap<>();
//    private final HashMap<K, Long> timestamps = new HashMap<>();
//    private final long ttl;
//
//    public TtlHashMap(TimeUnit ttlUnit, long ttlValue) {
//        this.ttl = ttlUnit.toNanos(ttlValue);
//    }
//
//    @Override
//    public V get(K key) {
//        V value = this.store.get(key);
//
//        if (value != null && expired(key, value)) {
//            store.remove(key);
//            timestamps.remove(key);
//            return null;
//        } else {
//            return value;
//        }
//    }
//
//    private boolean expired(Object key, V value) {
//        return (System.nanoTime() - timestamps.get(key)) > this.ttl;
//    }
//
//    @Override
//    public V put(K key, V value) {
//        timestamps.put(key, System.nanoTime());
//        return store.put(key, value);
//    }
//
//    @Override
//    public int size() {
//        return store.size();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return store.isEmpty();
//    }
//
//    @Override
//    public boolean containsKey(Object key) {
//        return store.containsKey(key);
//    }
//
//    @Override
//    public boolean containsValue(Object value) {
//        return store.containsValue(value);
//    }
//
//    @Override
//    public V remove(Object key) {
//        timestamps.remove(key);
//        return store.remove(key);
//    }
//
//    @Override
//    public void putAll(Map<? extends K, ? extends V> m) {
//        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
//            this.put(e.getKey(), e.getValue());
//        }
//    }
//
//    @Override
//    public void clear() {
//        timestamps.clear();
//        store.clear();
//    }
//
//    @Override
//    public Set<K> keySet() {
//        clearExpired();
//        return unmodifiableSet(store.keySet());
//    }
//
//    @Override
//    public Collection<V> values() {
//        clearExpired();
//        return unmodifiableCollection(store.values());
//    }
//
//    @Override
//    public Set<java.util.Map.Entry<K, V>> entrySet() {
//        clearExpired();
//        return unmodifiableSet(store.entrySet());
//    }
//
//    private void clearExpired() {
//        for (K k : store.keySet()) {
//            this.get(k);
//        }
//    }
//
//}
//https://howtodoinjava.com/core-java/collections/how-hashmap-works-in-java/
//http://www.javamadesoeasy.com/2015/04/concurrenthashmap-in-java.html

//
//public class HashMap<K,V>
//{
//    private double loadFactor = 0.75;
//    private Entry[] table;
//    private int elemCount;;
//
//    public static class Entry
//    {
//        K key;
//        V value;
//        Entry<K,V> next;
////contructors, getters and setters below
//...
//    }
//    /**
//     * Insert your super-mega-hash-function below :)
//     */
//    static int hash(int h)
//    {
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
//
//    public void put(K key, V value)
//    {
//        if (elemCount>table.length*loadFactor) resize();//resize the table, if elements> above len*loadfactor
//
//        int index = hash(key.hashCode())%table.length;
//        if (table[index]==null) table[index] = new Entry(key,value);
//        else
//        {
//            Entry cur = table[index];
//            while(true)
//            {
//                if (cur.getKey().equals(key))
//                {
//                    cur.setValue(value);
//                    break;
//                }
//                if (cur.next()==null) break;
//                cur = cur.next();// end and the element does not exist in table!
//            }
//
//            cur.setNext(new Entry(key,value));//add it to end of table
//        }
//    }
//
//    public V get(K key)
//    {
//        int index = hash(key.hashCode())%table.length;
//        if (table[index]==null) return null;//if value at index==null, return null
//        else
//        {
//            Entry cur = table[index];
//            while(true)
//            {
//                if (cur.getKey().equals(key))// check if it exists in table
//                {
//                    return cur.getValue();
//                }
//                if (cur.next()==null)
//                    break;
//                cur = cur.next();
//            }
//            return null;// not in map!
//        }
//    }
//
//    public void resize()// resize the table by creating a new table of length=1.5* old table length
////instantiate new table
////copy all elements from old table to new table and return it
//    {
//        int newSize = table.length*1.5;
//        Entry[] newTable = new Entry[newSize];
//        for (int i=0; i<table.length; i++)
//            newTable[i]=table[i];
//        table = newTable;
//    }
////contructors, getters and setters below
//...
//}