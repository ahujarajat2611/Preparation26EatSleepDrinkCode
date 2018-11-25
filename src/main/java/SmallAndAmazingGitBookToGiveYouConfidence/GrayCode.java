package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 19/9/17.
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(3));
    }
    List<Integer> grayCode(int n){
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i=1;i<=n;i++){
            // fetch the last indexed value
            // it is in order since Arraylist ..
            int size = result.size()-1;
            while (size>=0){
                result.add(result.get(size) | 1<<i-1);
                size--;
            }
        }
        System.out.println(result);
        return result;
    }

}
