package SystemDesignCodes.Threading.semaphore.countingsemaphore;
public class Reader implements Runnable {
	private Library library;
	public Reader(Library library) {
		this.library = library;
	}
	@Override
	public void run() {
		try {
			Book book = (Book)library.issueBook();
			book.read();
			library.returnBook(book);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}