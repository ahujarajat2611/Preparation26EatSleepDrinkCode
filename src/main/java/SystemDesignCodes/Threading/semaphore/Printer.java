package SystemDesignCodes.Threading.semaphore;

import java.util.concurrent.Semaphore;

public class Printer {
	   private static final int MAX_PERMIT = 1;
	   private final Semaphore semaphore = new Semaphore(MAX_PERMIT, true);
	   public void print(String jobName) {
	      try {
			semaphore.acquire();
			System.out.println("Printing MyJob: "+ jobName);
		    Thread.sleep(2000);
			System.out.println("Finished MyJob: "+ jobName);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }finally {
		    semaphore.release();
		  }
	   }
}