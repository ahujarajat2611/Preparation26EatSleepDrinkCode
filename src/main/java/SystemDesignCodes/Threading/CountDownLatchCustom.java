package SystemDesignCodes.Threading;

/**
 * Created by hadoop on 8/10/17.
 */
public class CountDownLatchCustom {
    private int count;
    public CountDownLatchCustom(int count){
        this.count = count;
    }
    public synchronized void await(){
        if(count>0){
            try {
                wait();
            }
            catch (Exception e){

            }
        }
    }
    public synchronized void countDown(){
        count--;
        if(count == 0){
            notifyAll();
        }
    }
}
