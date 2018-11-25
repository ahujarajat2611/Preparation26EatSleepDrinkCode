package BasicAlgorithms.String;

/**
 * Created by hadoop on 15/10/17.
 */
public class PayPal {
    public String convert(String s, int numRows) {
        StringBuilder [] stringBuilders = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            stringBuilders[i] = new StringBuilder();
        }
        int i=0;
        while (i<s.length()){
            for(int index = 0;index<numRows-1 && i<s.length();index++){
                stringBuilders[index].append(s.charAt(i++));
            }
            for(int index = numRows-1;index>=1 && i<s.length();index--){
                stringBuilders[index].append(s.charAt(i++));
            }
        }
        String ans="";
        for(int k=0;k<numRows;k++){
            ans = ans+ stringBuilders[k].toString();
        }
        return ans;
    }
}