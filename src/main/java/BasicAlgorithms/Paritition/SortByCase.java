package BasicAlgorithms.Paritition;

/**
 * Created by hadoop on 19/12/17.
 */
public class SortByCase {
    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
        char tmp ;
        while ( i <= j) {
            while (i <= j && Character.isLowerCase(chars[i]) ) i++;
            while (i <= j && Character.isUpperCase(chars[j]) ) j--;
            if (i <= j) {
                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++; j--;
            }
        }
        //write your code here
        return ;
    }
}
