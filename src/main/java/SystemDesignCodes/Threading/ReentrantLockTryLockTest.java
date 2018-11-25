package SystemDesignCodes.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class ReentrantLockTryLockTest {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        MyRunnable myRunnable = new MyRunnable(lock);
        new Thread(myRunnable, "Thread-1").start();
        new Thread(myRunnable, "Thread-2").start();

    }
}

class MyRunnable implements Runnable {

        Lock lock;

        public MyRunnable(Lock lock) {
            this.lock = lock;
        }

        public void run() {

            System.out.println(Thread.currentThread().getName()
                    + " is Waiting to acquire lock");

            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName()
                        + " has acquired lock.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(Thread.currentThread().getName()
                        + " didn't got lock.");

            }

        }
    }
/*OUTPUT
 
Thread-1 is Waiting to acquire lock
Thread-2 is Waiting to acquire lock
Thread-1 has acquired lock.
Thread-2 didn't got lock.
 
*/