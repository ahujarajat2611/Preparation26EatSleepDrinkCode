package OldAttemptLearning.TemplatesCodes;

/**
 * Created by hadoop on 1/9/17.
 */
public class Combinations {
    //return the count Given n distinct positive integers, integer k (k <= n) and a number target. Find k numbers where sum is target. Calculate how many solutions there are?
    public static void main(String[] args) {
        int num[]={4,5,6};
        int k = 1;
        int target = 4;
        int [][][] array = new int[num.length+1][k+1][target];
        int ans = ksum(array,k,target,num);
    }

    private static int ksum(int[][][] array, int k, int target,int []num) {
        for( int i=0;i<=num.length;i++){
            array[i][0][0]=1;
        }
        for(int i=0;i<=num.length;i++){
            for( int j=0;j<=k;j++){
                array[i][j][0] = 0;
            }
        }
        for( int i=1;i<=num.length;i++){
            for ( int j=1;j<=k;j++){
                for ( int l=1;l<=target;l++){
                    if(j>i)array[i][j][l] = 0;
                    if(k-num[i-1]>=0)
                    array[i][j][l] = array[i-1][j][l] +array[i-1][j-1][l-num[i-1]];
                }
            }
        }
        return array[num.length][k][target];
    }
}
