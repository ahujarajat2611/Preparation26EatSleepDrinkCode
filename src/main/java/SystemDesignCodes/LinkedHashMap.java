//package SystemDesignCodes;
//
///**
// * Created by hadoop on 8/10/17.
// */
//public class LinkedHashMap<K,V> {
//    private Entry<K,V> []table;
//    int capacity = 4;
//    class Entry<K,V>{
//        K key;
//        V value;
//        Entry<K,V> next;
//        Entry<K,V> after;
//        Entry<K,V> before;
//
//        public Entry(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//    Entry<K,V>  head;
//    Entry<K,V> tail;
//    LinkedHashMap(){
//        table = new Entry[capacity];
//    }
//    int hash(K key){
//        return (key.hashCode()%capacity);
//    }
//    public void put(K key, V value){
//
//        if(key == null){
//            return;
//        }
//        int hash = hash(key);
//        Entry<K,V> newEntry = new Entry<>(key,value);
//        mainTainOrderAfterInsert(newEntry);
//
//    }
//
//    private void mainTainOrderAfterInsert(Entry<K, V> newEntry) {
//        if(head == null){
//            head = newEntry;
//            tail = newEntry;
//            return;
//        }
//        else if(tail.key.equals(newEntry.key)){
//            deleteLast();
//            insertAtLast(newEntry);
//        }
//        else if(head.key.equals(newEntry.key)){
//            deleteFirst();
//            insertFirst(newEntry);
//        }
//        else {
//            Entry<K,V> deleteEntry = deleteEntrySpecfic(newEntry);
//            if(deleteEntry == null){
//                insertLast(newEntry);
//            }
//            else {
//                deleteAfter(deleteEntry,newEntry);
//            }
//        }
//    }
//
//    private void deleteLast() {
//        if(head == tail){
//            tail= null;
//            head = null;
//        }
//        if(tail !=null){
//            tail.before.after = tail.after;
//            //tail.after.before = tail.before;
//            tail = tail.before;
//        }
//        // tail = tail.before  ;
//        // tail.after = null;
//    }
//    private void deleteFirst(){
//        if(head == tail){
//            tail = null;
//            head = null;
//        }
//        if(head!=null){
//            head = head.after;
//            head.before = null;
//        }
//    }
//
//}

