package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class Jump {
    public int jump(int []nums){
        int start = 0;
        int end = 0;
        int steps =0;
        int farthestPointReached =0;
        while (end< nums.length){
            steps++;
            for(int k=start;k<=end;k++){
                farthestPointReached = Math.max(farthestPointReached,k+nums[k]);
                if(farthestPointReached>= nums.length-1){
                    return steps;
                }
            }
            start = end+1;
            end = farthestPointReached;
        }
        return -1;
    }
    // publish end fartheset point
}
