package SystemDesignCodes.Threading;

/**
 * Created by hadoop on 8/10/17.
 */
public class RentrantLockCustom {
    int lockHoldCount;
    long idOfCurrenThread;
    RentrantLockCustom(){
        lockHoldCount = 0 ;
    }
    public synchronized void lock(){
        if(lockHoldCount == 0){
            lockHoldCount++;
            idOfCurrenThread = Thread.currentThread().getId();
        }
        else if(lockHoldCount>0 && idOfCurrenThread == Thread.currentThread().getId()){
            lockHoldCount++;
        }
        else {
            try{
                wait(); // blocking call until lockholdcount becomes 0
                lockHoldCount = 0;
                idOfCurrenThread = Thread.currentThread().getId();
            }
            catch (Exception e){

            }
        }
    }
    public synchronized void unlock(){

        if(lockHoldCount == 0){
            /// thrwo execption not possinble
        }
        lockHoldCount--;
        if(lockHoldCount == 0){
            this.notifyAll();
        }
    }
    public synchronized boolean tryLock(){
        if(lockHoldCount == 0){
            lock();
            return true;
        }
        else {
            return false;
        }
    }
}
