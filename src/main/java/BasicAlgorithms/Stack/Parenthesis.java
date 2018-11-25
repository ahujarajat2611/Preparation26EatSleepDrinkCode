package BasicAlgorithms.Stack;

/**
 * Created by hadoop on 2/1/18.
 */
public class Parenthesis {
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
