package SystemDesignCodes.Threading.ThreadPool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 8/10/17.
 */


interface BlockingQueue<E>{
    void put(E e);
    E get();
    int size();
}
class LinkedBlockingQueue<E> implements BlockingQueue<E>{
    List<E> list;
    int maxsize;
    LinkedBlockingQueue(int maxsize){
        list = new LinkedList<E>();
        this.maxsize = maxsize;
    }
    @Override
    public synchronized void put(E o) {
        while (list.size() == maxsize){
            try {
                wait();
            }
            catch (Exception e){

            }
        }
        list.add(o);
        notifyAll();
    }

    @Override
    public synchronized E get() {
        while (list.size() == 0){
            try {
                wait();
            }
            catch (Exception e){

            }
        }
        E item = list.get(0);
        list.remove(0);
        this.notifyAll();
        return item;
    }

    @Override
    public int size() {
        return list.size();
    }
}
public class ThreadPool{
    private LinkedBlockingQueue<Runnable> tasks ;

    private volatile boolean  poolShutDown = false;
    public ThreadPool(int sizeofpool){
        tasks = new LinkedBlockingQueue<>(sizeofpool);
        for(int i=0;i<sizeofpool;i++){
            ThreadPoolsThread threadPoolsThread = new ThreadPoolsThread(tasks,this);
            threadPoolsThread.start();
        }
    }
    public synchronized void execute(Runnable task){
        tasks.put(task);
    }

    public boolean isPoolShutDown() {
        return poolShutDown;
    }
    public static void main(String args[]){
        ThreadPool threadPool = new ThreadPool(3);
        Task task = new Task();
        threadPool.execute(task);
    }
}
class ThreadPoolsThread extends Thread{
    LinkedBlockingQueue<Runnable> tasks;
    ThreadPool threadPool;

    public ThreadPoolsThread(LinkedBlockingQueue<Runnable> tasks, ThreadPool threadPool) {
        this.tasks = tasks;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        while (true){
            Runnable task = tasks.get();
            task.run();
            if(tasks.size() == 0 && threadPool.isPoolShutDown()){
                break;
            }
        }
    }
}


class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Lets Do it");
    }
}


//http://www.javamadesoeasy.com/2015/03/implementing-threadpool-using-custom.html