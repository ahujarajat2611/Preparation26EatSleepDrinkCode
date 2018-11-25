package SystemDesignCodes;


import java.util.*;

/**
 * Created by hadoop on 7/10/17.
 */
public class MiniCasandra {
    HashMap<String,TreeMap<Integer,String>> store;
    public  MiniCasandra(){
        store = new HashMap<>();
    }

    public void insert(String raw_key,int column_key,String column_value){
        TreeMap<Integer,String> data;
        if(store.containsKey(raw_key)){
            data = store.get(raw_key);
        }
        else {
            data = new TreeMap<>();
        }
        data.put(column_key,column_value);
        store.put(raw_key,data);
    }

    List<Column> query(String raw_key, int column_start, int column_end){
        List<Column> list = new ArrayList<>();
        TreeMap map = store.get(raw_key);
        if(map == null){
            return null;
        }
        NavigableMap<Integer,String> submap = map.subMap(column_start,true,column_end,true);
        for(Map.Entry<Integer,String> entry:submap.entrySet()){
            list.add(new Column(entry.getKey(),entry.getValue()));
        }
        return list;
    }
    private class Column{
        int key;
        String value;
        Column(Integer key,String value){
            this.key = key;
            this.value = value;
        }
    }
}
