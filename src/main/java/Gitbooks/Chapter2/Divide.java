package Gitbooks.Chapter2;

/**
 * Created by hadoop on 16/9/17.
 */
public class Divide {

    int divide(int dividend,int divisor){
        int a = dividend;
        int b = divisor;

        int result = 0;
        while(a>=b){
            int shift =1;
            int temp = b;
            while(a>temp){
                temp=temp<<1;
                shift= shift<<1;
                System.out.println("shift"+shift);
            }
            if(a == temp ){
                return result + shift;
            }
            shift = shift>>1;
            System.out.println("shift"+shift);

            temp = temp>>1;
            result = result + shift;
            a= a-temp;
        }
        System.out.println("rema"+a);
        return result;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.divide(10,9));
    }
}
