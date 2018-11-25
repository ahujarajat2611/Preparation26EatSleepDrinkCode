package PracticeOneWeek26;

/**
 * Created by hadoop on 9/12/17.
 */
public class NumberOfTrees {
    public int numTrees(int n) {
        if(n <=1){
            return 1;
        }
        int []count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        for(int end = 2;end<n+1;end++){
            for(int i=1;i<=end;i++){
                count[end]+= count[end-i]*count[i-1];
            }
        }
        return count[n];
    }

    public static void main(String[] args) {
        NumberOfTrees numberOfTrees = new NumberOfTrees();
        System.out.println(numberOfTrees.numTrees(4));
        System.out.println(numberOfTrees.numTreesAgain(4));

    }
    public int numTreesAgain(int n) {
        if(n <=1){
            return 1;
        }
        int []count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        for(int end = 2;end<=n;end++){
            for(int i=0;i<end;i++){
                count[end]+= count[end-i-1]*count[i];
            }
        }
        return count[n];
    }
}