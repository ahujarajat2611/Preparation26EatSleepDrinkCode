package BasicAlgorithms.String;

/**
 * Created by hadoop on 24/10/17.
 */
public class Atoi {
    public int myAtoi(String str){
        int index = 0;
        str = str.trim();
        if( str == null || str.length() ==0){
            return 0;
        }
        int sign=1;
        if(str.charAt(index) =='-'){
            sign = -1;
            index++;
        }
        else if(str.charAt(index) =='+'){
            sign =1;
            index++;
        }
        long result=0;
        for(int i=index;i<str.length();i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                break;
            }
            result = result*10 + str.charAt(i)-'0';
            if(result>Integer.MAX_VALUE){
                break;
            }
        }
        if(sign == 1){
            if(sign*result>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        if(sign == -1){
            if(sign*result<=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)result*sign;
    }
}
