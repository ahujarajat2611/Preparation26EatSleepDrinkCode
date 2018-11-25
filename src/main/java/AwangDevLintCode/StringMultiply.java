package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
public class StringMultiply {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        } else if (num1.length() == 0 || num2.length() == 0) {
            return num1.length() == 0 ? num2 : num1;
        } else if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        //reverse string, so to calculate from 0 base. easier to calculate
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();

//        999 999-> 99 99
        //product array. extra leading space for carriers
        int[] product = new int[num1.length() + num2.length()];


        //Calculate the product normally
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                product[i + j] += a * b;
            }
        }

        //calcualte and output
        //remember, now the string is reversed calculated.
        //so every time, add to index 0. so it will all reverse back; OR, append, and reverse later.
        int carrier = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < product.length; i++) {
            int number = (product[i]+carrier) % 10;
            carrier = (product[i]+carrier) / 10;
            sb.append(number);
//            if (i < product.length - 1) {
//                product[i + 1] += carrier;
//            }
        }
        sb.reverse();
        //trim leading 0's
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringMultiply sm = new StringMultiply();
        System.out.println(sm.multiply("999","999"));
    }
}
