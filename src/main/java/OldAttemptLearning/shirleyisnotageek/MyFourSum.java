package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 2/3/18.
 */
import java.util.*;
public class MyFourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] num, int target) {
            List<List<Integer>> rst = new ArrayList<List<Integer>>();
            if(num == null || num.length == 0)
                return rst;
            Arrays.sort(num);
            for (int i = 0; i < num.length - 3; i++){
                if (i != 0 && num[i] == num[i - 1])
                    continue;
                for(int j = i + 1; j < num.length - 2; j++){
                    if(j != i + 1 && num[j] == num[j - 1])
                        continue;
                    int third = j + 1;
                    int forth = num.length - 1;
                    while(third < forth){
                        int sum = num[i] + num[j] + num[third] + num[forth];
                        if(third >j+1 && num[third] == num[third-1]){
                            third++;
                            continue;
                        }
                        if(forth <num.length-1 && num[forth] == num[forth+1]){
                            forth--;
                            continue;
                        }

                        if(sum == target){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[third]);
                            list.add(num[forth]);
                            rst.add(list);
                            third++;
                            forth--;
                        }
                        else if(sum < target)
                            third++;
                        else
                            forth--;
                    }
                }
            }
            return rst;
        }
    }
}
