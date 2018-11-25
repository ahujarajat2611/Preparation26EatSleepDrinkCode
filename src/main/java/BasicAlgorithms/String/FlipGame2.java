package BasicAlgorithms.String;

/**
 * Created by hadoop on 13/10/17.
 */
public class FlipGame2 {
    public boolean canWin(String s) {
        if(s == null || s.length() ==0){
            return false;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == '+' && s.charAt(i+1)=='+'){
                String updatedString = s.substring(0,i)+"--"+s.substring(i+2);
                if(!canWin(updatedString)){
                    return true;
                }
            }
        }
        return false;
    }
}
