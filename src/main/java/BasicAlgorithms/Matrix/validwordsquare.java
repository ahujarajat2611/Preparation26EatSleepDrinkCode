package BasicAlgorithms.Matrix;

import java.util.List;

/**
 * Created by hadoop on 16/1/18.
 */
public class validwordsquare {
    public boolean validWordSquare(List<String> words) {
        int m = words.size();
        if (m == 0) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            String w = words.get(i);
            for (int j = 0; j < w.length(); j++) {
                if (j >= m || words.get(j).length() <= i) {
                    return false;
                }
                if (w.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
