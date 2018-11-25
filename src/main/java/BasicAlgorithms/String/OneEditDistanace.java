package BasicAlgorithms.String;

/**
 * Created by hadoop on 15/10/17.
 */
public class OneEditDistanace {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()>t.length()){
            return isOneEditDistance(t,s);
        }
        if(s.length() == t.length()){
            int count = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=t.charAt(i)){
                    count++;
                }
            }
            if(count>1){
                return false;
            }
        }
        else if(t.length()-s.length() ==1){
            int i=0;
            for(i=0;i<s.length();i++){
                if(s.charAt(i)!=t.charAt(i)){
                    break;
                }
            }
            for(int k=i;k<s.length();k++){
                if(s.charAt(k)!=t.charAt(k+1)){
                    return false;
                }
            }
            return true;
        }
            return false;
    }
}