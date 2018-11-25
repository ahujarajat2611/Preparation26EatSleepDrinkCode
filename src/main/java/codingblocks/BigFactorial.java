package codingblocks;

/**
 * Created by hadoop on 30/9/17.
 */
public class BigFactorial {

    void big_factorial(int number){
        int a[] = new int[100];
        a[0] = 1;
        int n = 1; // denotes index before we which we have processed things
        for(int i=2;i<=number;i++){
            n = multiply(a,n,i);
            System.out.println(n);
        }
        System.out.println("ans");
        for(int i=n-1;i>=0;i--){
            System.out.print(a[i]);
        }
    }

    private int multiply(int[] a, int n, int no) {
        int carry = 0;
        for(int i=0;i<n;i++){
            int product = a[i]*no +carry;
            a[i] = product%10;
            carry = product/10;
        }
        while (carry!=0){
            a[n] = carry%10;
            carry= carry/10;
            n++;
        }
        return n;
    }
    public static void main(String args[]){
        BigFactorial bigFactorial = new BigFactorial();
        bigFactorial.big_factorial(10);
    }
}

/*

Made with by


Made with by

#include <iostream>
using namespace std;

void multiply(int *a,int &n,int no){

    // array 1 2 3 0 0 0 0 by number 4
    int carry = 0;

    for(int i=0;i<n;i++){

        int product = a[i]*no + carry;
        a[i] = product%10;
        carry = product/10;
    }

    //Left out carry
    while(carry){
        a[n] = carry%10;
        carry = carry/10;
        n++;
    }


}


void big_factorial(int number){

    //Assuming that ans contains at max 1000 digits, all positions are 0 initially
    int *a = new int[1000]{0};

    a[0] = 1;
    int n = 1; // which denotes the index of the array, before which we have stored some digits

    for(int i=2;i<=number;i++){
        multiply(a,n,i);
    }

    //Print the digits in the reverse order

    for(int i=n-1;i>=0;i--){
        cout<<a[i];
    }
    cout<<endl;
    cout<<n<<" digits "<<endl;
    cout<<endl;

}

int main() {
    big_factorial(100);

}

 */
/*
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
 */