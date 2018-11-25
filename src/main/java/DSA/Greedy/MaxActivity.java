package DSA.Greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hadoop on 12/2/18.
 */
public class MaxActivity {
    // Lis of acctivites that finish first always we can pick maximun
    // number of things if we sort by finish times
    public void printMaxAcitiviesBySinglePerson(List<ActivityJob> jobs) {
        Collections.sort(jobs, new Comparator<ActivityJob>() {
            @Override
            public int compare(ActivityJob o1, ActivityJob o2) {
                return o1.finish-o2.finish;
            }
        });
        ActivityJob prev = jobs.get(0);
        System.out.println(prev);
        for(int i=1;i<jobs.size();i++){
            ActivityJob current = jobs.get(i);
            if(current.start>=prev.finish){
                System.out.println(current);
                prev = current;
            }
        }
    }
}
class ActivityJob {
    int id;
    int start;
    int finish;

    public ActivityJob(int id, int start, int finish) {
        super();
        this.id = id;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", publish=" + start + ", finish=" + finish + "]";
    }

}
