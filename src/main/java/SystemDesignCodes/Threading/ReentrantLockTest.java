package SystemDesignCodes.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class ReentrantLockTest {
    public static void main(String[] args) {
 
        Lock lock=new ReentrantLock();
        MyRunnable1 myRunnable=new MyRunnable1(lock);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();
        
    }
}
 
 


class MyRunnable1 implements Runnable{
    
    Lock lock;
    public MyRunnable1(Lock lock) {
        this.lock=lock;
    }
    
    public void run(){
        
                  System.out.println(Thread.currentThread().getName()
               +" is Waiting to acquire lock");
 
        
        lock.lock();
        System.out.println();
        System.out.println(Thread.currentThread().getName()
                     +" has called lock(), lockHoldCount=1 ");
        
        
        lock.lock();         
        System.out.println(Thread.currentThread().getName()
                     +" has called lock(), lockHoldCount=2 ");
        
        System.out.println(Thread.currentThread().getName()
                  +" is about to call unlock(), lockHoldCount will become 1 ");
           lock.unlock();    
        
        System.out.println(Thread.currentThread().getName()
                  +" is about to call unlock(), lockHoldCount will become 0 ");
           lock.unlock();    
        
        
        
    }
}
 
/*OUTPUT
 
Thread-2 is Waiting to acquire lock
Thread-1 is Waiting to acquire lock
 
Thread-2 has called lock(), lockHoldCount=1
Thread-2 has called lock(), lockHoldCount=2
Thread-2 is about to call unlock(), lockHoldCount will become 1
Thread-2 is about to call unlock(), lockHoldCount will become 0
 
Thread-1 has called lock(), lockHoldCount=1
Thread-1 has called lock(), lockHoldCount=2
Thread-1 is about to call unlock(), lockHoldCount will become 1
Thread-1 is about to call unlock(), lockHoldCount will become 0
 
*/