package DSA.Backtracking;

/**
 * Created by hadoop on 21/2/18.
 */
import java.util.*;
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (null == words || words.size() == 0)
            return true;

        // for(String x:words){
        // 	if(words.size() != x.length()){
        // 		return false;
            int m = words.size();
            if (m == 0) {
                return true;
            }
            for (int i = 0; i < m; i++) {
                String w = words.get(i);
                for (int j = 0; j < w.length(); j++) {

                    // YOu dont need tough problem to dent your confidence . this one good enought to throw you out of
                    // the interview simple as that !!!!!
                    if(j>=words.size()){
                        return false;
                    }
                    if(words.get(j).length()<=i){
                        return false;
                    }
                    if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                        return false;
                    }
                }
            }
            return true;
        }

    public static void main(String[] args) {
        ValidWordSquare validWordSquare = new ValidWordSquare();
     //   ["abc","b"];
        validWordSquare.validWordSquare(Arrays.asList(new String[]{"ab","b"}));
    }
}
