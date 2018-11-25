package SystemDesignCodes.Threading.semaphore;
public class MyJob implements Runnable {
	private Printer printer;
	private String jobName;  
	public MyJob(Printer printer, String jobName) {
		this.printer = printer;
		this.jobName = jobName;
	}
	@Override
	public void run() {
		System.out.println("MyJob sent to printer:"+ jobName);
		printer.print(jobName);
	}
}