package BasicAlgorithms.Math;

/**
 * Created by hadoop on 25/12/17.
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {

        if(num == 1) {
            return true;
        }
        int maxFactor = (int)Math.sqrt(num);
        int sum =0;
        // Find the max factor
        // loop and see and you can check for divisibilty
        // if yes then addd to sum and also addd its other fatocr as well
        // but but but if they both are equal then addd only 1
        // addd counter as well in this
        // addd its factor as well to the sum and later addd 1 to see if sum gets equal to originla number !!!1
        for(int i=2;i<=maxFactor;i++){
            if(num%i ==0){
                // since it will be duplicate thing since we might end up adding twice
                // for 25 .. 1 + 5 only
                // 64 would have factors 1 + (2 + 32) + (4 + 16 ) + 8 ( adding only once sinnce 64 i do not want to consider )
                if (i != num / i) sum += num / i;
                sum += i;
            }
        }
        // add 1 in the last to addd all factors apart from
        sum = sum+1;
        System.out.println(sum);
        if(sum == num){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();
        System.out.println(perfectNumber.checkPerfectNumber(28));
    }
}