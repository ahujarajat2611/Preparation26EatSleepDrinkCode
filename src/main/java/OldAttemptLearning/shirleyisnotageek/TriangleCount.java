package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 10/12/17.
 */
public class TriangleCount {
    public int triangleCount(int S[]) {
        if (S == null || S.length == 0) {
            return 0;
        }
        Arrays.sort(S);
        int count = 0;
        for (int i = 0; i < S.length; i++) {
            int left = 0;
            int right = i - 1; //at least 1 step left from C
            while (left < right){
                if (S[left] + S[right] > S[i]) {
                    count += (right - left);
                    right--;
                } else {//(S[left] + S[right] <= S[i])
                    left++;
                }
            }
        }
        return count;
    }
}
