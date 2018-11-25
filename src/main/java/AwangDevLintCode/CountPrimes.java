package AwangDevLintCode;

import java.util.Arrays;

/**
 * Created by hadoop on 3/2/18.
 */
/*
/*
Attempt2: https://leetcode.com/problems/count-primes/ explains it well
1. Ignore 1 and n. Don't count 1 and the number itself in.
2. Assume all numbers are prime in a boolean[]. Check off those are certainly not prime, the remaining will be prime.
3. For any n, only need to check up to i * i < n; more than that,
for example 2 x 6 is same as checking 6x2, but 6x2 is not necessary to check.
4. How to mark things off:
	The first non-prime is always i^2: self * self.
	Then more non-primes:self * self, self * (self + 1), self * (self + 2) ... etc.
	So, mark all of these index of in the boolean[]

*/
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
            // assume all are prime !!!!
        }

        for (int i = 2; i * i< n; i++) {
            if (!primes[i]) {
                continue;
            }

            // we will continue onnlyu for prime numebrs

            for (int j = i * i; j < n; j += i) {
                // false means these are not primses for sure
                primes[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            count += primes[i] ? 1 : 0;
        }
        return count;
    }

    public int countPrimesMine(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] primes = new boolean[n];

        Arrays.fill(primes,true);
        for(int i=2;i*i<=n;i++){
            if(!primes[i]){
                continue;
            }
            for(int j= i*i;j<=n;j+=i){
                primes[j] = false;
            }
        }

        int ans = 0;
        for(int i=2;i<primes.length;i++){
            if(primes[i]){
                ans++;
            }
        }
        return ans;
    }
}
//[1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16]
//i-> 2 to 4
//4 false , 6 ... 16 false
//3*2 would have been covered by 2 * 3
//16