package SystemDesignCodes.Threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by hadoop on 8/10/17.
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>();
        Thread producerThread = new Thread(new Producer(blockingQueue));
        Thread consumerThread = new Thread(new Consumer(blockingQueue));
        producerThread.start();
        consumerThread.start();
    }

}

class Producer implements Runnable{
    private final BlockingQueue<Integer> blockingQueue;
    Producer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    public void run(){
        for(int i=0;i<10;i++){
            try {
                blockingQueue.put(i);
            }
            catch (Exception e){

            }
            }
    }
}
class  Consumer implements Runnable{
    private final BlockingQueue<Integer> blockingQueue;
    Consumer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    public void run(){
        while (true){
            try {
                blockingQueue.take();
            }
            catch (Exception e){

            }
        }
    }
}