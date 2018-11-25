package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashSet;

/**
 * Created by hadoop on 22/9/17.
 */
public class HappyNumber {
    public boolean isHappyNumber(int n){
        int temp =n;

        HashSet<Integer> hashset = new HashSet<>();

        while (true){
            int sum = 0;
            while (temp!=0){
                sum = sum + (temp%10 )* (temp%10);
                temp = temp/10;
            }
            if(sum == 1){
                return true;
            }

            if(hashset.contains(sum)){
                return false;
            }

            hashset.add(sum);
            temp = sum;
        }
    }
}