///*
//package com.ankit;
//
// /**
// * @author AnkitMittal, JavaMadeSoEasy.com
// * Copyright (c), AnkitMittal . All Contents are copyrighted and must not be
// * reproduced in any form.
// * This class provides custom implementation of LinkedHashMap(without using java api's)-
// * which allows us to store data in key-value pair form.
// * It maintains insertion order, uses DoublyLinkedList for doing so.
// * If key which already exists is added again, its value is overridden but
// * insertion order does not change,
// * BUT, if key-value pair is removed and value is again added than insertion order
// * changes(which is quite natural behavior).
// * @param <K>
// * @param <V>
// */
//class LinkedHashMapCustom<K, V> {
//
//    private Entry<K,V>[] table;   //Array of Entry.
//    private int capacity= 4;  //Initial capacity of HashMap
//    private Entry<K,V> header; //head of the doubly linked list.
//    private Entry<K,V> last; //last of the doubly linked list.
//
//    /*
//     * before and after are used for maintaining insertion order.
//     */
//    static class Entry<K, V> {
//        K key;
//        V value;
//        Entry<K,V> next;
//        Entry<K,V> before,after;
//
//        public Entry(K key, V value, Entry<K,V> next){
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//    }
//
//
//    @SuppressWarnings("unchecked")
//    public LinkedHashMapCustom(){
//        table = new Entry[capacity];
//    }
//
//
//
//    /**
//     * Method allows you put key-value pair in LinkedHashMapCustom.
//     * If the map already contains a mapping for the key, the old value is replaced.
//     * Note: method does not allows you to put null key thought it allows null values.
//     * Implementation allows you to put custom objects as a key as well.
//     * Key Features: implementation provides you with following features:-
//     *     >provide complete functionality how to override equals method.
//     *  >provide complete functionality how to override hashCode method.
//     * @param newKey
//     * @param data
//     */
//    public void put(K newKey, V data){
//        if(newKey==null)
//            return;    //does not allow to store null.
//
//        int hash=hash(newKey);
//
//        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
//        maintainOrderAfterInsert(newEntry);
//        if(table[hash] == null){
//            table[hash] = newEntry;
//        }else{
//            Entry<K,V> previous = null;
//            Entry<K,V> current = table[hash];
//            while(current != null){ //we have reached last entry of bucket.
//                if(current.key.equals(newKey)){
//                    if(previous==null){  //node has to be insert on first of bucket.
//                        newEntry.next=current.next;
//                        table[hash]=newEntry;
//                        return;
//                    }
//                    else{
//                        newEntry.next=current.next;
//                        previous.next=newEntry;
//                        return;
//                    }
//                }
//                previous=current;
//                current = current.next;
//            }
//            previous.next = newEntry;
//        }
//    }
//
//
//    /**
//     * below method helps us in ensuring insertion order of LinkedHashMapCustom
//     * after new key-value pair is added.
//     */
//    private void maintainOrderAfterInsert(Entry<K, V> newEntry) {
//
//        if(header==null){
//            header=newEntry;
//            last=newEntry;
//            return;
//        }
//
//        if(header.key.equals(newEntry.key)){
//            deleteFirst();
//            insertFirst(newEntry);
//            return;
//        }
//
//        if(last.key.equals(newEntry.key)){
//            deleteLast();
//            insertLast(newEntry);
//            return;
//        }
//
//        Entry<K, V> beforeDeleteEntry=    deleteSpecificEntry(newEntry);
//        if(beforeDeleteEntry==null){
//            insertLast(newEntry);
//        }
//        else{
//            insertAfter(beforeDeleteEntry,newEntry);
//        }
//
//
//    }
//
//    /**
//     * below method helps us in ensuring insertion order of LinkedHashMapCustom,
//     * after deletion of key-value pair.
//     */
//    private void maintainOrderAfterDeletion(Entry<K, V> deleteEntry) {
//
//        if(header.key.equals(deleteEntry.key)){
//            deleteFirst();
//            return;
//        }
//
//        if(last.key.equals(deleteEntry.key)){
//            deleteLast();
//            return;
//        }
//
//        deleteSpecificEntry(deleteEntry);
//
//    }
//
//    /**
//     * returns entry after which new entry must be added.
//     */
//    private void insertAfter(Entry<K, V> beforeDeleteEntry, Entry<K, V> newEntry) {
//        Entry<K, V> current=header;
//        while(current!=beforeDeleteEntry){
//            current=current.after;  //move to next node.
//        }
//
//        newEntry.after=beforeDeleteEntry.after;
//        beforeDeleteEntry.after.before=newEntry;
//        newEntry.before=beforeDeleteEntry;
//        beforeDeleteEntry.after=newEntry;
//
//    }
//
//
//    /**
//     * deletes entry from first.
//     */
//    private void deleteFirst(){
//
//        if(header==last){ //only one entry found.
//            header=last=null;
//            return;
//        }
//        header=header.after;
//        header.before=null;
//
//    }
//
//    /**
//     * inserts entry at first.
//     */
//    private void insertFirst(Entry<K, V> newEntry){
//
//        if(header==null){ //no entry found
//            header=newEntry;
//            last=newEntry;
//            return;
//        }
//
//        newEntry.after=header;
//        header.before=newEntry;
//        header=newEntry;
//
//    }
//
//    /**
//     * inserts entry at last.
//     */
//    private void insertLast(Entry<K, V> newEntry){
//
//        if(header==null){
//            header=newEntry;
//            last=newEntry;
//            return;
//        }
//        last.after=newEntry;
//        newEntry.before=last;
//        last=newEntry;
//
//    }
//
//    /**
//     * deletes entry from last.
//     */
//    private void deleteLast(){
//
//        if(header==last){
//            header=last=null;
//            return;
//        }
//
//        last=last.before;
//        last.after=null;
//    }
//
//
//    /**
//     * deletes specific entry and returns before entry.
//     */
//    private Entry<K, V> deleteSpecificEntry(Entry<K, V> newEntry){
//
//        Entry<K, V> current=header;
//        while(!current.key.equals(newEntry.key)){
//            if(current.after==null){   //entry not found
//                return null;
//            }
//            current=current.after;  //move to next node.
//        }
//
//        Entry<K, V> beforeDeleteEntry=current.before;
//        current.before.after=current.after;
//        current.after.before=current.before;  //entry deleted
//        return beforeDeleteEntry;
//    }
//
//
//    /**
//     * Method returns value corresponding to key.
//     * @param key
//     */
//    public V get(K key){
//        int hash = hash(key);
//        if(table[hash] == null){
//            return null;
//        }else{
//            Entry<K,V> temp = table[hash];
//            while(temp!= null){
//                if(temp.key.equals(key))
//                    return temp.value;
//                temp = temp.next; //return value corresponding to key.
//            }
//            return null;   //returns null if key is not found.
//        }
//    }
//
//
//    /**
//     * Method removes key-value pair from HashMapCustom.
//     * @param key
//     */
//    public boolean remove(K deleteKey){
//
//        int hash=hash(deleteKey);
//
//        if(table[hash] == null){
//            return false;
//        }else{
//            Entry<K,V> previous = null;
//            Entry<K,V> current = table[hash];
//
//            while(current != null){ //we have reached last entry node of bucket.
//                if(current.key.equals(deleteKey)){
//                    maintainOrderAfterDeletion(current);
//                    if(previous==null){  //delete first entry node.
//                        table[hash]=table[hash].next;
//                        return true;
//                    }
//                    else{
//                        previous.next=current.next;
//                        return true;
//                    }
//                }
//                previous=current;
//                current = current.next;
//            }
//            return false;
//        }
//
//    }
//
//
//    /**
//     * Method displays all key-value pairs present in HashMapCustom.,
//     * insertion order is not guaranteed, for maintaining insertion order
//     * refer linkedHashMapCustom.
//     * @param key
//     */
//    public void display(){
//
//        Entry<K, V> currentEntry=header;
//        while(currentEntry!=null){
//            System.out.print("{"+currentEntry.key+"="+currentEntry.value+"}" +" ");
//            currentEntry=currentEntry.after;
//        }
//
//    }
//    /**
//     * Method implements hashing functionality, which helps in finding the appropriate
//     * bucket location to store our data.
//     * This is very important method, as performance of HashMapCustom is very much
//     * dependent on this method's implementation.
//     * @param key
//     */
//    private int hash(K key){
//        return Math.abs(key.hashCode()) % capacity;
//    }
//
//}
//
//
///** Copyright (c), AnkitMittal  JavaMadeSoEasy.com */
///**
// * Main class- to test HashMap functionality.
// */
//public class LinkedHashMapCustomApp {
//
//    public static void main(String[] args) {
//        LinkedHashMapCustom<Integer, Integer> linkedHashMapCustom = new LinkedHashMapCustom<Integer, Integer>();
//
//        linkedHashMapCustom.put(21, 12);
//        linkedHashMapCustom.put(25, 121);
//        linkedHashMapCustom.put(30, 151);
//        linkedHashMapCustom.put(33, 15);
//        linkedHashMapCustom.put(35, 89);
//
//        System.out.println("Display values corresponding to keys>");
//        System.out.println("value corresponding to key 21="
//                + linkedHashMapCustom.get(21));
//        System.out.println("value corresponding to key 51="
//                + linkedHashMapCustom.get(51));
//
//        System.out.print("Displaying : ");
//        linkedHashMapCustom.display();
//
//        System.out.println("\n\nvalue corresponding to key 21 removed: "
//                + linkedHashMapCustom.remove(21));
//        System.out.println("value corresponding to key 22 removed: "
//                + linkedHashMapCustom.remove(22));
//
//        System.out.print("Displaying : ");
//        linkedHashMapCustom.display();
//
//    }
//}
// */
