package SystemDesignCodes;


import java.util.HashMap;

/**
 * Created by hadoop on 7/10/17.
 */
public class MemCache {
    private class Data{
        int ttl;
        int editTime;
        int value;
        public Data(int value,int ttl,int editTime){
            this.value = value;
            this.ttl = ttl;
            this.editTime = editTime;
        }
    }
    // we need to put value with timestamp and ttl thats all other opertaions are trivial

    // incr,decr
    //
    HashMap<Integer,Data> cache;

    MemCache(){
        cache = new HashMap<>();
    }
    public int get(int currentTime,int key){
        int val= Integer.MAX_VALUE;
        if(!cache.containsKey(key)){
            return -1;
        }
        Data data = cache.get(key);
        if(data.ttl ==0 || data.ttl + data.editTime-1>=currentTime){
            val = data.value;
        }
        else {
            cache.remove(key);
        }
        return val;
    }
    public void set(int currenttime,int key,int ttl,int value){
        cache.put(key,new Data(value,ttl,currenttime));
    }
    public int incr(int currenttime,int key,int delta){
        int val = Integer.MAX_VALUE;
        if(!cache.containsKey(key)){
            return val;
        }
        Data data = cache.get(key);
        if(data.ttl == 0 || data.ttl +data.editTime-1>=currenttime){
            data.value+=delta;
            val = data.value;
            cache.put(key,data);
            return val;
        }
        else {
            cache.remove(key);
        }
        return val;
    }
    public int decr(int currenttime,int key,int delta){
        int value = Integer.MAX_VALUE;
        if(!cache.containsKey(key)){
            return value;
        }
        Data data = cache.get(key);
        if(data.ttl == 0 || data.ttl+data.editTime-1>=currenttime){
            data.value = data.value-delta;
            value = data.value;
            cache.put(key,data);
        }
        else {
            cache.remove(key);
        }
        return value;
    }

}
