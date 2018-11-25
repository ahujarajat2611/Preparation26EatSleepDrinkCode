package SystemDesignCodes.Threading;

import java.util.concurrent.Semaphore;

/**
 * Created by hadoop on 8/10/17.
 */
public class SemaphoreUsage {
    static int sharedvariable = 1;
    // only one is allowed to permit the usage
    // zero or less means we need to release first before we aquire
   // static Semaphore semaphore = new Semaphore(1);
    static SemaphoreCustom semaphore = new SemaphoreCustom(1);
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    semaphore.acquire();
                    for (int i = 0; i < 50; i++) {
                        System.out.println("thread 1"+sharedvariable);
                        sharedvariable++;
                    }
                }
                catch (Exception e){

                }
                finally {
                    try {
                        semaphore.release();
                    }
                    catch (Exception e){

                    }
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("thread 2"+sharedvariable);

                    for (int i = 0; i < 50; i++) {
                        sharedvariable--;
                    }
                }
                catch (Exception e){

                }
                finally {
                    try {
                        semaphore.release();
                    }
                    catch (Exception e){

                    }
                }
            }
        });
        thread.start();
        thread1.start();
    }
}
