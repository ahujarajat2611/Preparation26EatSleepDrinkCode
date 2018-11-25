package codingblocks;

import java.math.BigInteger;
import java.util.Scanner;

class Julka {
    
   static void compute(BigInteger n,BigInteger k){
       
       BigInteger x,y;

       
       x = n.subtract(k);
       x = x.divide(BigInteger.valueOf(2));
       
       y = x.add(k);
       
       System.out.println(y);
       System.out.println(x);
      
   }

    


    public static void main(String args[]) {
        BigInteger n,k,ans;
        Scanner sc = new Scanner(System.in);
        
        int test = 10;
        while(test>0){
            n = sc.nextBigInteger();
            k = sc.nextBigInteger();
            compute(n,k);
            test = test-1;
        }
        
        
    }
}