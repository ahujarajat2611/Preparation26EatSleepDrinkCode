package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class AddOne {
    public  int[] plusOne(int []num){
        int carry = 1;
        int []temp = new int[num.length+1];
        for(int i=num.length-1;i>=0;i--){
            int sum = num[i] + carry;
            int value = sum%10;
            temp[i+1] = value;
            carry = sum/10;
        }
        if(carry == 1){
            temp[0] = 1;
            return temp;
        }
        for(int i=0;i<num.length;i++){
            temp[i] = temp[i+1];
        }
        return temp;
    }
}
