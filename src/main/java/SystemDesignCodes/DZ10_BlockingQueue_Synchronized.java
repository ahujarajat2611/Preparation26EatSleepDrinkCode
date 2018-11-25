package SystemDesignCodes;


import java.util.LinkedList;

/**
 * Created_By: stefanie
 * Date: 14-10-23
 * Time: 下午7:11
 */
import java.util.*;
public class DZ10_BlockingQueue_Synchronized<T>  {
    Boolean pushFlag = true;
    Boolean popFlag = true;
    Integer N;
    Queue<T> queue = new LinkedList<>();
    public DZ10_BlockingQueue_Synchronized(int n) {
        N = n;
    }

    public void push(T item) {
        try {
            synchronized (pushFlag) {
                while(queue.size() >= N){
                    System.out.println("Queue is full");
                    pushFlag.wait();
                }
                queue.add(item);
                popFlag.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public T pop() {
        try {
            synchronized (popFlag){
                while(queue.size() <= 0) {
                    System.out.println("Queue is empty");
                    popFlag.wait();
                }
                pushFlag.notifyAll();
                return queue.poll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int size(){
        return queue.size();
    }
}
