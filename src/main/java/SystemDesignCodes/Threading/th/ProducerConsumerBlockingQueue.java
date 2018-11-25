//package SystemDesignCodes.Threading.th;
//
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
///**
// * Producer Class in java.
// */
//class Producer implements Runnable {
//
//    private final BlockingQueue<Integer> sharedQueue;
//
//    public Producer(BlockingQueue<Integer> sharedQueue) {
//        this.sharedQueue = sharedQueue;
//    }
//
//    @Override
//    public void run() {
//        for(int i=1; i<=10; i++){
//         try {
//             System.out.println("Produced : " + i);
//             //put/produce into sharedQueue.
//             sharedQueue.put(i);
//         } catch (InterruptedException ex) {
//
//         }
//        }
//    }
//
//}
//
///**
// * Consumer Class in java.
// */
//class Consumer implements Runnable{
//
//    private BlockingQueue<Integer> sharedQueue;
//
//    public Consumer (BlockingQueue<Integer> sharedQueue) {
//        this.sharedQueue = sharedQueue;
//    }
//
//    @Override
//    public void run() {
//        while(true){
//         try {
//           //take/consume from sharedQueue.
//             System.out.println("CONSUMED : "+ sharedQueue.take());
//         } catch (InterruptedException ex) {
//
//         }
//        }
//    }
//
//
//}
//
///** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
//public class ProducerConsumerBlockingQueue {
//
//    public static void main(String args[]){
//
//     //Creating shared object
//     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
//
//     Producer producer=new Producer(sharedQueue);
//     Consumer consumer=new Consumer(sharedQueue);
//
//     Thread producerThread = new Thread(producer, "ProducerThread");
//     Thread consumerThread = new Thread(consumer, "ConsumerThread");
//     producerThread.publish();
//     consumerThread.publish();
//
//    }
//
//}