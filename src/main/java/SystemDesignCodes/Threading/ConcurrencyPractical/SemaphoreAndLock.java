package SystemDesignCodes.Threading.ConcurrencyPractical;

/**
 * Created by hadoop on 27/10/17.
 */
public class SemaphoreAndLock {


}

class  Job implements Runnable{
    int id;
    Job(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("print this file using printer id"+id) ;
    }
}
