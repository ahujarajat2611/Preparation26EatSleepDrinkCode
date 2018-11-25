package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        boolean isNegative = (dividend > 0 && divisor < 0) ||
                (dividend < 0 && divisor > 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        if (a < b)
            return 0;
        long ans = 0;
        while (a >= b) {
            int shift = 0;
            while ((b << shift) <= a) {
                System.out.println("shift "+shift);
                shift++;
            }

            ans += ((long)1 << (shift - 1));
            System.out.println("ans "+ans);
            a = a - (b << (shift - 1));
            System.out.println("a "+a);
        }
        if (!isNegative && ans > (long)Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return isNegative ? (int)-ans : (int)ans;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.divide(30,4));
        System.out.println(divide.divideMine(30,4));
    }

    int divideMine(int dividend,int divisor){
        int ans = 0;

        while (divisor<=dividend){
            int temp = divisor;
            int shift =1;
            while (temp<=dividend){
                temp = temp<<1;
                shift= shift<<1;
            }
            temp = temp>>1;
            shift = shift>>1;
            dividend = dividend-temp;
            ans = ans+shift;
        }
        return ans;
    }


}
