package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n==0){
            return "";
        }
        String res = "1";

        for(int i=1;i<n;i++){
            String temp="";
            int count = 1;
            for(int j=1;j<res.length();j++){
                if(res.charAt(j) == res.charAt(j-1)){
                    count++;
                }
                else {
                    temp = temp+count;
                    temp = temp + res.charAt(j-1);
                    count =1;
                }
            }
            temp = temp+count;
            temp = temp+res.charAt(res.length()-1);
            res = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        countAndSay.countAndSay(5);
    }
}
