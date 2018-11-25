package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String firstString = strs[0];

        for(int i=0;i<firstString.length();i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<i+1){
                    return firstString.substring(0,i);
                }
                if(strs[j].charAt(i)!=firstString.charAt(i)){
                    return firstString.substring(0,i);
                }
            }
        }
        return null;
    }
}