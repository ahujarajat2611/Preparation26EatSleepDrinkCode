package AwangDevLintCode;

import java.util.Random;

/**
 * Created by hadoop on 4/2/18.
 */
import java.io.*;
import java.util.*;

class CHashMap<K, V> {
        public int capacity;
        public int count;
        public Entry<K,V>[] table;
        // table storing direcct pointers to ENtry nodessssssssssss
// array of entryes



        public class Entry<K, V> {
            public V value;
            public K key;
            public Entry<K,V> next;

            public Entry(K key, V value, Entry<K,V> next) {
                this.value = value;
                this.key = key;
                this.next = next;
            }
        }


        public CHashMap() {
            this.capacity = 16;
            this.table = new Entry[this.capacity];
            this.count = 0;
        }

        public CHashMap(int capacity) {
            this.capacity = capacity;
            this.table = new Entry[this.capacity];
            this.count = 0;
        }

        public V get(K key) {
            if (key == null) {
                return null;
            }
            int hashedKey = hashFunction(key);
            if (table[hashedKey] != null) {
                Entry<K,V> node = table[hashedKey];
                while (node != null) {
                    if (node.key.equals(key)) {
                        return node.value;
                    }
                    node = node.next;
                }
            }
            return null;
        }


        // we need to check if that key exists or not
    // if exists then just update the value on the same node or change pointers as per newly created node

        public void put(K key, V value) {
            if (key == null) {
                return;
            }
            this.count++;
            Entry<K,V> entry = new Entry<K,V>(key, value, null);
            int hashedKey = hashFunction(key);
            if (table[hashedKey] == null) {
                table[hashedKey] = entry;
            } else {
                // For sure when we are considering deleting entries we need two cases
                // firs to check entry at top
                // then node.next
                Entry<K,V> node = table[hashedKey];
                if (node.key.equals(key)) {
                    table[hashedKey] = entry;
                    entry.next = node.next;
                    return;
                }
                while (node.next != null) {
                    if (node.next.key.equals(key)) {
                        Entry<K,V> temp = node.next;
                        node.next = entry;
                        entry.next = temp.next;
                        // returing since we found value and updated pointers
                        return;
                    }
                    node = node.next;
                }
                node.next = entry;
            }
        }


    public void Myput(K key, V value) {
        if (key == null) {
            return;
        }
        this.count++;
        int hash = hashFunction(key);
        Entry<K,V> newEntry = new Entry<>(key,value,null);
        if(table[hash] == null){
            table[hash] = newEntry;
        }
        else {
            // travers to make sure this value doe snot exists
            Entry<K,V> node = table[hash];
            Entry<K,V> prev = null;
            while (node!=null){
                if(node.key.equals(key)){
                    if(prev == null){
                        Entry<K,V> next = node.next;
                        table[hash] = newEntry;
                        newEntry.next = next;
                        return;
                    }
                    else {
                        prev.next = newEntry;
                        newEntry.next = node.next;
                        return;
                    }
                }
                prev = node;
                node = node.next;
            }
            // we are sure we did not find lets insert int

            Entry<K,V> next = table[hash];
            table[hash] = newEntry;
            newEntry.next = next;
            return;
        }
    }

        public int hashFunction (K key) {
            return Math.abs(key.hashCode()) % this.capacity;
        }

        public void display() {
            for (int i = 0; i < table.length; i++) {
                Entry<K,V> node = table[i];
                StringBuffer sb = new StringBuffer();
                while (node != null) {
                    sb.append("[key: " + node.key + ", value: " + node.value + "], ");
                    node = node.next;
                }
                if (sb.length() != 0)
                    System.out.println(sb.toString());
            }
            System.out.println();
        }

        /*
            If no collision, uniform random access is easy.

            With collision, need to figure our how to access element on the linkedlist with O(1), but it's unlikely.

        */
//        public V getRandom() {
//            Random rd = new Random();
//            int hashedKey = hashFunction(rd.nextInt(this.capacity));
//            return table[hashedKey];
//        }






        public static void main(String[] args) {
            CHashMap<Character, String> map = new CHashMap<Character, String>(2);

            System.out.println("TEST SET------");
            map.Myput('a', "1st string");
            map.Myput('b', "2nd string!");
            map.display();
            map.Myput('a', "wowo change");
            map.display();


            System.out.println("TEST PUT------");
            System.out.println(map.get('a'));
            System.out.println(map.get('c'));
            map.put('c', "okay test c");
            System.out.println(map.get('c'));
            map.display();

            System.out.println("TEST COLLISION------");
            map.put('d', "test d");
            map.put('e', "test E");
            map.display();
            //test getrandom

        }}
