package codingblocks;

import java.util.*;

/**
 * Created by hadoop on 5/10/17.
 */
public class Prime {
    static Set<Integer> getprimes(int n){
        Set<Integer> list = new HashSet<>();
        for(int i=2;i<=n;i++){
            list.add(i);
        }
        for(int i=2;i*i<=n;i++){
            for(int j=i*i;j<=n;j=j+i){
                if(list.contains(j)){
                    list.remove(j);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        Object[] array = getprimes(x).toArray();
        int []primearray = new int[array.length];
        int i=0;
        for(int prime :getprimes(x)){
            primearray[i] = prime;
            i++;
        }
        int minprime = mincount(primearray,x);
        System.out.print(minprime);
    }

    private static int mincount(int[] primearray, int x) {
        int []dp = new  int[x+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<primearray.length;i++){
            for(int j=primearray[i];j<=x;j++){
                if(primearray[i]<=j && dp[j-primearray[i]]!=Integer.MAX_VALUE && dp[j]>dp[j-primearray[i]]+1){
                    dp[j] = dp[j-primearray[i]]+1;
                }
            }
        }
        return dp[x];
    }
}