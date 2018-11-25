package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class AddBinary {
    String addBinary(String a,String b){
        int index1= a.length()-1;
        int index2 = b.length()-1;

        int carry =0;
        int base = 2;
        String output = "";
        while (index1>=0 || index2 >=0 || carry!=0){
            int num1=0;
            if(index1>=0){
                // when you deal with chars makee sure you reduce e
                // by '0' ( like basic thing )
                num1 = a.charAt(index1)-'0';
                index1--;
            }
            int  num2=0;
            if(index2>=0){
                num2 = a.charAt(index2)-'0';
                index2--;
            }
            int sum = num1 + num2 + carry;
            carry = sum/base;
            int value = sum%base;
            output = output+ String.valueOf(value);
        }
        return output;
    }
}
