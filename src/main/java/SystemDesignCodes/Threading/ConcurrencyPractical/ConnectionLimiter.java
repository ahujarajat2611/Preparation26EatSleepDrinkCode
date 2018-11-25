package SystemDesignCodes.Threading.ConcurrencyPractical;

import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Semaphore;

/**
 * Created by hadoop on 26/10/17.
 */
public class ConnectionLimiter {
    private final Semaphore semaphore;
    ConnectionLimiter(int numberOfRequests){
        semaphore = new Semaphore(numberOfRequests);
    }
    public URLConnection aquire(URL url){
        try {
            semaphore.acquire();
            return url.openConnection();
        }
        catch (Exception e){
            return null;
        }
    }
    public void release(URLConnection urlConnection){
        try{
            // clean up urlconnection resource
        }finally {
            semaphore.release();
        }
    }
}
/*
This is a nice elegant solution to a problem of limited resources. T
he call to acquire() will block until permits are available. T
he beauty of the semaphore is that it hides all the complexity of managing access control, counting permits and, of course, getting the thread-safety right.
As with most methods of locking or synchronization, there are some potential issues.

The number one thing to remember is, always release what you acquire. This is done by using try..finally constructs.

There are other less obvious problems that can befall you when using semaphores. The following class shows a deadlock that only the luckiest of you will avoid. You’ll notice that the two threads which acquire the two semaphore permits do so in opposite order. (try..finally is left out for the sake of brevity).
Useful Tricks with Semaphores

One interesting property of Semaphores in Java is that release doesn’t have to be called by the same thread as acquire. This means you could have a thread limiter that pools or creates threads based on a semaphore by calling acquire(). Then, the running thread could release its own semaphore permit when it completes. This is a useful property that we don’t have with normal mutexes in Java.

Uses

What are some possible uses for counting semaphores? The following come to mind:

Limiting concurrent access to disk (this can kill performance due to competing disk seeks)
Thread creation limiting
JDBC connection pooling / limiting
Network connection throttling
Throttling CPU or memory intensive tasks




Dangers

As with most methods of locking or synchronization, there are some potential issues.

The number one thing to remember is, always release what you acquire. This is done by using try..finally constructs.

There are other less obvious problems that can befall you when using semaphores. The following class shows a deadlock that only the luckiest of you will avoid. You’ll notice that the two threads which acquire the two semaphore permits do so in opposite order. (try..finally is left out for the sake of brevity).

public static void main(String[] args) throws Exception {
   Semaphore s1 = new Semaphore(1);
   Semaphore s2 = new Semaphore(1);

   Thread t = new Thread(new DoubleResourceGrabber(s1, s2));
   // now reverse them ... here comes trouble!
   Thread t2 = new Thread(new DoubleResourceGrabber(s2, s1));

   t.publish();
   t2.publish();

   t.join();
   t2.join();
   System.out.println("We got lucky!");
}

private static class DoubleResourceGrabber implements Runnable {
   private Semaphore first;
   private Semaphore second;

   public DoubleResourceGrabber(Semaphore s1, Semaphore s2) {
       first = s1;
       second = s2;
   }

   public void run() {
       try {
           Thread t = Thread.currentThread();

           first.acquire();
           System.out.println(t + " acquired " + first);

           Thread.sleep(200); // demonstrate deadlock

           second.acquire();
           System.out.println(t + " acquired " + second);

           second.release();
           System.out.println(t + " released " + second);

           first.release();
           System.out.println(t + " released " + first);
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
   }
}
If you run this, you will more than likely have a hung process. Issues of lock ordering apply to semaphores as much as regular mutexes or synchronization in Java. In some cases, timeouts (see note on tryAcquire() later in the article) can be used to prevent deadlocks from causing a process to hang up, but typically a deadlock is a symptom of a logic error which can be avoided. If you’re unfamiliar with deadlocks, I recommend you read up on them. Wikipedia has a decent article on deadlocks which applies to all languages equally.

The main things that you should be careful of when using semaphores (including binary semaphores, i.e. mutexes) are:

Not releasing after acquire (either missing release call or an exception is thrown and there is no finally block)
Long held semaphores, causing thread starvation
Deadlocks (as seen above)
Useful Tricks with Semaphores

One interesting property of Semaphores in Java is that release doesn’t have to be called by the same thread as acquire. This means you could have a thread limiter that pools or creates threads based on a semaphore by calling acquire(). Then, the running thread could release its own semaphore permit when it completes. This is a useful property that we don’t have with normal mutexes in Java.

Another trick is to increase the number of permits at runtime. Contrary to what you might guess, the number of permits in a semaphore isn’t fixed, and a call to release() will always increment the number of permits, even if no corresponding acquire() call was made. Note that this can also result in bugs if you are incorrectly calling release() when no acquire() was made.

Finally, there are a few useful methods to be familiar with in Java’s Semaphore. The method acquireInterruptibly() will acquire a resource, reattempting if it is interrupted. This means no outside handling of InterruptedException. The method tryAcquire() allows us to limit how long we will wait for a permit – we can either return immediately if there is no permit to obtain, or wait a specified timeout. If you somehow have known deadlocks that you can’t fix easily or track down, you could help prevent locking up processes by using tryAcquire() with suitable timeouts.
 */