package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
"Given a collection of integers  S, return all possible subsets."
When it comes to problems like this, the question you should always ask yourself is: are there any duplicates?
The answer is always yes! And here comes our Subsets II.
It is defined as a backtracking problem.
Basically, given a set S with duplicates [1,2,2]
add each element into the list, then remove it after add the list to the final and add the next one.
To avoid duplicate lists, first condition is definitely num[i] != num[i - 1]. However, we still want to add i-th element if (i - 1)-th element is in the list as well as the condition where i-th element is the first element in the list.
[1]  -> [1,2] -> [1,2,2] -> [1,2]  -> [1] -> [1, 2], duplicates, will not add -> [1] -> [] -> [2] -> [2,2] -> [2] ->[] -> [2], duplicates -> [].
 */
public class SubsetsDuplicate {
    public class Solution {
        public ArrayList<List<Integer>> subsetsWithDup(int[] num) {
            ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
            if (num == null || num.length == 0)
                return rst;
            ArrayList<Integer> list = new ArrayList<Integer>();
            Arrays.sort(num);
            SetHelper(rst, list, num, 0);
            return rst;
        }
        private void SetHelper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] num, int start)
        {
            rst.add(new ArrayList(list));
            for (int i = start; i < num.length; i++)
            {
                if (i != start && num[i] == num[i - 1])
                    continue;
                list.add(num[i]);
                SetHelper(rst, list, num, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
