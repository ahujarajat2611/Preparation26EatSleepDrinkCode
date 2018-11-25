package OldAttemptLearning.dynamicprogramming;

/**
 * Created by hadoop on 3/8/17.
 */
public class Climb {
    public static void main(String[] args) {
        int stairs = 5;
        int n = steps(stairs);
        System.out.println("n"+n);
    }

    private static int steps(int stairs) {
        if(stairs ==1){
            return 1;
        }
        if(stairs ==0){
            return 1;
        }
        int totalways = 0;
        totalways = totalways+ steps(stairs-1);
        totalways = totalways + steps(stairs -2);
        return totalways;
    }
}
