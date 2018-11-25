package BasicAlgorithms.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 13/10/17.
 */
public class FlipGame {
    public static List<String> generatePossibleNextMoves(String s){
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)== '+' && s.charAt(i+1) == '+'){
                String result = s.substring(0,i)+"--"+s.substring(i+2);
                res.add(result);
            }
        }
        return res;
    }
}

