package SystemDesignCodes;

import java.util.Iterator;

/**
 * Created by hadoop on 7/10/17.
 */
public class WordCount {
    public static class Map {
        public void map(String key,String value,OutputCollector<String,Integer> outputCollector){
            String []words = key.split(" ");
            for(String word:words){
                outputCollector.collect(word,new Integer(1));
            }
        }
    }
    public static class Reduce{
        public void reduce(String key, Iterator<Integer> values,OutputCollector<String,Integer> outputCollector){
            Integer output=0;
            while (values.hasNext()){
                output = output+values.next();
            }
            outputCollector.collect(key,output);
        }
    }
}

class OutputCollector<K,V>{
    public void collect(K key,V value){
        //print collect output
    }
}