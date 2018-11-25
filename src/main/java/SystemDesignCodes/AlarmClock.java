package SystemDesignCodes;

import java.util.concurrent.*;

/**
 * Created by hadoop on 8/10/17.
 */
public class AlarmClock {
    long initialDelay;
    long delayBetweenRuns;
    long shutDownAfter;
    private ScheduledExecutorService fschedular;
    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock(3,1,20);
        clock.activateAlarmAndThenStop();
    }

    public AlarmClock(long initialDelay, long delayBetweenRuns, long shutDownAfter) {
        this.initialDelay = initialDelay;
        this.delayBetweenRuns = delayBetweenRuns;
        this.shutDownAfter = shutDownAfter;
        fschedular = Executors.newScheduledThreadPool(1);
    }

    public void activateAlarmAndThenStop(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            log("try");
            }
        };
        Runnable stop = new Runnable() {
            @Override
            public void run() {

                fschedular.shutdown();
            }
        };
       ScheduledFuture future =  fschedular.scheduleWithFixedDelay(runnable,initialDelay,delayBetweenRuns, TimeUnit.SECONDS);
       Future objet = fschedular.schedule(stop,shutDownAfter,TimeUnit.SECONDS);
        System.out.println(future.isCancelled());
        System.out.println(objet.isCancelled());
        try {
            System.out.println("blocjed");
            objet.get();
            System.out.println("blocking cal");
            System.out.println(objet.isDone());
            System.out.println(future.isDone());

        }
        catch(Exception e){

        }
    }
    private static void log(String aMsg){
        System.out.println(aMsg);
    }
}
