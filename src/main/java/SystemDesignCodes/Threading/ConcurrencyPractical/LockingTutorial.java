package SystemDesignCodes.Threading.ConcurrencyPractical;

/**
 * Created by hadoop on 27/10/17.
 */
public class LockingTutorial {
    class democlass{
        public synchronized void dosomework(){

        }
        public void dosomeworkagain (){
            synchronized (this){



            }
        }
    }
    static class demostaticlock{
        static Object lock = new Object();
        Object nonstatic = new Object();
        public synchronized static void demo(){

        }
        public static void demostatic(){
            synchronized (lock){

            }
        }

    }
    class waitconstruct{
        Object lock = new Object();
        boolean favourablecondition = false;
        void dosomework(){
            // if my favourable condition is not there i wilsleep
            synchronized (lock) {
                while (!favourablecondition) {
                    try {
                        lock.wait();
                    }
                    catch (Exception e){

                    }
                }
                /// perform what the fuck u want to do
            }



        }


    }
}
