package OldAttemptLearning.VideoLectures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 28/8/17.
 */
public class Backtrack {

    public static List<List<Object>> backtrack(int []A){
         List<List<Object>> result = new LinkedList<List<Object>>();
        if(A == null || A.length ==0){
            return result;
        }

        List<Object> solution = new LinkedList<Object>();

        dfs(result,solution,A,0);
        return result;
    }

    private static void dfs(List<List<Object>> result, List<Object> solution, int[] A, int pos) {

        if(isASolution(A,pos)){
            processSolution(result,solution);
        }
        for(int i=pos;i<A.length;i++){
            if(!isValid(A,i)){
                continue;
            }

            makemove(solution,A[i]);
            dfs(result,solution,A,i+1);
            unmakemove(solution,A[i]);
        }
    }

    private static void unmakemove(List<Object> solution, int i) {
        solution.remove(solution.size()-1);
    }

    private static void makemove(List<Object> solution, int i) {
        solution.add(i);
    }

    private static boolean isValid(int[] a, int i) {
        // check if I th position is valid
        // return true;
        return true;
    }

    private static void processSolution(List<List<Object>> result, List<Object> solution) {
        result.add(solution);
    }

    private static boolean isASolution(int[] a, int pos) {
        if(pos ==a.length){
            return true;
        }
        return false;
    }


}
