package DSA.graph;

/**
 * Created by hadoop on 17/2/18.
 */
import java.util.*;
public class WorkingAlienDictionary {
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree = new HashMap<Character, Integer>();
        String result = "";
        if (words == null || words.length == 0) return result;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<Character>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                        System.out.println("enter "+ c1+"--->"+c2);
                    }
                    break;
                }
            }
        }
        System.out.println(degree);
        System.out.println(map);
        Queue<Character> q = new LinkedList<Character>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) q.add(c);
        }
        System.out.println(q);
        while (!q.isEmpty()) {
            char c = q.remove();
            result += c;
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) q.add(c2);
                }
            }
        }
        System.out.println(result);
        if (result.length() != degree.size()) return "";
        return result;
    }
    public static void main(String []args){
        String words []={
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        String words1 []={"wrt","wrf","er","ett","rftt","te"};
        WorkingAlienDictionary alienDictionary = new WorkingAlienDictionary();
        System.out.println(alienDictionary.alienOrder(words1));
    }
}
/*
{r=[t], t=[f], e=[r], f=[e], w=[e]}

{r=[t], t=[f], e=[r], w=[e]}
 */