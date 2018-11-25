package AwangDevLintCode;

/**
 * Created by hadoop on 24/2/18.
 */
import java.util.*;
public class ShortAndSweetWordLadder2 {
    Map<String,List<String>> map;
    List<List<String>> results;
    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        results = new ArrayList<>();
        if(dict.size() == 0){
            return results;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        map = new HashMap<>();
        Map<String,Integer> ladder = new HashMap<>();
        for(String string:dict){
            ladder.put(string,Integer.MAX_VALUE);
        }
        ladder.put(start,0);

        Integer min = Integer.MAX_VALUE;
        // BFS DIJKSTTA
        while (!queue.isEmpty()){
            String word = queue.poll();
            int step = ladder.get(word)+1;
            if(step>min){
                break;
            }
            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                for(char a='a';a<='z';a++){
                    sb.setCharAt(i,a);
                    String newword = sb.toString();
                    if(ladder.containsKey(newword)){
                        int dis = ladder.get(newword);
                        // this is the case of visited when word alreay visited hence continue
                        if(dis<step){
                            continue;
                        }
                        // found shortest path .. this is possible for first visit ...
                        // other visits would end up in if loop given above
                        /// or there could be equal cases as well which we need to handle in
                        // mapping parents
                        /*
                          if(dis !=step){
                            queue.add(newword);
                        }

                        here we do not want to insert multiples times in queue
                        but we want to keep track of parent with equal size path
                        // thats the challange here
                        // which we  are trying to solve here !!!!!!


                        better option was if visited and distance equal condition would have make much more sense and easy to understand 1!
                         */
                        else if(dis>step){
                            ladder.put(newword,step);
                            queue.add(newword);
                        }
                        else {
                            // do nothing just update path as we are going down
                        }

                        // Adding only smallest equal path // avioded longes path
                        //with continue written above
                        if(map.containsKey(newword)){
                            map.get(newword).add(word);
                        }
                        else {
                            map.put(newword,new LinkedList<>(Arrays.asList(new String []{word})));
                        }

                        if(newword.equals(end)){
                            min = step;
                        }

                    }
                }
            }
        }
        LinkedList<String> result = new LinkedList<>();
        result.add(0,end);
        backTrace(end, start, result);
        return results;
    }

    private void backTrace(String end, String start, LinkedList<String> result) {
        if(end.equals(start)){
            // result.add(0,publish);
            results.add(new ArrayList<>(result));
            //result.remove(0);
            return;
        }
        else {if(map.get(end)!=null){
            for (String recu : map.get(end)) {
                result.add(0,recu);
                backTrace(recu,start,result);
                result.remove(0);
            }
        }
        }
    }
}
