package codingblocks;

import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int fact = sc.nextInt();
        int []array = new int[40];
        array[0] =1;
        int n =1;
        for(int i=2;i<=fact;i++){
                n = multiply(array,i,n);
        }
        for (int i=0;i<n;i++){
            System.out.print(array[n-1-i]);
        }
    }

    private static int multiply(int[] array, int i, int n) {
        int carry = 0;
        int index = 0;
        while (index<n){
            int multiply = array[index]*i+carry;
            array[index] = multiply%10;
            carry = multiply/10;
            index++;
        }
        while (carry>0){
            array[index]=carry%10;
            carry = carry/10;
            index++;
        }
        return index;
    }
}
