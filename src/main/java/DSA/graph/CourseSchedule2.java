package DSA.graph;

/**
 * Created by hadoop on 17/2/18.
 */
import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return canFinishUsingBfs3(numCourses,prerequisites);
    }
    public  int[] canFinishUsingBfs3(int numCourses, int[][] prereq) {
        int []res = new int[numCourses];
        if (numCourses == 0 ) {
            return res;
        }
//0 to 1
        // store courses that have no prerequisites
        int degree[] = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] a : prereq) {
            if (!map.containsKey(a[1]) || (map.containsKey(a[1]) && !map.get(a[1]).contains(a[0]))) {
                map.compute(a[1], (key, value) -> {
                    if (null == value) {
                        value = new HashSet<>(0);
                    }
                    value.add(a[0]);
                    return value;
                });
                degree[a[0]]++;
            }
        }
        System.out.println(map);
        ConsoleWriter.printIntArray(degree);
        // store courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++)

        {
            if (degree[i] == 0)
                queue.offer(i);
        }

        // number of courses that have no prerequisites
        List<Integer> visited = new LinkedList<>();
        while (!queue.isEmpty())

        {
            int cur = queue.poll();
            visited.add(cur);
            if (map.containsKey(cur)) {
                for (int neighbour : map.get(cur)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        int i=0;
        for(int x:visited){
            res[i++] = x;
        }
// IDEA IS FUCKING SIMPLE
        // IF YOU CAN VISIT ALL NODES THEN DEFINTELEYE YOU CAN COMPLETE ALL COURSES GIVEN
        return visited.size() == numCourses ? res :new int[0];

    }

    public static void main(String[] args) {
        CourseSchedule2 schedule2 = new CourseSchedule2();
        int [][]array = {{0,1}};
        ConsoleWriter.printIntArray(schedule2.findOrder(2,array));
    }
}
