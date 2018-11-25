package SystemDesignCodes.Threading.semaphore.countingsemaphore;

import java.util.concurrent.Semaphore;

public class Library {
	   private static final int MAX_PERMIT = 3;
	   private final Semaphore availableBook = new Semaphore(MAX_PERMIT, true);
	   private Book[] books = {new Book("Ramayan"), new Book("Mahabharat"), new Book("Panchtantra")};
	   private boolean[] beingRead = new boolean[MAX_PERMIT];
	   
	   //Book is being issued to reader
	   public Object issueBook() throws InterruptedException {
	     availableBook.acquire();
	     return getNextAvailableBook();
	   }
	   private synchronized Book getNextAvailableBook() {
		 Book book = null;  
	     for (int i = 0; i < MAX_PERMIT; ++i) {
	       if (!beingRead[i]) {
	          beingRead[i] = true;
	          book = books[i];
	          System.out.println(book.getBookName()+" has been issued.");
	          break;
	       }
	     }
	     return book;
	   }
	   //Book is being returned to library
	   public void returnBook(Book book) {
		     if (markAsAvailableBook(book))
		       availableBook.release();
	   }	   
	   private synchronized boolean markAsAvailableBook(Book book) {
		 boolean flag = false;  
	     for (int i = 0; i < MAX_PERMIT; ++i) {
	       if (book == books[i]) {
	          if (beingRead[i]) {
	            beingRead[i] = false;
	            flag = true;
		        System.out.println(book.getBookName()+" has been returned.");
	          } 
	          break;
	       }
	     }
	     return flag;
	   }
}