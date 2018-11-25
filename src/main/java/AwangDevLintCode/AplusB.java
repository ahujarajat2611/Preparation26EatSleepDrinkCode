package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
public class AplusB {




    /// a ,b
    //
    public int aplusb(int a, int b) {
        while (b != 0) {
            /*
            carry of a&b
             */
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    public int aplusbrec(int a, int b){

        // if carry gets zero then return // straight forward
        // if end of two numbers is zero a becomes a ^b is the sum
        if(b == 0){
            return a;
        }
        int sum = a^b;
        int carry =  a&b;
        return aplusb(sum,carry<<1);
    }
    // imp thing is to not to forget shift carry by 1 off before you send it to recursion !!
    public static void main(String args[]){

        AplusB aplusB= new AplusB();
        System.out.println(aplusB.aplusbrec(2,5));
        System.out.println(aplusB.aplusb(2,5));

    }
    // carry = a&b<<1
    // sum = a^b
    // carry is carry  = a&b <<1
    // sum  = a^b
    // a= sum
        //b = carry
}
