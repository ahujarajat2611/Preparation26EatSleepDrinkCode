package SystemDesignCodes;

/**
 * Created by hadoop on 8/10/17.
 */
class HashMapCustom<K,V> {
    private Entry<K,V> [] table;
    int capacity = 4;
    private static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        public Entry(K key,V value,Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public HashMapCustom(){
        table = new Entry[4];

    }
    public void put(K newkey,V newvalue){
        if(newkey == null){
            return;
        }
        int hash= hash(newkey);
        Entry<K,V> newEntry = new Entry<K,V>(newkey,newvalue,null);
        if(table[hash] == null){
            table[hash] = newEntry;
        }
        else {
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];
            while (current!=null){
            // also consider case where key is equal
                if(current.key.equals(newkey)){
                    if(previous == null){
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    }
                    else {
                        previous.next = newEntry;
                        newEntry.next = current.next;
                        return;
                    }
                }
                previous =current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }
    public V getValue(K key){
        int hash = hash(key);
        Entry<K,V> current = table[hash];
        while (current!=null){
            if(current.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public boolean removeKey(K key){
        int hash = hash(key);
        Entry<K,V> current = table[hash];
        Entry<K,V> previous = null;
        while (current!=null){
            if(current.equals(key)){
                if(previous == null){
                    table[hash].next = current.next;
                }
                else {
                    previous.next = current.next;
                }
                return true;
            }
            previous = null;
            current = current.next;
        }
        return false;
    }

    private int hash(K newkey) {
        return (newkey.hashCode())%4;
    }
}