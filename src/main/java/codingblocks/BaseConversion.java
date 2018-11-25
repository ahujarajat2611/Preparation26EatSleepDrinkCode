package codingblocks;

import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class BaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base1 = sc.nextInt();
        int base2 = sc.nextInt();
        String num = sc.next();
        int numbase1=0;
        for(int i=0;i<num.toCharArray().length;i++){
            numbase1 = numbase1*base1+(num.charAt(i)-'0');
        }
        String numbase2="";
        while (numbase1>0){
            numbase2 = numbase1%base2+numbase2;
            numbase1 = numbase1/base2;
        }
        System.out.println(numbase2);
    }
}
