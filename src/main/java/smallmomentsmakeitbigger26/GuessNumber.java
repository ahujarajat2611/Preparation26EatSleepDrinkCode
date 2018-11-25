package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class GuessNumber {
    public class Solution {
        public int getMoneyAmount(int n) {
            int[][] table = new int[n+1][n+1];
            return DP(table, 1, n);
        }

        int DP(int[][] t, int s, int e){
            if(s >= e) return 0;
            if(t[s][e] != 0) return t[s][e];
            int res = Integer.MAX_VALUE;
            for(int x=s; x<=e; x++){
                int tmp = x + Math.max(DP(t, s, x-1), DP(t, x+1, e));
                res = Math.min(res, tmp);
            }
            t[s][e] = res;
            return res;
        }
    }
}
/*
For each number x in range[i~j]
we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
--> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
then we get DP([i~j]) = min{xi, ... ,xj}
--> // this min makes sure that you are minimizing your cost.
 */
