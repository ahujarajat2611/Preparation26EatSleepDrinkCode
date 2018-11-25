package DSA.String;

/**
 * Created by hadoop on 12/2/18.
 */

// Simple rule of keep a counter of addiing open and closed parentheseis
    //if aat any point closed parent >open return fasle

    // in the end all items have to be equal
public class WellFormedParenthesis {
    public boolean isWellFormedParantheses2(char[] a, int n) {
        int openParentheses = 0, closedParantheses = 0;
        char ch;
        for (int i = 0; i < n; i++) {
            ch = a[i];
            switch (ch) {
                case '{':
                    openParentheses++;
                    break;
                case '}':
                    closedParantheses++;
                    break;
            }
            if (closedParantheses > openParentheses)
                return false;
        }
        return openParentheses == closedParantheses;
    }
}
