package BasicAlgorithms.String;

/**
 * Created by hadoop on 13/10/17.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
            if(a == null || a.length() == 0){
                return b;
            }
            if( b  == null || b.length() == 0){
                return a;
            }
            int i = a.length()-1;
            int j = b.length()-1;
            String ans="";
            int carry = 0;
            while (i>=0 || j>=0 || carry>0) {
                int avalue =0;
                if(i>=0){
                    avalue = a.charAt(i)-'0';
                }
                int bvalue = 0;
                if(j>=0){
                    bvalue = b.charAt(i)-'0';
                }
                int sum = avalue +bvalue+ carry;
                ans = sum % 2 + ans;
                carry = sum / 2;
            }
            return ans;
    }
}