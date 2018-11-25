package BasicAlgorithms.MyGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 21/10/17.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        HashMap<Integer,Integer> indegreeMap = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new HashSet<>());
            indegreeMap.put(i,0);
        }
        for(int i=0;i<prerequisites.length;i++){

            // take care of pre-requisite array
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegreeMap.put(prerequisites[i][0],indegreeMap.get(prerequisites[i][0])+1);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int key:indegreeMap.keySet()){
            if(indegreeMap.get(key) == 0){
                queue.add(key);
            }
        }

        LinkedList<Integer> topOrder = new LinkedList<>();
        while (!queue.isEmpty()){
               int polled = queue.poll();
               topOrder.add(polled);
               for(int v:graph.get(polled)){
                   int indegree = indegreeMap.get(v);
                   indegree = indegree-1;
                   if(indegree == 0){
                       queue.add(v);
                       indegreeMap.remove(v);
                   }
                   else {
                       indegreeMap.put(v,indegree);
                   }
               }
        }
        return topOrder.size() == numCourses;
    }
}