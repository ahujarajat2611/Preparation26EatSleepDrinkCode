package DSA.graph;

import java.util.*;

/**
 * Created by hadoop on 21/10/17.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        // add nodes
        HashMap<Character,Integer> indegreeMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(!graph.containsKey(words[i].charAt(j))){
                    graph.put(words[i].charAt(j),new HashSet<>());
                    indegreeMap.put(words[i].charAt(j),0);
                }
            }
        }
        //System.out.println(indegreeMap);
        // add edges and indegree
        for(int i=1;i<words.length;i++){
            addEdges(words[i-1],words[i],graph,indegreeMap);
        }
//        08041116706
        // 89249488

        java.util.Queue<Character> queue = new LinkedList();
        for(Character c:graph.keySet()){
            if(indegreeMap.get(c) == 0){
                queue.add(c);
            }
        }
        System.out.println(indegreeMap);
        System.out.println(queue);
        System.out.println(graph);
        List<Character> topsort = new LinkedList<>();
        while (!queue.isEmpty()){
            Character polled = queue.poll();
            topsort.add(polled);
            for(Character v:graph.get(polled)){
                Integer indegree = indegreeMap.get(v);
                indegree = indegree-1;
                if(indegree == 0){
                    queue.add(v);
                }
                else {
                   // System.out.println("else");
                   // System.out.println(indegree);
                    indegreeMap.put(v,indegree);
                }
            }
        }
       // System.out.println(topsort);

        String ans = "";
        if(topsort.size() !=indegreeMap.size()){
            return ans;
        }
        for(Character c:topsort){
            ans = ans+c;
        }
        return ans;
    }

    private void addEdges(String word, String word1, HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> indegreeMap) {
        for(int i=0;i<Math.min(word.length(),word1.length());i++) {
            // need a check so that i dont end twice one edge
            if (word.charAt(i) != word1.charAt(i)) {
                // if i have not added that edge twice /// very imp !!!
                if (!graph.get(word.charAt(i)).contains(word1.charAt(i))) {
                    //    System.out.println("here");
                    graph.get(word.charAt(i)).add(word1.charAt(i));
                    //   System.out.println(indegreeMap.get(word1.charAt(i))+1);
                    indegreeMap.put(word1.charAt(i), indegreeMap.get(word1.charAt(i)) + 1);
                    //  System.out.println(indegreeMap);
                    //  System.out.println(word + "--->" + word1);
                    System.out.println("enter " + word.charAt(i) + "--->" + word1.charAt(i));
                }
                break;
            }
        }
    }


    /*

    enter t--->f
enter w--->e
enter r--->t
enter e--->r
enter f--->e


enter t--->f
enter w--->e
enter r--->t
enter e--->r
     */
    public static void main(String []args){
        String words []={
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        String words1 []={"wrt","wrf","er","ett","rftt","te"};
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.alienOrder(words1));
    }
}