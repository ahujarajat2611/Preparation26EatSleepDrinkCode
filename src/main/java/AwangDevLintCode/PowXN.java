package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */

/*
	Everytime: if divide the power n by 2, then it equlas to pow(x,n/2) * pow(x, n/2).
	Also consider n could be negative. Let myPow handle the negative n. basically return 1/myPow(x,n)
	Cnsider the case of 0: x^0 = 1.
	use a helper funtion: when n%2 == 0, regular; if n%2 ==1, do pow(x, (n-1)/2) * x.
		Note: n/2 = (n-1)/2. So this can be optmized.
*/
// we will take care of negative cases of n .. x negative cases will get handled itself

public class PowXN {
    public double myPow(double x, int n) {
        if(n >= 0) {
            return pow(x, n);
        } else {
            return 1/pow(x, n);
        }
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double num = pow(x, n/2);
        if (n % 2 == 0) {
            return num * num;
        }
        return num * num * x;
    }
}
