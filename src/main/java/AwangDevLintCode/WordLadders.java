package AwangDevLintCode;

import java.util.*;
/**
 * Created by hadoop on 16/10/17.
 */
public class WordLadders {

    // Here trick is to find all possible shortest Paths
    // not just pne that's why we have list in the map instead of just parent map

    Map<String, List<String>> map;
    List<List<String>> results;

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        results = new ArrayList<>();
        if (dict.size() == 0) {
            return results;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        map = new HashMap<>();
        Map<String, Integer> ladder = new HashMap<>();
        for (String string : dict) {
            ladder.put(string, Integer.MAX_VALUE);
        }
        ladder.put(start, 0);
        // very imp dict step
        dict.add(end);
        Integer min = Integer.MAX_VALUE;
        // BFS DIJKSTTA
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if (step > min) {
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char a = 'a'; a <= 'z'; a++) {
                    sb.setCharAt(i, a);
                    String newword = sb.toString();
                    if (ladder.containsKey(newword)) {
                        int dis = ladder.get(newword);
                        if (dis < step) {
                            continue;
                            // case when
                        } else if (dis > step) {
                            ladder.put(newword, step);
                            queue.add(newword);
                        } else {
                            // do nothing just update path as we are going down
                        }

                        // Adding only smallest equal path // avioded longes path
                        //with continue written above
                        if (map.containsKey(newword)) {
                            map.get(newword).add(word);
                        } else {
                            map.put(newword, new LinkedList<>(Arrays.asList(new String[]{word})));
                        }

                        if (newword.equals(end)) {
                            min = step;
                        }

                    }
                }
            }
        }
        LinkedList<String> result = new LinkedList<>();
        //result.add(end);
        backTrace(end, start, result);
        return results;

    }

    private void backTrace(String end, String start, LinkedList<String> result) {
        if (end.equals(start)) {
            result.add(0, start);
            results.add(new ArrayList<>(result));
            result.remove(0);
            return;
        } else {
            if (map.get(end) != null) {
                for (String recu : map.get(end)) {
                    result.add(0, recu);
                    backTrace(recu, start, result);
                    result.remove(0);
                }
            }
        }

    }


    /**
     * Created by hadoop on 6/9/17.
     */

