package SystemDesignCodes.Threading.semaphore.countingsemaphore;
public class Book {
	private String bookName;
	public Book(String bookName) {
		this.bookName = bookName;
	}
	public void read() {
		System.out.println(bookName + " is being read......");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String getBookName() {
		return bookName;
	}
}
