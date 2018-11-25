package BasicAlgorithms.Graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Queue;

public class _444 {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        List<Integer> oriList = IntStream.of(org).boxed().collect(Collectors.toList());
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] seq : seqs)
            for (int i : seq)
                inDegree.put(i, 0);
        if (!inDegree.keySet().equals(new HashSet<>(oriList))) return false;

        for (int[] seq : seqs)
            for (int i = 1; i < seq.length; i++) {
                int u = seq[i - 1], v = seq[i];
                g.putIfAbsent(u, new ArrayList<>());
                g.get(u).add(v);
                inDegree.put(v, inDegree.get(v) + 1);
            }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        List<Integer> actualList = new ArrayList<>(oriList.size());
        for (int u : inDegree.keySet())
            if (inDegree.get(u) == 0) queue.add(u);
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int u = queue.poll();
            actualList.add(u);
            if (g.containsKey(u))
                for (int v : g.get(u))
                    if (inDegree.put(v, inDegree.get(v) - 1) == 1) queue.add(v);
        }
        return oriList.equals(actualList);
    }
    /*
     public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                if (!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            } else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    if (!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }

                    if (!map.containsKey(seq.get(i + 1))) {
                        map.put(seq.get(i + 1), new HashSet<>());
                        indegree.put(seq.get(i + 1), 0);
                    }

                    if (map.get(seq.get(i)).add(seq.get(i + 1))) {
                        indegree.put(seq.get(i + 1), indegree.get(seq.get(i + 1)) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int curr = queue.poll();
            if (index == org.length || curr != org[index++]) {
                return false;
            }
            for (int next : map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == org.length && index == map.size();
    }
     */
}