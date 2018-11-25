package SystemDesignCodes.Threading.ConcurrencyPractical;

/**
 * Created by hadoop on 27/10/17.
 */
import java.util.*;
class Producer implements Runnable {
    List<Integer> taskQueue;
    int size ;
    Producer(int size,List<Integer>taskQueue){
        this.size = size;
        this.taskQueue = taskQueue;
    }
    @Override
    public void run() {
        int counter =0;
        while (true){
            produce(counter++);
        }
    }

    private void produce(int i) {
        synchronized (taskQueue){
            while (taskQueue.size() ==size){
                try {
                    taskQueue.wait();
                }
                catch (Exception e){

                }
                // perform task
                taskQueue.add(i);
                taskQueue.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable{
    LinkedList<Integer> taskQueue;
    Consumer(LinkedList<Integer> taskQueue){
        this.taskQueue = taskQueue;
    }
    @Override
    public void run() {
        while (true){
            int consume =consume();
        }
    }

    private int consume() {
        synchronized (taskQueue){
            while (taskQueue.size() ==0){
                try {
                    taskQueue.wait();
                }
                catch (Exception e){

                }
                }
            int itemfetched = taskQueue.getFirst();
            taskQueue.notifyAll();
            return itemfetched;
        }
    }
}
