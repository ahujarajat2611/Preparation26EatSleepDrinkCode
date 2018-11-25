package SystemDesign;

/**
 * Created by hadoop on 20/2/18.
 */
public class ParallelServiceCallingAgainTushar {
}

/*
class NonBlockingCallBack implements Runnable {
    NonBlockCallBack(Service service) {

    }

    void run() {
         List<Integer> r = service.execute()
         synchronized(finalResults) {
             finalResults.addAll(r);
         }
         if (count.size() == 3){
             notify.callback();
         }
    }
}

public static void execute(List<Integer> finalResults, Notification nofity) {
    Service service1
    Service service2
    Service service3;

    AtomicInteger count = nenw AtomicInteger(0);
    executor.exceute(new NonBlockingCallBack(service1, finalResults, nofity));
    executor.exceute(new NonBlockingCallBack(service2, finalResults));
    executor.exceute(new NonBlockingCallBack(service3, finalResults));

}
 */