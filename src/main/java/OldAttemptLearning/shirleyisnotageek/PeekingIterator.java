package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/*
The idea comes from Google's Guava library (it's a quite good library). If the iterator is initialized by the list, we can just use a pointer to get the next element. However, the question asks us to initialize with the iterator. Based on the hint (and Guava), we can use a pointer to track the peeked element. When peek() is called, the iterator still calls next() method to get us the element, but we use a pointer peekedElement to record this element, next time if we call next(), we can just return the element. Note we need another boolean variable isPeeked because peekedElement can be initialized with anything, even one of the elements in the iterator, so we need the flag to distinguish.
 */
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    private boolean isPeeked;
    private int peekedElement;
     
 public PeekingIterator(Iterator<Integer> iterator) {
     if (iterator == null)
         throw new NullPointerException();
     this.iterator = iterator;
     isPeeked = false;
     peekedElement = -1;
 }
 
    // Returns the next element in the iteration without advancing the iterator.
 public Integer peek() {
        if (isPeeked)
            return peekedElement;
        else {
            if (!hasNext())
                return -1;
            peekedElement = iterator.next();
            isPeeked = true;
            return peekedElement;
        }
 }
 
 // hasNext() and next() should behave the same as in the Iterator interface.
 // Override them if needed.
 @Override
 public Integer next() {
     if (!isPeeked && hasNext())
         return iterator.next();
     int toReturn = peekedElement;
     peekedElement = -1;
     isPeeked = false;
     return toReturn;
 }
 
 @Override
 public boolean hasNext() {
     return isPeeked || iterator.hasNext();
 }
}