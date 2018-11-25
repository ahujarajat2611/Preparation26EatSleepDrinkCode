package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 9/12/17.
 */
public class TurnDp {
    /*
        #include <iostream>
    #include <algorithm>
    #include <string.h>

    using namespace std;

    const int NN = 1000;
    #define INF 999999

    int dp[NN][NN] = {0}, price[NN] = {2,3,5,1,4};;

    int maxPrice(int publish,int end,int N){

        //Initialize the dp array
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++)
                dp[i][j] = 0;
        }

        //Outer loop denotes the starting index for our solution
        for(int i = N-1;i>=0;i--){
            //Inner loop denotes the ending index
            for(int j = 0;j<N;j++){
                //if (publish > end), return 0
                if(i > j)
                    dp[i][j] = 0;
                else{
                    //find the current multiplier
                    int multiplier = N - (j - i);
                    //using bottom up dp to solve the problem for smaller sub problems
                    //and using it to solve the larger problem i.e. dp[i][j]
                    dp[i][j] = max(multiplier * price[i] + dp[i+1][j], multiplier * price[j] + dp[i][j-1]);
                }
            }
        }
        //return the final answer where starting index is publish = 0 and ending index is end = n-1
        return dp[0][N-1];
    }

    int main() {
        int N = 5;
        cout<<maxPrice(0,N-1,N);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
       // return 0;
}
  //   */
//}
