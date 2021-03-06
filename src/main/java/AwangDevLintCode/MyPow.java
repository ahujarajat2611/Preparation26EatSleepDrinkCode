package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class MyPow {
    public double myPow(double x, int n) {
        // Write your code here
        if(n == 0){
            return 1;
        }

        if(x == 0){
            return 0;
        }

        if(n > 0){
            return power(x, n);
        }else{
            return 1 / power(x, -n);
        }
    }

    private double power(double x, int n){
        if(n == 1){
            return x;
        }

        double v = power(x, n / 2);
        if(n % 2 == 0){
            return v * v;
        }else{
            return v * v * x;
        }
    }
    public int fastPower(int a, int b, int n) {
        // write your code here
        // handle 0 and 1 acase of
        if(n ==1){
            return a%b;
        }
        if(n ==0){
            return 1;
        }
        // what ever we get after one side of recursiion
        // two side of recusion is not requtred
        // devide and repeast result
        int x = fastPower(a,b,n/2);

        // repeat the usage of x  and mode
        int ans = ((x%b)*(x%b))%b;

        // if we have lsot one n becaude n/2 3/2 ... then add one more a
        if((n & 1) ==1){
            // very nicely done
            ans = ((ans%b)*(a%b))%b;
        }

        return ans;
    }
}

