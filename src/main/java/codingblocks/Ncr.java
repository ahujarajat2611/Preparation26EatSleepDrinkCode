package codingblocks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class Ncr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cache [][] = new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(cache[i],Integer.MAX_VALUE);
        }
        int value = nckit(n,k);
        System.out.print(value);
    }

    private static int nck(int n, int k,int[][]cache) {
        if(cache[n][k]!=Integer.MAX_VALUE){
            return cache[n][k];
        }
        if(n<k){
            return 0;
        }
        if(n == 0){
            return 0;
        }
        if(k ==0){
            return 1;
        }
        if(n == k){
            return 1;
        }
        if( k ==1){
            return n;
        }
        return cache[n][k]=((nck(n-1,k-1,cache)%1000000007)+ (nck(n-1,k,cache)%1000000007))%1000000007;
    }
    private static int nckit(int n,int k){
        int cache[][] = new int[n+1][k+1];

        for(int j=1;j<=k;j++){
            cache[0][j]=0;
        }
        for(int i=0;i<=n;i++){
            cache[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                cache[i][j] = ((cache[i-1][j]%1000000007)+(cache[i-1][j-1]%1000000007))%1000000007;
            }
        }
        return cache[n][k];
    }
}
