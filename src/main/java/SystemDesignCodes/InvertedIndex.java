package SystemDesignCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 7/10/17.
 */
public class InvertedIndex {
    class Document {
        public int id;
        public String content;
    }
    Map<String,List<Integer>> getInvertedIndex(List<Document> docs){
        Map<String,List<Integer>> invertedIndex = new HashMap<>();
        if(docs == null){
            return invertedIndex;
        }
        for(Document d :docs){
            String [] words = d.content.split(" ");
            for(String word:words){
                if(isStopWords(word) || word.length() ==0){
                    continue;
                }
                if(!invertedIndex.containsKey(word)){
                    List<Integer> list = new ArrayList<>();
                    invertedIndex.put(word,list);
                }
                invertedIndex.get(word).add(d.id);
            }
        }
        return invertedIndex;
    }

    private boolean isStopWords(String word) {
        if(word.equals("the")){
            return true;
        }
        return false;
    }
}