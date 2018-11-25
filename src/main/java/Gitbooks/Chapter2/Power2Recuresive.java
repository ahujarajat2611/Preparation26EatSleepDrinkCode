package Gitbooks.Chapter2;

/**
 * Created by hadoop on 15/9/17.
 */
public class Power2Recuresive {
    public static void main(String[] args) {
        double x= 4.0;
        int n = 2;
        double ans ;
        boolean isNegative = false;
        if(n<0){
            isNegative = true;
            n = -1*n;
        }
        if(x<0 && (n & 1)==1){
            ans = -1*helper(-1*x,n);
        }
        if(x<0 && (n & 1) == 0){
            ans = helper(-1*x,n);
        }
        if(n ==0 || x ==1){
            ans = 1;
        }
        if(isNegative){
          ans = 1/helper(x,n);
        }
        else {
            ans = helper(x,n);
        }

    }

    static double helper(double x,int n){
        //x>0 , n>0
        if(n == 1){
            return x;
        }
        if(n ==0 ){
            return 1;
        }
        double ans = ((n & 1 ) == 1) ? helper(x*x,n/2):helper(x*x,n/2)*x;
        return ans;
    }

    static double power(int x,int n){

        double ans;
        boolean isNegative = false;
        if(n <0){
            n = n*-1;
            isNegative = true;
        }
        if(x<0 && (n & 1)==0){
            ans = helper(x*-1,n);
        }
        if(x<0 && (n & 1) ==1){
            ans = -1 *helper(x*-1,n);
        }
        if(x ==0 || x ==1){
            return x;
        }
        if(n ==0){
            return 1;
        }
        ans = helper(x,n);
        if(isNegative) return (double)(1/ans);
        return ans;
    }
    //i dont wna tot deal with positiive negative of x
    /// let id deal itself i will take care of nnegaiive n only
    public double powagainsimpler(double x,int n){
        if(n ==0){
            return 1;
        }
        if(n<0){
            n = -1 * n;
            x = 1/x;

        }
        double midans = powagainsimpler(x*x,n/2);

        if(n%2 ==0 ){
            return midans ;
        }
        else {
            return midans * x;
        }
    }

}
