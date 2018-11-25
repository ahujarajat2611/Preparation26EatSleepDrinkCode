package AwangDevLintCode;

/**
 * Created by hadoop on 24/1/18.
 */
public class CountAndSay {
    public String countAndSay(String start,int n) {
        if(n==0){
            return "";
        }
        for(int i=1;i<=n;i++){
            String temp="";
            int count = 1;
            for(int j=1;j<start.length();j++){
                if(start.charAt(j) == start.charAt(j-1)){
                    count++;
                }
                else {
                    temp = temp+count;
                    temp = temp + start.charAt(j-1);
                    count=1;
                }
            }
            // Very imp need to add last value in the ans
            // before we publish again !!!
            // last Value to be addded // vim
            temp = temp+count;
            temp = temp+start.charAt(start.length()-1);
            // update staret to temp ....
            start = temp;
        }
        return start;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay("111221",1));
    }
}
