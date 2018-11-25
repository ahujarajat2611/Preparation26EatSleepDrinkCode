package PracticeOneWeek26;

/**
 * Created by hadoop on 10/12/17.
 */
public class Ugly {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], primes[j] * res[index[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (res[i] == primes[j] * res[index[j]]) {
                    index[j]++;
                }
            }
        }
        return res[n - 1];
    }
    public int nthSuperUglyNumberAgain(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], primes[j] * res[index[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (res[i] == primes[j] * res[index[j]]) {
                    index[j]++;
                }
            }
        }
        return res[n - 1];
    }
    public int nthUglyNumberSimple3(int n) {
        if (n <= 1) {
            return n;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2=0, index3=0, index5=0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(factor2, factor3), factor5);
            if (ugly[i] == factor2) {
                factor2 = factor2 * ugly[++index2];
            }
            if (ugly[i] == factor3) {
                factor3 = factor3 * ugly[++index3];
            }
            if (ugly[i] == factor5) {
                factor5 = factor5 * ugly[++index5];
            }
        }
        return ugly[n-1];
    }
}
