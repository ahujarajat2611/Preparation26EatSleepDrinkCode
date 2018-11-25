package SystemDesignCodes.Threading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hadoop on 8/10/17.
 */
public class LinkedBlockingQueueCustom<E> {
    List<E> list;
    int maxsize;
    LinkedBlockingQueueCustom(int maxsize){
        list = new LinkedList<>();
        this.maxsize = maxsize;
    }
    public void put(E e) {
        if(list.size() == maxsize){
            try {
                wait();
            }
            catch (Exception x){

            }
        }

        list.add(e);
        this.notifyAll();
    }

    public E take() throws InterruptedException {
        if(list.size() == 0){
            try{
                wait();
            }
            catch (Exception e){

            }
        }
        E ob =list.get(0);
        this.notifyAll();
        return ob;
    }
}
