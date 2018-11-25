package BasicAlgorithms.Math;

/**
 * @author Baofeng Xue at 2016/4/3 16:59.
 */
public class PrintFactors {

    public static void main(String[] args) {
        printFactors(12, "", 12);
      //  printFactors(24, "", 24);
       // printFactors(30, "", 30);
    }

    public static void printFactors(int product, String carryString, int minFactor) {
        for (int factor1 = product / 2; factor1 >= 2; factor1--) {

            if (product % factor1 != 0) {
                continue;
            }

            if (factor1 > minFactor) {
                continue;
            }

            int factor2 = product / factor1;

            if (factor2 <= minFactor && factor1 <= minFactor && factor2 <= factor1) {
                System.out.println(carryString + factor1 + "*" + factor2);
            }

            printFactors(factor2, carryString + factor1 + "*", Math.min(factor2, factor1));
        }
    }
}