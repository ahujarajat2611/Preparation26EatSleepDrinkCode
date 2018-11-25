package OldAttemptLearning.dp;

/**
 * Created by hadoop on 12/8/17.
 */
public class Consecutiveone {
    public static void main(String args[]){
        int n = 3;
        int ans = consone(n,0);
        System.out.println("ans"+ans);
        System.out.println(" again ans simpler "+ans(3));
        countstrings(3,"",0);
    }
    static int ans(int n){
        int endingAt0[] = new int[n];
        int endingAt1[] = new int[n];

        endingAt0[0] = 1;
        endingAt1[0] = 1;

        for(int i=1;i<n;i++){
            endingAt1[i] = endingAt0[i-1];
            endingAt0[i] = endingAt1[i-1]+endingAt0[i-1];
        }
        return endingAt0[n-1]+endingAt1[n-1];
    }

    private static int consone(int n, int last_digit) {
        if(n==0){
            return 0;
        }
        if(n==1){
            if(last_digit == 1){
                return 1;
            }
            else {
                return 2;
            }
        }
        if(last_digit == 1){
            return consone(n-1,0);
        }
        else{
            return consone(n-1,0)+consone(n-1,1);
        }
    }
    public static int bottomup(int n){
        int t[][] = new int[n+1][2];
        t[0][0] = 0;
        t[0][1] = 0;
        t[1][0] = 2;
        t[1][1] = 1;
        for(int i=2;i<=n;i++){
            t[i][1] = t[i-1][0];
            t[i][0] = t[i-1][0]+t[i-1][1];
        }
        return t[n][0];
    }

    public static void countstrings(int n , String s,int last_digit){
        if(n==0){
            System.out.println("string "+s);
            return;
        }
        countstrings(n-1,s+"0",0);
        if(last_digit ==0){
            countstrings(n-1,s+"1",1);
        }
    }
}
