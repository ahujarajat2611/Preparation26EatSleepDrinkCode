package DSA.Design;

/**
 * Created by hadoop on 18/2/18.
 */
public class DesignParallelRunningTasks {
}
/*
// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

interface Task {

    List<Task> dependecies;
    String name;
    void execute();
}


public void executeAllTasks(List<Task> tasks, int numberThreads) {

    List<Integer,List<Task>> topSort = new HashMap<Integer,List<Task>>();
    topOrder(tasks,topSort);
    int level =1;
    Executor exector = Exectors.newFixedSizePool(numberThreads);

    List<Task> levelTasks = topSort.get(level);
    Map<Integer,List<Future>> map = HashMap<Integer,new ArrayList<Future>>();
    for(Task task:levelTasks){
        Future obj = exector.add(levelTasks);
        if(!map.containsKey(level)){
            list.add(level,new ArrayList<Future>());
        }
        list.get(level).add(obj);
    }
    int size= levelTasks.size();
    for(Entry obj: map.entrySet()){
        if(obj.getValue().isDone()){
            int nextLevel = obj.getKey()+1;
            Task task = getNextLevelTask(topSort.get(nextLevel));
            Future fut = exector.add(task);

        }
    }
}

    }
}

void topOrder(List<Task> tasks,List<Integer,List<Task>> topSort){


    Map<Task,Integer> count = new HashMap<Tast,Integer>();

    for(Task task: tasks){
        for(Task task2: task.dependencies){
            if(!count.containsKey(task2)){
                count.put(task2,0);
            }
            count.put(task2,count.get(task2)+1);
        }
    }
    Queue<Task> queue = new LinkedList<Task>();
    topSort.add(level,new LinkedList<Task>());
    for(Task task:tasks){
        if(count.get(task) == 0){
            queue.add(task);
            //topSort.get(level).add(task);
        }
    }

    int level = 1;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i=0;i<size;i++){
            Task polled = queue.poll();

            if(!topSort.containsKey(level)){
                topSort.put(level,new LinkedList<Task>());
            }
            topSort.get(level).add(polled);

            for(Task child:polled.dependencies){
                int depn =count.get(child)-1;
                if(depn ==0){
                    queue.add(child);
                }
                else{
                    count.put(child,depen);
                }
            }
        }
        level++;
    }
}

A -> B
D ->C -> m -> B

(a,d)->(b,c)
 */