package BasicAlgorithms.Array;

/**
 * Created by hadoop on 8/1/18.
 */
public class MissingRanges {
    /*vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> res;
        for (const int num : nums) {
            if (num == INT_MIN) {
                lower = num + 1;
                continue;
            }

            if (lower < num - 1)
                res.push_back(to_string(lower) + "->" + to_string(num - 1));
            else if (lower == num - 1)
                res.push_back(to_string(lower));

            if (num == INT_MAX)
                return res;

            lower = num + 1;
        }

        if (lower < upper)
            res.push_back(to_string(lower) + "->" + to_string(upper));
        else if (lower == upper)
            res.push_back(to_string(lower));

        return res;

    } */
}
