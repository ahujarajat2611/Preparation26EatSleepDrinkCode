package DSA.Mathematical;

/**
 * We define the Perfect Number is a
 * positive integer that is equal to the sum
 * of all its positive divisors except
 * itself. Now, given an integer n,
 * write a function that returns true when it is a perfect number and false when it is
 * not. Example: Input: 28 Output:
 * True Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 
 */
public class PerfectNumber {

    // Time : O(sqrt(n))
    public boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != 1 && i * i != n) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        PerfectNumber obj = new PerfectNumber();
        boolean result = false;
        result = obj.isPerfectNumber(28);
        System.out.println(result);

    }
    public boolean checkPerfectNumber(int num) {
        if( num ==1 ){
            return false;
        }
        int maxFactor = (int)Math.sqrt(num);
        int sum =0;
        for(int i=2;i<=maxFactor;i++){
            if(num%i ==0){
                if (i != num / i) sum += num / i;
                sum += i;
            }
        }
        sum= sum +1;
        if(sum == num){
            return true;
        }
        return false;
    }


}
