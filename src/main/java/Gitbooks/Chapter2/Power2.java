package Gitbooks.Chapter2;

/**
 * Created by hadoop on 15/9/17.
 */
public class Power2 {
    public static void main(String[] args) {
        int x = 5;
        int n = 10;
        double a = 34.00515;
        int b=        -3;
        Power2 power2 = new Power2();
        System.out.println(power2.myPow(a,b));
        // 5^10 = 5^5 * 5^5 => 5^5 => 5^2 * 5 5^2 >=>5 ^2 => s
    }

    int power(int x,int n) {
        int power = n;
        int ans = 1;
        while (power >= 1) {
            if ((power & 1) == 1) {
                ans = ans * x;
            }
            ans = ans * ans;
            power = power>>1;
        }
        return ans;
    }
    public double myPow(double x, int n) {
        double ans = x;
        boolean isnegative = false;
        if(n<0){
            isnegative = true;
            n = n*-1;
        }
        int power = n;


        while (power > 1) {
            if ((power & 1) == 1) {
                System.out.println("here ans1"+ans);
                ans = !isnegative?ans * x:(double)((ans)*(double)(1/x));
                System.out.println("here ans2"+ans);

            }
            if(power == 1){
                return ans;
            }
            System.out.println("here ans3"+ans);

            ans = !isnegative?ans * ans:(double)(1/(ans*ans));
            System.out.println("here ans4"+ans);

            power = power>>1;
        }
        return ans;

    }

}
