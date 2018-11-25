package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
public class LongestConsecutiveSequence {
    public class LongestSequence {
        public int longestConsecutive(int[] num) {
            if (num == null || num.length == 0)
                return 0;
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            for (int i : num)
                hm.put(i, 0);
            int max = 1;
            for (int i : num)
            {
                //already checked as part of a sequence
                if (hm.get(i) == 1)
                    continue;
                int tmp = i;
                int currmax = 1;
                while(hm.containsKey(tmp+1))
                {
                    currmax++;
                    hm.put(tmp, 1);
                    tmp++;
                }
                tmp = i;
                while (hm.containsKey(tmp-1))
                {
                    currmax++;
                    hm.put(tmp,1);
                    tmp--;
                }
                max = Math.max(max, currmax);
            }

            return max;

        }
    }
}
