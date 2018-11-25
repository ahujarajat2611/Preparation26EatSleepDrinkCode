package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hadoop on 12/10/17.
 */
public class WordDistance2 {
    HashMap<String,List<Integer>> hashmap = new HashMap<String,List<Integer>>();
    WordDistance2(String []words){
        for(int i=0;i<words.length;i++){
            if(!hashmap.containsKey(words[i])){
                hashmap.put(words[i],new ArrayList<>());
            }
            hashmap.get(words[i]).add(i);
        }
    }
    public Integer shortest(String word1,String word2){
        List<Integer> list1 = hashmap.get(word1);
        List<Integer> list2 = hashmap.get(word2);
        if(list1 == null || list2 == null){
            return null;
        }
        int size1 = list1.size();
        int size2 = list2.size();
        int index1=0;
        int index2 =0;
        int mindist = Integer.MAX_VALUE;
        while (index1<size1  &&index2<size2){
            mindist = Math.min(mindist,Math.abs(index1-index2));
            if(index1<index2){
                index1++;
            }
            else {
                index2++;
            }
        }
        return mindist;
    }
}






/*


class WordDistance {


    String []words;
        HashMap<String,List<Integer>> hashmap = new HashMap<String,List<Integer>>();

    public WordDistance(String[] words) {
        this.words = words;
        for(int i=0;i<words.length;i++){
            if(!hashmap.containsKey(words[i])){
                hashmap.put(words[i],new ArrayList<>());
            }
            hashmap.get(words[i]).add(i);
        }
    }

    public Integer shortest(String word1, String word2) {
       List<Integer> list1 = hashmap.get(word1);
        List<Integer> list2 = hashmap.get(word2);
        if(list1 == null || list2 == null){
            return null;
        }
        int size1 = list1.size();
        int size2 = list2.size();
        int index1=0;
        int index2 =0;
        int mindist = Integer.MAX_VALUE;
        while (index1<size1  &&index2<size2){
            mindist = Math.min(mindist,Math.abs(list1.get(index1)-list2.get(index2)));
            if(list1.get(index1)<list2.get(index2)){
                index1++;
            }
            else {
                index2++;
            }
        }
        // while(index1<size1){
        //  mindist = Math.min(mindist,Math.abs(list1.get(index1)-list2.get(index2-1)));
        //     index1++;
        // }
        // while(index2<size2){
        //              mindist = Math.min(mindist,Math.abs(list1.get(index1-1)-list2.get(index2)));
        //             index2++;
        // }
        return mindist;
    }
    }


/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
