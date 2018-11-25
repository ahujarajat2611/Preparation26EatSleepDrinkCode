package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class StrStr {
        public int strStr(String haystack, String needle) {

            if (needle == null || needle.length() == 0) {
                return 0;
            }
        /*
        else if (haystack == null || haystack.length() == 0
                   || haystack.length() < needle.length()) {
            return -1;
        }*/

            int i = 0;
            int j = 0;

            for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
                // if (haystack.charAt(i + j) == needle.charAt(j)) {
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
                // }
            }
            return -1;
        }

    public int strStrAgain(String source, String target) {
        //Check Null
        if(source == null || target == null){
            return -1;
        }
        //Two Pointer check for target
        int i,j;
        for (i = 0; i < source.length() - target.length() + 1; i++){
            for (j = 0; j < target.length(); j++){
                if (source.charAt(i+j) != target.charAt(j)){
                    break;
                }
            }
            if( j == target.length()){
                return i;
            }
        }
        //'target' not found:
        return -1;
    }
}

