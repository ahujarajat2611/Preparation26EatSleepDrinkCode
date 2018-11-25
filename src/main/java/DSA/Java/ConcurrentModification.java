package DSA.Java;

/**
 * Created by hadoop on 12/2/18.
 */
public class ConcurrentModification {
    // HOw to avoid concurrent modificaiton exception
    /*
    for(int i = 0; i<myList.size(); i++){
	System.out.println(myList.get(i));
	if(myList.get(i).equals("3")){
		myList.remove(i);
		i--;
		myList.add("6");
	}
        }
     */

    // how to avoid concurrent modification exception

    /*
    List<String> list = new ArrayList<String>();
list.add("A");
list.add("B");
list.add("C");

for (String s : list) {
    if (s.equals("B")) {
        list.remove(s);
    }
}
Running the code actually will result in the following exception:
java-util-concurrentModificationException

Solution 1

Iterator can be used to solve this problem. Iterators allow the caller to remove elements from the underlying collection during the iteration.

Iterator<String> iter = list.iterator();
while(iter.hasNext()){
    String str = iter.next();
    if( str.equals("B")){
        iter.remove();
    }
}
Solution 2

Instead of ArrayList, CopyOnWriteArrayList can be used to solve the problem. CopyOnWriteArrayList is a thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.

List<String> list = new CopyOnWriteArrayList<String>();
list.add("A");
list.add("B");
list.add("C");

for (String s : list) {
    if (s.equals("B")) {
        list.remove(s);
    }
}
This is the same for other data structures, such as HashSet, LinkedList, etc.
     */
    /*
    1. Concurrent modification exception occurs, when you are modifying an object such as a collection, which is not permissible.
2. This exception may also arise, when one thread is iterating over a collection, while another thread is trying to modify the same collection.
3. Note that this exception does not always indicate that an object has been concurrently modified by a different thread.  For example, In a program, when iterating over a set, this exception arises if you directly remove elements from set using set.remove(anObject), instead of iterator.remove().

Program which throws Concurrent Modification Exception :

Import java.util.Set;
import java.util.HashSet;

public class CmeExample {
 Public static void main(String args[]) {
  Set aSet = new HashSet();
  aSet.add(“ABC”);
  aSet.add(“DEF”);
  aSet.add(“GHI”);
  aSet.add(“JKL”);

  for(String value : aSet) {
   if(value.equals(“DEF”) {
    aSet.remove(“DEF”);
   }
  }
 }
}

4. If you run the above program, you'll get the below exception
  Exception in thread "main" java.util.ConcurrentModificationException
        at java.util.HashMap$HashIterator.nextEntry(HashMap.java:787)
        at java.util.HashMap$KeyIterator.next(HashMap.java:823)
        at CmeExample.main(CmeExample.java:12)

5. In the above program, we are removing an element from the Set "aSet", using it's method remove(anObj), this resulted the concurrent modification exception.
6. The Solution to this is

Solution :

1. Use iterator.remove() method instead of collection’s remove(anObject) method.
2. For this, always use iterator instead of enhanced for loop to iterate over a collection, because even though enhanced for loop, uses a iterator, but you’ll not have access to it’s remove metod, so always use the corresponding collection’s iterator, by calling it’s iterator() method.
3. Let’s see the same code with some changes to resolve this issue.
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class CmeExample {
   public static void main(String args[]) {
 Set aSet = new HashSet();
 aSet.add("ABC");
 aSet.add("DEF");
 aSet.add("GHI");
 aSet.add("JKL");

 /*for(String value : aSet) {
 if(value.equals("DEF") ){
 aSet.remove("DEF");
 }*/

//    Iterator setIterator = aSet.iterator();
//    String setItem = "";
// while(setIterator.hasNext()) {
//        setItem = setIterator.next();
//        if(setItem.equals("DEF")) {
//            setIterator.remove();
//            System.out.println(setItem + " removed");
//        }
//    }
//}
//}
//        4. If you run the above program, now you won't get concurrent modification exception.
//     */
}
