package BasicAlgorithms.String;

/**
 * Created by hadoop on 15/10/17.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() ==0){
            return -1;
        }
        if(haystack == null || needle.length() ==0){
            return -1;
        }
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int j=0;
            for(int k=i;j<needle.length();j++){
                if(k<haystack.length() && haystack.charAt(k) == needle.charAt(j)){
                    k++;
                }
                else {
                    break;
                }
            }
            if(j ==needle.length()){
                return i;
            }
        }
        return -1;
    }

    public int strStrAgain(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] src = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for (int i = 0; i < src.length - target.length + 1; i++) {
            int j = 0;
            while (j < target.length) {
                if (src[i + j] != target[j]) {
                    break;
                }
                j++;
            }
            if (j == target.length) {
                return i;
            }
        }
        return -1;
    }

    public boolean strStrAgainTry(String src,String target){
        for(int i=0;i<=src.length()-target.length();i++){
            int j =0;
            for(;j<target.length() && target.charAt(j) == src.charAt(i+j) ; j++){

            }
            if(j == target.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStrAgainTry("rajat","aj"));
    }
}