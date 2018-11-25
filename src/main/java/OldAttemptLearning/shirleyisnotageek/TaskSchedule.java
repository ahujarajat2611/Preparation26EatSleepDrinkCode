package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 21/1/18.
 */
public class TaskSchedule {
    public class TaskScheduler {
        Set<Task> executed;
        Set<Task> allTasks;
        Set<Task> inProcess;
        public TaskScheduler(Set<Task> Tasks){
            allTasks = Tasks;
            executed = new HashSet<Task>();
            inProcess = new HashSet<Task>();
        }
        public void schedule(Set<Task> allTasks){
            for(Task t : allTasks){
                if(executed.contains(t))
                    continue;
                if(!inProcess.isEmpty() && inProcess.contains(t)){
                    t.Run();
                    inProcess.remove(t);
                    executed.add(t);
                    continue;
                }
                inProcess.add(t);
                schedule(t.GetDependencies());
                t.Run();
                inProcess.remove(t);
                executed.add(t);
            }
        }
    }
    abstract class  Task {
        abstract void Run();
        abstract Set<Task> GetDependencies();
    }
}
