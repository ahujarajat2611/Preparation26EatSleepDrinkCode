package SystemDesignCodes.Threading;

/**
 * Created by hadoop on 8/10/17.
 */
public class AtomicIntegerCustom {
    int currentValue;
    int previosValue;

    AtomicIntegerCustom(){
        currentValue = 0;
    }
    AtomicIntegerCustom(int init){
        this.currentValue = init;
    }
    public synchronized int get(){
        return currentValue;
    }
    public synchronized void set(int value){
        currentValue = value;
    }
    private synchronized int getAndSet(int value){
        previosValue = currentValue;
        currentValue = value;
        return previosValue;
    }
    public synchronized void increment(){
        currentValue++;
    }
}
