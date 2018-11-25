package SystemDesignCodes.Threading.ConcurrencyPractical;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by hadoop on 27/10/17.
 */
class CallableFuture implements Callable<Integer> {
    Integer number;
    CallableFuture(int number){
        this.number = number;
    }
    @Override
    public Integer call() throws Exception {
        int ans =1;
        while (number>0){
            ans = ans *number;
            number--;
        }
        return ans; // imp as i m returnining ... imp ...
    }
}
class  CallableExample{
    public static void main(String[] args) {
        ThreadPoolExecutor poolOfThreads =(ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        int index = 1;
        Queue<Future<Integer>> futureObjects = new LinkedList<>();
        for(int i=0;i<5;i++){
            Future<Integer> futureObject= poolOfThreads.submit(new CallableFuture(index++));
            futureObjects.add(futureObject);
        }
        while (!futureObjects.isEmpty()){
            try {
                Future<Integer> ans = futureObjects.poll();
                Integer factans = ans.get();
                System.out.println("ans    " + factans);
            }
            catch (Exception e){

            }
        }
    }
}