package SystemDesignCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 7/10/17.
 */
public class HeartBeat {
    Map<String,Integer> slaves;
    int interval;
    HeartBeat(){
        slaves = new HashMap<>();
    }

    public void init(List<String> slaveiplist,int interval){
        if(slaveiplist == null){
            return;
        }
        for(String ip:slaveiplist){
            slaves.put(ip,0); // timestamp
        }
        this.interval = interval; // after which ping happens
    }
    public void ping(int timestamp,String slave_ip){
        slaves.put(slave_ip,timestamp);
    }
    public List<String> getDiedSlaves(int timestamp){
        List<String> ret = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:slaves.entrySet()){
            if(entry.getValue()+ 2*interval >timestamp){
                ret.add(entry.getKey());
            }
        }
        return ret;
    }
}
