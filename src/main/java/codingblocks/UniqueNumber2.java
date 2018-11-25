package codingblocks;

import java.util.Scanner;

/**
 * Created by hadoop on 4/10/17.
 */
public class UniqueNumber2 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        Integer line = scanner.nextInt();
       // String split[] = line.split(" ");
        int array [] = new int[line];
        int testcase = 0;
        while(line-->0){
            array[testcase] = scanner.nextInt();
            ans = ans ^ array[testcase];
            testcase++;
        }

        int point = ans & -1*ans;
        int num1=0;
        int num2=0;
        for(int i=0;i<=testcase-1;i++){
            if((array[i] & point) !=0){
                num1 = num1 ^ array[i];
            }
            else if((array[i] & point) ==0){
                num2 = num2 ^ array[i];
            }
            else {
                System.out.println("problem cant happen"+array[i]);
                continue;
            }
        }
        if(num1<num2) {
            System.out.print(num1 + " ");
            System.out.print(num2);
        }
        else {
            System.out.print(num2 + " ");
            System.out.print(num1);
        }
    }
}
