package codingblocks;

import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class EvalFunc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test =sc.nextInt();
        int ans = Double.valueOf(4*power(test,3)+5*power(test,2)-6*test+14).intValue();
        System.out.println(ans);
    }
    static int power(int x,int n){

        if(n ==1){
            return x;
        }
        if( n ==0){
            return 1;
        }
        int mid = power(x,n/2);
        if((mid & 1 )==1){
            return  mid * mid *x;
        }
        else
            return mid*mid;
    }
    static int powerhelper(int x,int n){
        if(x<0){
            if((n & 1) ==0){
                return power(-1*x,n);
            }
            else {
                return -1*power(-1*x,n);
            }
        }
        return power(x,n);
    }
}
