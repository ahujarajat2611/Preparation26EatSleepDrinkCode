package BasicAlgorithms.String;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 13/10/17.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int []product = new int[num1.length()+num2.length()];
        int i=-1;
        int j=-1;
        for(i=num1.length()-1;i>=0;i--){
            for(j=num2.length()-1;j>=0;j--){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                product[i + j + 1] += a * b;
            }
        }
        int carry =0;
        for(int k=num1.length()+num2.length()-1;k>=0;k--){
            product[k] = product[k]+carry;
            carry = product[k]/10;
            product[k] = product[k]%10;
        }
        String ans = "";
        for( i=0;i<num1.length()+num2.length();i++) {
            ans = ans+product[i];
        }
        i=0;
        while (i<product.length && ans.charAt(i)=='0'){
            i++;
        }
        ans = ans.substring(i);
        return ans;
    }

    public String multiplyMine(String num1, String num2) {
        int []product = new int[num1.length()+num2.length()];
        int i=-1;
        int j=-1;
        for(i=num1.length()-1;i>=0;i--){
            for(j=num2.length()-1;j>=0;j--){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                product[i + j+1] += a * b;
            }
        }
        ConsoleWriter.printArray(product);
        int carry =0;
        for(int k=num1.length()+num2.length()-1;k>=0;k--){
            product[k] = product[k]+carry;
            carry = product[k]/10;
            product[k] = product[k]%10;
        }


        String ans = "";
        for( i=0;i<num1.length()+num2.length();i++) {
            ans = ans+product[i];
        }
        i=0;
        while (i<product.length && ans.charAt(i)=='0'){
            i++;
        }
        ans = ans.substring(i);
        return ans;
    }

    public static void main(String[] args) {

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("999","204"));
        System.out.println(multiplyStrings.multiplyMine("00999","00999"));

    }
}