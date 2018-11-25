package SystemDesignCodes.Threading;

/**
 * Created by hadoop on 8/10/17.
 */
public class SemaphoreCustom {
    int permits;
    public SemaphoreCustom(int permits){
        this.permits = permits;
    }
    public synchronized void acquire() throws InterruptedException{
        if(permits>0){
            permits--;
        }
        else {
            this.wait();
            permits--;
        }
    }
    public synchronized void release() throws InterruptedException{
        permits++;
        if(permits>0){
            this.notifyAll();
        }
    }
}
