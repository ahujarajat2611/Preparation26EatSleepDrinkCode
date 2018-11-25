package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 15/12/17.
 */
public class HouseRob {
    public int rob(int[] nums) {

        int include = 0;
        int exclude = 0;

        for(int i=0;i<nums.length;i++){
            int previnclude = include;
            int prevexclude = exclude;
            include = nums[i]+prevexclude;
            exclude = Math.max(prevexclude,previnclude);
        }
        return Math.max(include,exclude);
    }
    public int robfirstselected(int[] nums) {
// manually selecting first element
        int include = nums[0];
        int exclude = 0;
// looping just before last element
        // smart choice !!!

        for(int i=1;i<nums.length-1;i++){
            int previnclude = include;
            int prevexclude = exclude;
            include = nums[i]+prevexclude;
            exclude = Math.max(prevexclude,previnclude);
        }
        return Math.max(include,exclude);
    }
    public int roblastselected(int[] nums) {

        // first element not selecting here for sure
        int include = 0;
        int exclude = 0;

        // starting from first element
        for(int i=1;i<nums.length-1;i++){
            int previnclude = include;
            int prevexclude = exclude;
            include = nums[i]+prevexclude;
            exclude = Math.max(prevexclude,previnclude);
        }
        // once we got ans
        // pick last element and add to exclude to see if you getting
        // more money !!!
        return Math.max(include,exclude+nums[nums.length-1]);
    }
}