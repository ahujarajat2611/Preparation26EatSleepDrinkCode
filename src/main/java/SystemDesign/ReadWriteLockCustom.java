package SystemDesign;

/**
 * Created by hadoop on 9/10/17.
 */


interface ReadWriteLock{
    public ReentrantReadWriteLock.ReadLock readLock();
    public ReentrantReadWriteLock.WriteLock writeLock();
}
class ReentrantReadWriteLock implements ReadWriteLock{
    public int readLockCount;
    public int writeLockCount;
    public ReadLock readLock;
    public WriteLock writeLock;
    public ReentrantReadWriteLock() {
        super();
    }

    @Override
    public ReadLock readLock() {
        return readLock;
    }

    @Override
    public WriteLock writeLock() {
        return writeLock;
    }

    public class ReadLock{
        public synchronized void lock (){
            if(writeLockCount == 0 ){
                readLockCount++;
            }
            try {
                wait();
            }
            catch (Exception e){

            }
        }
        public synchronized void release(){
            readLockCount--;
            if(readLockCount == 0) {
                notifyAll();
            }
        }
    }
    public class WriteLock{
        public synchronized void lock(){
            if(writeLockCount == 0 && readLockCount == 0){
                writeLockCount++;
            }
            else {
                try {
                    wait();
                } catch (Exception e) {

                }
            }
        }
        public synchronized void release(){
            writeLockCount--;
            if(writeLockCount ==0){
                notifyAll();
            }
        }

    }
}