// when we use BFS, we need something to tell that node has been visited ,
// once node is visited once , it wud have shortest distance ......
//public class IsNavigable {
//    public static void main(String[] args) {
//        Set<String> dictionary = new HashSet<>();
//        dictionary.add("DOG");
//        dictionary.add("COT");
//        dictionary.add("COG");
//        dictionary.add("FOG");
//        dictionary.add("DOT");
//        String src = "FOG";
//        String dest = "COT";
//        boolean ans = isNavigable(src,dest,dictionary);
//    }
    private static boolean isNavigable(String src, String dest, Set<String> dictionary) {
        if (src.length() != dest.length()) {
            return false;
        }
        if (src.equals(dest)) {
            return true;
        }
        dictionary.remove(src);

        final LinkedList<String> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            String intermediate = queue.poll();
            for (int i = 0; i < intermediate.length(); i++) {
                char[] array = intermediate.toCharArray();
                for (char j = 'A'; j <= 'Z'; j++) {
                    array[i] = j;
                    String candidate = new String(array);
                    if (candidate.equals(dest)) {
                        return true;
                    } else if (dictionary.contains(candidate)) {
                        dictionary.remove(candidate);
                        queue.add(candidate);
                    }
                }
            }
        }
        return false;

    }

    public static List<List<String>> wordLadderAll(String src, String dest, Set<String> dictionary) {
        if (src == null || dest == null) {
            return Collections.emptyList();
        }//queue datastructure requeired in BFS
        LinkedList<String> queue = new LinkedList<>();
//path from a node to its parent , we often use this technieque
        Map<String, String> parent = new HashMap<>();
        //level of word appeared in the dag // shorteest path
        Map<String, Integer> shortestPath = new HashMap<>();

        Set<String> reachedLeafPath = new HashSet<>();
        List<List<String>> paths = new ArrayList<>();

        int minPath = Integer.MIN_VALUE;
        queue.add(src);
        shortestPath.put(src, 0);

        while (!queue.isEmpty()) {
            String intermedite = queue.poll();
            // if reached Ans and here ans length more than
            if (shortestPath.get(intermedite) > minPath) {
                continue;
            }

            for (int i = 0; i < intermedite.length(); i++) {
                char[] candidate = intermedite.toCharArray();
                for (char j = 'A'; j <= 'Z'; j++) {
                    candidate[i] = j;
                    String candidatestring = new String(candidate);

                    if (shortestPath.get(candidatestring) == null) {
                        shortestPath.put(candidatestring, shortestPath.get(intermedite) + 1);
                    }

                    if (shortestPath.get(intermedite) + 1 > shortestPath.get(candidatestring)) {
                        continue;
                    }

                    if (candidate.equals(src)) {
                        reachedLeafPath.add(intermedite);
                        minPath = Math.min(minPath, shortestPath.get(intermedite) + 1);
                    } else if (dictionary.contains(candidatestring)) {
                        parent.put(candidatestring, intermedite);
                        shortestPath.put(candidatestring, shortestPath.get(intermedite) + 1);
                        queue.add(candidatestring);
                    }
                }

            }

        }

        List<List<String>> allpaths = new ArrayList<>();
        for (String set : reachedLeafPath) {
            allpaths.add(getPath(parent, set, src, dest));
        }
        return allpaths;

    }

    private static List<String> getPath(Map<String, String> parentMap, String leaf, String src, String dest) {
        List<String> path = new LinkedList<>();
        String node = leaf;
        path.add(0, dest);
        path.add(0, leaf);
        while (parentMap.get(node) != null && parentMap.get(node) != src) {
            node = parentMap.get(node);
            path.add(0, node);
        }
        path.add(0, src);
        return path;
    }










    /*


    WATTA SOLUTION
     */

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> rst = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> pastMap = new HashMap<String, ArrayList<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();

        //Initiate the variables
        dict.add(start);
        dict.add(end);
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            pastMap.put(s, new ArrayList<String>());
        }

        //BFS
        BFS(start, end, distance, pastMap, dict, queue);

        //DFS
        ArrayList<String> path = new ArrayList<String>();
        DFS(start, end, distance, pastMap, path, rst);

        return rst;
    }
    //BFS to populate map and distance:
    //Distance: distance from each str in dict, to the starting point.
    //Map: all possible ways to mutate into each str in dict.
    public void BFS(String start, String end, Map<String, Integer> distance, Map<String, ArrayList<String>> pastMap, Set<String> dict, Queue<String> queue) {
        while(!queue.isEmpty()) {
            String str = queue.poll();
            List<String> list = expand(str, dict);

            for (String s : list) {
                pastMap.get(s).add(str);
                if (!distance.containsKey(s)) {
                    distance.put(s, distance.get(str) + 1);
                    queue.offer(s);
                }
            }
        }
    }
    //DFS on the map, where map is the all possible ways to mutate into a particular str. Backtracking from end to publish
    public void DFS(String start, String str, Map<String, Integer> distance, Map<String, ArrayList<String>> pastMap, ArrayList<String> path, List<List<String>> rst) {
        path.add(str);
        if (str.equals(start)) {
            Collections.reverse(path);
            rst.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {//next step, trace 1 step towards publish
            for (String s : pastMap.get(str)) {//All previous-mutation options that we have with str:
                if (distance.containsKey(s) && distance.get(str) == distance.get(s) + 1) {//Only pick those that's 1 step away: keep minimum steps for optimal solution
                    DFS(start, s, distance, pastMap, path, rst);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    //Populate all possible mutations for particular str, skipping the case that mutates back to itself.
    public ArrayList<String> expand(String str, Set<String> dict) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {//Alternate each letter position
            for (int j = 0; j < 26; j++) {//Alter 26 letters
                if (str.charAt(i) != (char)('a' + j)) {
                    String newStr = str.substring(0, i) + (char)('a' + j) + str.substring(i + 1);
                    if (dict.contains(newStr)) {
                        list.add(newStr);
                    }
                }
            }
        }
        return list;
    }
}

