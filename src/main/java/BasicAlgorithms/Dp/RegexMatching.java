package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 16/12/17.
 */
public class RegexMatching {
    public boolean isRegexMatch(String text, String pattern) {
        boolean[][] t = new boolean[text.length() + 1][pattern.length() + 1];
        t[0][0] = true;
        // (empty_text,a*),(empty_text,a*b*) => set to true
        for (int j = 1; j < t[0].length; j++) {
            if (pattern.charAt(j - 1) == '*') {
                t[0][j] = t[0][j - 2];
            }
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {

                if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    // scenario : t = x, p=xa*, res = true, value gets from left;( ignoring a and star) (x,x)
                    t[i][j] = t[i][j - 2];

                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
                        // scenario : t = xa, p=xa*, res = true, value doesn't get from left(xa,x); value gets from top (x,xa*)
                        // scenario : t = xaa, p=xa*, res = true, value doesn't get from left(xaa,x); value gets from top (xa,xa*)
                        t[i][j] = t[i][j] || t[i - 1][j];
                    }

                    /* t(i)(j) = assume p* not there
                        // may be chars are not maching

                        then t(i)(j) = t(i)(j-2)

                        // if chars are matching of i-1 and j-2 or j-2 is . ( means any characacter)
                        t(i)(j) = t(i-1)(j)


                         */


                }
            }
        }
        return t[t.length - 1][t[0].length - 1];
    }

    public boolean isWildcardMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        char pat[] = pattern.toCharArray();
        char txt[] = text.toCharArray();

        // replace a**b with a*b
        int left = 1;
        for (int i = 1; i < pat.length; i++) {
            if (pat[i] == '*' && pat[i] == pat[i - 1]) {
                // ignore extra star
            } else {
                pat[left++] = pat[i];
            }
        }

        boolean[][] t = new boolean[txt.length + 1][left + 1];
        t[0][0] = true;

        if (pat[0] == '*' && t[0].length > 1) {
            t[0][1] = true;
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (pat[j - 1] == '?' || pat[j - 1] == txt[i - 1]) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pat[j - 1] == '*') {
                    t[i][j] = t[i][j - 1] || t[i - 1][j];
                }
            }
        }
        return t[t.length - 1][t[0].length - 1];
    }

    public boolean isWildcardMatchAgain(String text, String pattern) {
        if(pattern.isEmpty()){
            return text.isEmpty();
        }

        char []pat = pattern.toCharArray();
        char []txt = text.toCharArray();
        int left=1;
        for(int i=1;i<pat.length;i++){
            if(pat[i] == '*' && pat[i] == pat[i-1]){
                continue;
            }
            else {
                pat[left++] = pat[i];
            }
        }
        boolean [][]t = new boolean[text.length()+1][left+1];
        t[0][0] = true;
        for(int i=1;i<t.length;i++){
            for(int j =1;j<t[0].length;j++){
                if(pat[i-1] =='?' || pat[i-1] == txt[j-1]){
                    t[i][j] = t[i-1][j-1];
                }
                else if( pat[i-1]=='*'){
                    t[i][j] = t[i-1][j] || t[i][j-1];
                }
            }
        }
        return t[text.length()][left];
    }
}