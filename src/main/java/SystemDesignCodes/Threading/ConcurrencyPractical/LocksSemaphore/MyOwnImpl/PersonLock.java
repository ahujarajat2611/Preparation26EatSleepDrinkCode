package SystemDesignCodes.Threading.ConcurrencyPractical.LocksSemaphore.MyOwnImpl;

import java.util.concurrent.Semaphore;

/**
 * Created by hadoop on 27/10/17.
 */
public class PersonLock {
    PersonLock instance;
    private PersonLock(){

    }
    PersonLock getInstance(){
        if(instance == null){
            synchronized (instance){
                if(instance == null){
                    instance=new PersonLock();
                    return instance;
                }
                return instance;
            }
        }
        else {
            return instance;
        }
    }
    private Semaphore readLock = new Semaphore(10);
    private Semaphore writeLock = new Semaphore(1);

    public void getReadLock() throws Exception{
        readLock.acquire();
    }
    public void getWriteLock() throws Exception{
        writeLock.acquire();
    }
    public void releeaseReadLock() throws Exception{
        readLock.release();
    }
    private void releaseWriteLock(){
        writeLock.release();
    }



}
