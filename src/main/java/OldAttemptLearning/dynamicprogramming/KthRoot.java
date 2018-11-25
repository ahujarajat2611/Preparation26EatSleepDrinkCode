package OldAttemptLearning.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by hadoop on 4/8/17.
 */
public class KthRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = Integer.parseInt(scanner.nextLine());
        while (testcase>0){
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            //x^k <= n

            long startrange = 1;
            for(long i=1;Math.pow(i,k)<=n;i=i*2){

                startrange = i;
            }
            long endrange = 2*startrange;

            while(startrange < endrange){
                long mid = startrange + (endrange-startrange)/2;

                if(Math.pow(mid,k)>=n){
                    endrange = mid;
                }

                else if (Math.pow(mid,k)<n) {
                    startrange = mid + 1;
                }

            }

            if(Math.pow(startrange,k)<=n) {
                System.out.println(startrange);
            }
            else {
                System.out.println(startrange-1);
            }
            testcase--;
        }

    }
}
