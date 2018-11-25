package AwangDevLintCode;

/**
 * Created by hadoop on 24/2/18.
 */
import java.util.*;
public class ShortAndSweetWordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String,Integer> distance = new HashMap<>();
        //Set<String> visited = new HashSet<>();
        //int infinity = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<String>();
        distance.put(beginWord,1);
        for(String x:wordList){
            visited.add(x);
        }
        queue.add(beginWord);
        visited.remove(beginWord);
        while (!queue.isEmpty()){
            String v = queue.poll();
            List<String> neighbours = getAdj(v,visited);
            for(String w:neighbours){
                // int parentdis = distance.get(v)+1;
                // Integer child = distance.get(w);
                // if(child!=null && child <=parentdis){
                //     continue;
                // }
                //  if(wordList.contains(w)){
                distance.put(w,distance.get(v)+1);
                queue.add(w);
                visited.remove(w);
                if(w.equals(endWord)){
                    return distance.get(w);
                }
                // }
            }
        }
        return 0;
        //}
    }

    private List<String> getAdj(String polled, Set<String> visited) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(polled);
        sb.replace(1,1,"2");
        char []array = polled.toCharArray();
        for(int i=0;i<array.length;i++){
            for(char a='a';a<='z';a++){
                char save = array[i];
                array[i] = a;
                String changed = String.valueOf(array);
                // means present in the dictionary thats very imp step !!!!
                if(visited.contains(changed)){
                    list.add(changed);
                }
                array[i]= save;
            }
        }
        return list;
    }
    void testStringBuilder(String polled, Set<String> visited){
        StringBuilder sb = new StringBuilder(polled);

        List<String> list = new ArrayList<>();
        for(int i=0;i<polled.length();i++){
            char orig = polled.charAt(i);
//            sb.deleteCharAt(i);
            for(char c='a';c<='z';c++){
                if(c!=orig) {
                    sb.deleteCharAt(i);
                    sb.insert(i,c);
                    //sb.replace(i, i+1, c+"");
                    System.out.println(sb.toString());
                  //  sb.deleteCharAt(i);

                }
//                }
//                if(visited.contains(sb.toString())){
//                    list.add(sb.toString());
//                }
            }
            sb.deleteCharAt(i);
            sb.insert(i,orig);
            //sb.replace(i,i+1,orig+"");
        }
    }

    public static void main(String[] args) {
        ShortAndSweetWordLadder shortAndSweetWordLadder = new ShortAndSweetWordLadder();
        shortAndSweetWordLadder.testStringBuilder("rajat",null);
    }
}
