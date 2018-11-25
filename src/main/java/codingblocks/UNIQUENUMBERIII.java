package codingblocks;

import java.util.Scanner;

/**
 * Created by hadoop on 4/10/17.
 */
public class UNIQUENUMBERIII {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int array[] =new int[32];
        while (testcase -->0){
            int number = sc.nextInt();
            int index = 0;
            while (number>0){
                int bit = number&1;
                array[index] += bit;
                number = number/2;
                index++;
            }
        }
        int ans = 0;
        int base = 2;
        for(int i=31;i>=0;i--){
            array[i] = array[i]%3;
            ans = ans*base +array[i];
        }
        System.out.println(ans);
    }
}
