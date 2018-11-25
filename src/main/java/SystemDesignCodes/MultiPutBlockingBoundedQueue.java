package SystemDesignCodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement following interface so that multi-put is atomic.
 * Expect multiple producers and consumers inserting to and extracting from this queue implementation.
 *
 * @author Baofeng Xue at 2016/3/22 21:39.
 *         <p>
 *         threadSafe bounded blocking queue implementation. Expected to be used in a
 *         Producer->Consumer pattern
 */
public interface MultiPutBlockingBoundedQueue<E> {

    /**
     * Sets the capacity of the buffer. Can be called only once. If called more
     * than once or if the passed capacity is <= 0, throw an exception.
     */
    public void init(int capacity) throws Exception;

    /**
     * Get the next item from the queue throws Exception if not initialized
     */
    public E get() throws Exception;

    /**
     * Put the item to the tail of the queue. throws Exception if not
     * initialized
     */
    public void put(E obj) throws Exception;

    /**
     * Put the list of items in an atomic manner. The list can be more than the
     * capacity throws Exception if not initialized
     */
    public void multiput(List<E> objs) throws Exception;

}

class Impl<E> implements MultiPutBlockingBoundedQueue<E> {
    boolean inited;

    List<E> queue;
    Lock lock;
    Condition canPut;
    Condition canGet;
    private int capacity;

    public static void main(String[] args) throws Exception {
        Impl<Integer> impl = new Impl<>();
        impl.init(10);
        Random random = new Random();

        ExecutorService putService = Executors.newFixedThreadPool(10);
        int i = 0;


        while (i < 100) {
            final int finalI = i;
            putService.submit(() -> {
                try {
                    if (finalI % 20 == 0) {
                        ArrayList<Integer> objs = new ArrayList<>();
                        objs.add(random.nextInt());
                        objs.add(random.nextInt());
                        impl.multiput(objs);
                    }

                    impl.get();
                    impl.put(random.nextInt());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            i++;
        }

        putService.shutdown();
        putService.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Override
    public void init(int capacity) throws Exception {
        if (inited || capacity <= 0) throw new RuntimeException();
        lock = new ReentrantLock();
        canPut = lock.newCondition();
        canGet = lock.newCondition();
        queue = new LinkedList<>();
        this.capacity = capacity;
        inited = true;
    }

    @Override
    public E get() throws Exception {
        if (queue == null) throw new RuntimeException();
        lock.lock();
        while (queue.size() == 0) {
            canGet.await();
        }
        E top = queue.get(0);
        queue.remove(0);
        System.out.println("get:" + top + " size:" + queue.size());
        canPut.signal();
        lock.unlock();
        return top;
    }

    @Override
    public void put(E obj) throws Exception {
        if (queue == null) throw new RuntimeException();
        lock.lock();
        while (queue.size() == capacity) {
            canPut.await();
        }
        queue.add(obj);
        System.out.println("put:" + obj + " size:" + queue.size());
        canGet.signal();
        lock.unlock();
    }

    @Override
    public void multiput(List<E> objs) throws Exception {
        if (queue == null) throw new RuntimeException();
        for (E obj : objs) {
            put(obj);
        }
    }
}