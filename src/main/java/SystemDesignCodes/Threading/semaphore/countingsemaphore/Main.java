package SystemDesignCodes.Threading.semaphore.countingsemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		final int threadCount = 6;
		final ExecutorService exService = Executors.newFixedThreadPool(threadCount);
		final Library library = new Library();
		for(int i=0; i < threadCount; i++) {
			Reader reader = new Reader(library);
			exService.execute(reader);
		}
		exService.shutdown();
	}
}
