package SystemDesignCodes;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by hadoop on 7/10/17.
 */
// record a hit and provide hits in last 5 minutes
// maintains 300 timestaps of each second in last 5 minutes
    //with treemap its piece of cake
public class WebLogger {
    SortedMap<Integer,Integer> hitMap;
    WebLogger(){
        hitMap = new TreeMap<>();
    }
    public void hit(Integer timestamp){
        // remove all vlaues that are before timestamp-299
        // if we need vlaues from starting use headmap
        // if we need values from ending use tail mao
        hitMap = hitMap.tailMap(timestamp-299);

        if(hitMap.containsKey(timestamp)){
            hitMap.put(timestamp,hitMap.get(timestamp)+1);
            return;
        }
        else {
            hitMap.put(timestamp,1);
        }
        return;
    }
    public void get_hit_count_in_5min(Integer timestamp){
        hitMap = hitMap.tailMap(timestamp-299);
        int count = 0;
        for(int hits:hitMap.values()){
            count = count+hits;
        }
    }

}
class OptimizedWebLogger{
    int count;
    int []hitmap;
    int lasthit; // so that you can update counter with everyhit

    OptimizedWebLogger(){
        count = 0;
        lasthit = -1;
        hitmap = new int[300];
    }

    public void hit(Integer timestamp){
        // first you call timefluy
        // imcrement count
        timeFly(timestamp);
        count++;
        //increment crrenttimestamp by 1
        hitmap[timestamp%300]+=1;
        lasthit = timestamp;
        // update lastt itmesamtp
    }

    private int getHitsInLast5min(Integer timestamp) {
        // imp to call timefly !!
        timeFly(timestamp);
        return count;
    }

    public void timeFly(Integer timestamp) {
        if (lasthit > 0) {
            if (timestamp - lasthit >= 300) {
                // actually not required at alll
                // you can choose to skip it

                count = 0;
                for (int i = 0; i < 300; i++) {
                    hitmap[i] = 0;
                }
            } else {
                for (int i = lasthit + 1; i <= timestamp; i++) {
                    // reduce count by that lasthit to timestamp
                    count = count - hitmap[i % 300];
                    // make hit for that secondd zero !!!
                    hitmap[i % 300] = 0;

                }
            }
        }
    }
    public void myhit(Integer timestamp){
        // first you call timefluy
        timeFlyMine(timestamp);
        hitmap[timestamp%300] +=1;
        lasthit=timestamp;
        count = count+1;
    }
    void timeFlyMine(Integer timestamp){

        for(int i= lasthit+1;i<=timestamp;i++){
            count = count -hitmap[i%300];
            hitmap[i%300] = 0;
        }

    }
}
// very straight forward just array of 300 seconds
//
