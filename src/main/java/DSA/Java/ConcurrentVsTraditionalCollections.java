package DSA.Java;

/**
 * Created by hadoop on 12/2/18.
 */
public class ConcurrentVsTraditionalCollections {
}
/*
Difference between Traditional Collections and Concurrent Collections in java
2
We all know about about Traditional Collections ( i.e. List, Set, Queue and its implemented Classes) and Concurrent Collection (i.e. ConcurrentMap interface, ConcurrentHashMap class, CopyOnWriteArrayList class etc). In these two Collections, there are few differences like:

Most of the Classes which are present in Traditional Collections (i.e ArrayList, LinkedList, HashMap etc) are non-synchronized in nature and Hence there is no thread-safety. But All the classes present in Concurrent Collections are synchronized in nature. Therefore In Concurrent classes, we dont have to take care about Thread-safety.
While Traditional Collections also have some classes (like Vector, Stack etc) which are synchronized in nature and Traditional Collections also have SynchronizedSet, SynchronizedList, SynchronizedMap methods through which we can get Synchronized version of non-synchronized objects. But these above Synchronized classes are not good in terms of performance because of wide-locking mechanism .Whereas Concurrent Collections classes performance are relatively high than Traditional Collections classes.
In the Traditional Collections, if a thread is iterating a Collection object and if another thread try to add new element in that iterating object simultaneously then we will get RuntimeException ConcurrentModificationException. Whereas In the above case, we will not get any Runtime Exception if we are Working with Concurrent Collections Classes.
Traditional Collections classes is good choice if we are not dealing with thread in our application. whereas because of the Concurrent/Synchronized Collection we can use multiple Threads which are dealing with Collections Object. Therefore Concurrent Collections are best choice if we are dealing Multiple Threads in our application.
 */

/*
Synchronized vs Concurrent Collections
Though both Synchronized and Concurrent Collection classes provide thread-safety, the differences between them comes  in performance, scalability and how they achieve thread-safety. Synchronized collections like synchronized HashMap, Hashtable, HashSet, Vector, and synchronized ArrayList are much slower than their concurrent counterparts e.g. ConcurrentHashMap, CopyOnWriteArrayList, and CopyOnWriteHashSet. Main reason for this slowness is locking; synchronized collections locks the whole collection e.g. whole Map or List while concurrent collection never locks the whole Map or List. They achieve thread safety by using advanced and sophisticated techniques like lock stripping. For example, the ConcurrentHashMap divides the whole map into several segments and locks only the relevant segments, which allows multiple threads to access other segments of same ConcurrentHashMap without locking.

Read more: http://javarevisited.blogspot.com/2016/05/what-is-difference-between-synchronized.html#ixzz56pO46APM



 */

// very imp
//https://www.quora.com/What-is-the-difference-between-synchronize-and-concurrent-collection-in-Java
