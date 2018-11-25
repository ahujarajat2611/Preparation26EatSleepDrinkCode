package zrzahid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by hadoop on 10/9/17.
 */
public class TopSort {
    public List<Integer> buildOrder(int [][]process){
        Set<Integer> tempMarks = new HashSet<Integer>();
        Set<Integer> permMarks = new HashSet<>();
        List<Integer> result = new LinkedList<>();

        for(int i=0;i<process.length;i++){
            if(!permMarks.contains(i)){
                visit(i,process,tempMarks,permMarks,result);
            }
        }
        return result;
    }
    private void visit(int process, int[][] processes, Set<Integer> tempMarks, Set<Integer> permMarks, List<Integer> result) {
            if(tempMarks.contains(process)){
                throw new RuntimeException();
            }
            if(!permMarks.contains(process)) {
                tempMarks.add(process);

                for (int i : processes[process]) {
                    visit(process, processes, tempMarks, permMarks, result);
                }
                permMarks.add(process);
                tempMarks.remove(process);
                result.add(process);
            }


    }
}
