package SystemDesign;

/**
 * Created by hadoop on 20/2/18.
 */
public class ParallelServiceCalling {

}
/*
Class task implements Callable(
    Service endPoint
    Task(Service endPoint){
        this.endPoint = endPoint;
    }
    String call (){
        String ans = endPoint.callService();
        return ans;
    }
}
Class Main{
    public static void main(String args[]){
        ExectorService threadPool = Exectors.newFixedCachThreadPool(3);
        Service service1 = new Service("url1");
        Service service2 = new Service("url2");
        Service service3 = new Service("url3");

        List<Future> list = new ArrayList<Future>();
        Task task1 = new Task(service1);
        Task task2 = new Task(service2);
        Task task3 = new Task(service3);
        list.add(threadPool.execute(service1));
        list.add(threadPool.execute(service2));
        list.add(threadPool.execute(service3));
        boolean isDone = true;
        List<String> serviceAns = new ArrayList<String>();
        for(Future obj :list){
            if(obj.isDone()){
                serviceAns(obj.getObject());
            }
        }
        // insertion order // treemap
        return serviceAns;

        }
    }
}
 */