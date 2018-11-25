package zrzahid;

import java.util.*;

/**
 * Created by hadoop on 6/9/17.
 */

// when we use BFS, we need something to tell that node has been visited ,
    // once node is visited once , it wud have shortest distance ......
public class IsNavigable {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("DOG");
        dictionary.add("COT");
        dictionary.add("COG");
        dictionary.add("FOG");
        dictionary.add("DOT");
        String src = "FOG";
        String dest = "COT";
            boolean ans = isNavigable(src,dest,dictionary);
    }

    private static boolean isNavigable(String src, String dest, Set<String> dictionary) {
        if(src.length()!=dest.length()){
            return false;
        }
        if(src.equals(dest)){
            return true;
        }
        dictionary.remove(src);

        final LinkedList<String> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()){
            String intermediate = queue.poll();
            for( int i=0;i<intermediate.length();i++){
                    char []array = intermediate.toCharArray();
                for(char j='A';j<='Z';j++){
                    array[i] =j;
                    String candidate = new String (array);
                    if(candidate.equals(dest)){
                        return true;
                    }
                    else if (dictionary.contains(candidate)){
                        dictionary.remove(candidate);
                        queue.add(candidate);
                    }
                }
            }
        }
        return false;

    }
    public static List<List<String>> wordLadderAll(String src, String dest, Set<String> dictionary){
        if(src == null|| dest == null){
            return Collections.emptyList();
        }//queue datastructure requeired in BFS
        LinkedList<String> queue = new LinkedList<>();
//path from a node to its parent , we often use this technieque
        Map<String,String> parent = new HashMap<>();
        //level of word appeared in the dag // shorteest path
        Map<String,Integer> shortestPath = new HashMap<>();

        Set<String> reachedLeafPath = new HashSet<>();
        List<List<String>> paths = new ArrayList<>();

        int minPath = Integer.MIN_VALUE;
        queue.add(src);
        shortestPath.put(src,0);

        while (!queue.isEmpty()){
            String intermedite = queue.poll();
            // if reached Ans and here ans length more than
            if(shortestPath.get(intermedite)>minPath){
                continue;
            }

            for(int i=0;i<intermedite.length();i++){
                char [] candidate = intermedite.toCharArray();
                for( char j='A';j<='Z';j++){
                    candidate[i] =j;
                    String candidatestring = new String(candidate);

                    if(shortestPath.get(candidatestring) == null){
                        shortestPath.put(candidatestring,shortestPath.get(intermedite)+1);
                    }

                    if(shortestPath.get(intermedite)+1>shortestPath.get(candidatestring)){
                        continue;
                    }

                    if(candidate.equals(src)){
                        reachedLeafPath.add(intermedite);
                        minPath = Math.min(minPath,shortestPath.get(intermedite)+1);
                    }
                    else if(dictionary.contains(candidatestring)){
                        parent.put(candidatestring,intermedite);
                        shortestPath.put(candidatestring,shortestPath.get(intermedite)+1);
                        queue.add(candidatestring);
                    }
                }

            }

        }

    List<List<String>> allpaths = new ArrayList<>();
    for(String set:reachedLeafPath){
            allpaths.add(getPath(parent,set,src,dest));
    }
    return allpaths;

    }
    private static List<String> getPath (Map<String,String> parentMap,String leaf,String src,String dest){
        List<String> path = new LinkedList<>();
        String node = leaf;
        path.add(0,dest);
        path.add(0,leaf);
        while (parentMap.get(node)!=null && parentMap.get(node)!=src){
            node = parentMap.get(node);
            path.add(0,node);
        }
        path.add(0,src);
        return path;
    }

}
