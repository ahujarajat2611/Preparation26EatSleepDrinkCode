package SystemDesignCodes.Threading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		final int threadCount = 5;
		final ExecutorService exService = Executors.newFixedThreadPool(threadCount);
		final Printer printer = new Printer();
		for (int i=1; i<= threadCount; i++) {
			exService.execute(new MyJob(printer, "MyJob-"+i));
		}
		exService.shutdown();
	}
}
