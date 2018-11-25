package SystemDesignCodes.Threading.ConcurrencyPractical;

import java.util.concurrent.Semaphore;

/**
 * This class will allow thread to acquire and release locks as required
 * 
 * @author dinuka.arseculeratne
 * 
 */
public class PersonLock {

	/**
	 * We do not want multiple lock objects lying around so we make ths class
	 * singleton
	 */
	private PersonLock() {

	}

	/**
	 * Bill Pugh's way of lazy initializing the singleton instance
	 * 
	 * @author dinuka.arseculeratne
	 * 
	 */
	private static class SingletonHolder {
		public static final PersonLock INSTANCE = new PersonLock();
	}

	/**
	 * Use this method to get a reference to the singleton instance of
	 * {@link PersonLock}
	 * 
	 * @return the singleton instance
	 */
	public static PersonLock getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * In this sample, we allow only one thread at at time to update the cache
	 * in order to maintain consistency
	 */
	private Semaphore writeLock = new Semaphore(1);

	/**
	 * We allow 10 concurrent threads to access the cache at any given time
	 */
	private Semaphore readLock = new Semaphore(10);

	public void getWriteLock() throws InterruptedException {
		writeLock.acquire();
	}

	public void releaseWriteLock() {
		writeLock.release();
	}

	public void getReadLock() throws InterruptedException {
		readLock.acquire();
	}

	public void releaseReadLock() {
		readLock.release();
	}
}
