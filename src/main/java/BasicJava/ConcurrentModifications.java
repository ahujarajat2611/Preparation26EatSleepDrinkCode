//package BasicJava;
//
///**
// * Created by hadoop on 19/12/17.
// */
//public class ConcurrentModifications {
//}
//
//
///*
//Iterator fail-fast property checks for any modification in the structure
// of the underlying collection everytime we try to get the next element.
// If there are any modifications found,
// it throws ConcurrentModificationException.
// All the implementations of Iterator in Collection classes are fail-fast by design
// except the concurrent collection classes like ConcurrentHashMap
// and CopyOnWriteArrayList.
// */
///*
//public static void main(String[] args) {
//
//        List<String> list = new ArrayList<>();
//        Arrays.stream("hello how are you".split(" ")).forEach(s -> list.add(s));
//
//        Iterator<String> it = list.iterator();
//        ListIterator<String> lit = list.listIterator();
//
//        while (it.hasNext()) {
//            String s = it.next();
//            if (s.startsWith("a")) {
//                it.remove();
//            } else {
//                System.out.println(s);
//            }
//        }
//
//        System.out.println(list);
//
//        // {here}
//
//        while (lit.hasNext()) {
//            String s = lit.next();
//            if (s.startsWith("a")) {
//                lit.set("1111" + s);
//            } else {
//                System.out.println(s);
//            }
//        }
//
//        System.out.println(list);
//}
//
//
//SOlutoin \
//
//
//.*
//
//public static void main(String[] args) {
//
//    List<String> list = new ArrayList<>();
//    Arrays.stream("hello how are you".split(" ")).forEach(s -> list.add(s));
//
//    Iterator<String> it = list.iterator();
//
//    while (it.hasNext()) {
//        String s = it.next();
//        if (s.startsWith("a")) {
//            it.remove();
//        } else {
//            System.out.println(s);
//        }
//    }
//
//    System.out.println(list);
//
//    ListIterator<String> lit = list.listIterator();
//
//    while (lit.hasNext()) {
//        String s = lit.next();
//        if (s.startsWith("a")) {
//            lit.set("1111" + s);
//        } else {
//            System.out.println(s);
//        }
//    }
//
//    System.out.println(list);
//}
///*
//
//Didnt work
//LinkedList<String> linkedList = new LinkedList<String>();
//ListIterator listIterator = linkedList.listIterator();
//linkedList.add("aa");
//linkedList.add("bb");
//
//
//
//
//his didn't work:
//
//LinkedList<String> linkedList = new LinkedList<String>();
//ListIterator listIterator = linkedList.listIterator();
//linkedList.add("aa");
//linkedList.add("bb");
//This worked:
//
//LinkedList<String> linkedList = new LinkedList<String>();
//linkedList.add("aa");
//linkedList.add("bb");
//ListIterator listIterator = linkedList.listIterator();
//
//
//
//to understand this lets look at source of HashMap implementation:
//
//public class HashMap<K, V> extends AbstractMap<K, V> implements Cloneable, Serializable{
//which contains HashIterator as below:
//
//private abstract class HashIterator {
//    ...
//    int expectedModCount = modCount;
//    ...
//
//    HashMapEntry<K, V> nextEntry() {
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
//        ....
//        }
//every time you create a iterator:
//
//a counter expectedModCount is created and is set to value of modCount as entry checkpoint
//modCount is incremented in cases of use put/get (add/remove)
//nextEntry method of iterator is checking this value with current modCount if they are different concurrent modification exception is throw
//to avoid this u can:
//
//convert map to an array (not recommended for large maps)
//use concurrency map or list classes (CopyOnWriteArrayList / ConcurrentMap)
//lock map (this approach removes benefits of multithreading)
//this will allow you to iterate and add or remove elements at the same time without rising an exception
//
//
//https://stackoverflow.com/questions/1496180/concurrent-modification-exception
//
//
///*
//
//
// */
///*
// */
// */