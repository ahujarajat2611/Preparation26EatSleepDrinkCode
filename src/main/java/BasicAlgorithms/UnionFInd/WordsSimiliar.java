package BasicAlgorithms.UnionFInd;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by hadoop on 24/12/17.
 */
public class WordsSimiliar {
    HashMap<String,String> parent = new HashMap<>();

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        for (String[] pair : pairs) {
            String parentFirst = find(pair[0]);
            String parentSecond = find(pair[1]);
            if(parentFirst == null){
                parent.put(pair[0],pair[0]);
            }
            if(parentSecond == null){
                parent.put(pair[1],pair[1]);
            }
            union(pair[0],pair[1]);
        }
        //System.out.println(parent);
        StringBuilder c = new StringBuilder();
        StringBuilder d = new StringBuilder();
        for(String a:words1){
            c.append(find(a)+" ");
        }
        for(String a:words2){
            d.append(find(a)+" ");
        }
        char []array = c.toString().toCharArray();
        char []array1 = d.toString().toCharArray();
        Arrays.sort(array);
        Arrays.sort(array1);
        return String.valueOf(array).equals(String.valueOf(array1));
        //return true;
    }

    private void union(String s, String s1) {
        String parentFirst = find(s);
        String parentSecond = find(s1);
        if(!parentFirst.equals(parentSecond)){
            parent.put(parentFirst,parentSecond);
        }
    }

    String find(String x){
         if(x==parent.get(x)) {
            // System.out.println(x);
             return x;
         }
         return find(parent.get(x));
    }

    public static void main(String[] args) {
        String []words1 = {"great", "acting", "skills"};
        String []words2 = {"fine", "drama", "talent"};
        String [][]pairs = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
        WordsSimiliar wordsSimiliar = new WordsSimiliar();
        System.out.println(wordsSimiliar.areSentencesSimilarTwo(words1,words2,pairs));
       // System.out.println(wordsSimiliar.find("ra"));
    }
    // Handled NUll cases very wellll ..
/*
public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

        if(words1.length!=words2.length)
            return false;

        Map<String,String> map = new HashMap<String,String>();

        for(String[] pair : pairs){

            String word1 = pair[0];
            String word2 = pair[1];

            if(!map.containsKey(word1))
                map.put(word1,word1);
            if(!map.containsKey(word2))
                map.put(word2,word2);

            setParent(map,word1,word2);

        }

        for(int i=0;i<words1.length;i++){

            String word1 = words1[i];
            String word2 = words2[i];

            String parent1 = getParent(word1,map);
            String parent2 = getParent(word2,map);

            if(!parent1.equals(parent2))
                return false;

        }
        return true;


    }

    public String getParent(String word,Map<String,String> map){

        if(!map.containsKey(word))
            return word;

        while(word!=map.get(word))
            word = map.get(word);
        return word;

    }

    public void setParent(Map<String,String> map,String word1,String word2){

        String p1 = getParent(word1,map);
        String p2 = getParent(word2,map);

        map.put(p1,p2);

    }
 */
 }
