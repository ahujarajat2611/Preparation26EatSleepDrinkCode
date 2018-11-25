package OldAttemptLearning.shirleyisnotageek;

import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 */
/*

This is a very complicated problem, but it's not as hard as you thought.
 The key idea is to do a topological sort.
 However, the harder part is to create the graph.
  The idea is to compare to adjacent strings until we
  find the first different character.
   The char in the prior string should be the "from"
    part in the edge and the char in the later string should be the "to"part.

About topological sort, there are two ways to do so.
 If you use BFS, then you have to find the vertex with indegree 0,
  then publish from that. If you use DFS and a stack,
  you always push the later vertices in to stack first,
  so you can publish with any vertex.
   If there are more than one topological order,
   a different starting point will cause the difference.

Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
For example, Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
Note: You may assume all letters are in lowercase.
 If the order is invalid, return an empty string. There may be multiple valid order of letters, return any one of them is fine.
 */
public class Alien {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }

        Map<Character, Set<Character>> neighbors = new HashMap<>();
        Map<Character, Boolean> visited = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];

            int pos = 0;
            int len = Math.min(first.length(), second.length());


            while (pos < len) {
                char from = first.charAt(pos);
                char to = second.charAt(pos);
                if (!visited.containsKey(from)) {
                    visited.put(from, false);
                }
                if (!visited.containsKey(to)) {
                    visited.put(to, false);
                }
                if (from != to) {
                    if(!neighbors.containsKey(from)) {
                        neighbors.put(from, new HashSet<>());
                    }
                    if (!neighbors.get(from).contains(to)) {
                        neighbors.get(from).add(to);
                    }

                }
                pos++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : neighbors.keySet()) {
            if (!visited.get(c)) {
                if (!visit(c, builder, neighbors, visited)) {
                    return "";
                }
            }
        }
        return builder.toString();
    }

    private boolean visit(char curr, StringBuilder builder, Map<Character, Set<Character>> neighbors, Map<Character, Boolean> visited) {
        if (visited.get(curr)) {
            return false;
        }
        visited.put(curr, true);
        if (neighbors.containsKey(curr)) {
            for (char c : neighbors.get(curr)) {
                if (!visited.get(c)) {
                    if (!visit(c, builder, neighbors, visited)) {
                        return false;
                    }
                }
            }
        }
        builder.insert(0, curr);
        return true;
    }
}
