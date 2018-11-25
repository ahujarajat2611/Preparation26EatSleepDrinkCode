package BasicAlgorithms.HashTable;

/**
 * Created by hadoop on 16/12/17.
 */
public class HashMapCustom {
    private class HashMap<K,V>{
        Entry[] entries;
        int size;
        HashMap(){
            this.size = 10;
            entries = new Entry[10];
        }

        private class Entry<K,V>{
            K key;
            V value;
            Entry<K,V> next;
            public Entry(K key, V value) {
                super();
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }
        public void insert(K key,V value){
            int hash = hashCode(key);
            Entry<K,V> entry = new Entry<>(key,value);
            if(entries[hash] == null){
                entries[hash] = entry;
            }
            else {
                // assumtion no dublicate entries will get inserted
                entry.next = entries[hash].next;
                entries[hash]= entry;
            }
        }
        public V get(K key) {
            int hash = hashCode(key);
            if (entries[hash] == null) {
                return null;
            }
            Entry<K, V> cur = entries[hash];
            while (cur != null) {
                if (cur.key == key)
                    return cur.value;
                cur = cur.next;
            }
            return null;
        }

        int hashCode(K key){
            return key.hashCode()%size;
        }
    }
}
