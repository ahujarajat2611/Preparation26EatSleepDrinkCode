package SystemDesignCodes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by hadoop on 8/10/17.
 */
public class SchedularTokenBucket {
    private Semaphore semaphore;
    private int maxPermits;
    private TimeUnit timeUnit;
    private ScheduledExecutorService service;

    public static SchedularTokenBucket create(int permits,TimeUnit timeUnit){
        SchedularTokenBucket schedularTokenBucket = new SchedularTokenBucket(permits,timeUnit);
        schedularTokenBucket.scheduleReplnishment();
        return schedularTokenBucket;
    }

    public SchedularTokenBucket(int maxPermits, TimeUnit timeUnit) {
        this.maxPermits = maxPermits;
        this.timeUnit = timeUnit;
    }
    public boolean aquire(int times) throws Exception{
        if(semaphore.tryAcquire((times))){
            return true;
        }
        return false;

    }

    private void scheduleReplnishment(){
        service = Executors.newScheduledThreadPool(1);
        service.schedule(new Runnable() {
            @Override
            public void run() {
              semaphore.release(maxPermits-semaphore.availablePermits());
            }},1,timeUnit);
    }
}
