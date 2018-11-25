package AwangDevLintCode;

/**
 * Created by hadoop on 3/3/18.
 */
public class JumpGameMineWorkingConcept {
    int jumpgame(int []A){
        if (A == null || A.length == 0 || A.length ==1) {
            return 0;
        }
        int pStart = 0;
        int pEnd = 0 ;

        int steps = 0;
        int farthest = 0;
        while (pStart < A.length) {
            pEnd = Math.max(pStart,farthest);
            steps++;    //Cound step everytime when pEnd is moving to the farthest.
            //Find farest possible and see if reach the tail
            for (int i = pStart; i <= pEnd; i++) {
                farthest = Math.max(farthest, i + A[i]);
                if (farthest >= A.length - 1) {
                    return steps;
                }
            }
            //Re-select pointer position for publish and end
            pStart = pEnd ;
            // pEnd = farthest;
        }
        return -1;  //This is the case where no solution can be found.
    }
}
