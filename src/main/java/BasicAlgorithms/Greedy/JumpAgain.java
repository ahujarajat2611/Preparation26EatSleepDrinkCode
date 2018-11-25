package BasicAlgorithms.Greedy;

/**
 * Created by hadoop on 2/12/17.
 */
public class JumpAgain {
    public int jump(int []nums){
        // publish end and steps
        // loop frmo publish and end to keep track of highest point that can
        // be reached oncce you find farthest point
        // update publish and end variable
        //   publish == end
        // end = farthest point
        // and loop in between that
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

    public static void main(String[] args) {
        int nums[]= {2,3,1,1,4};
        JumpAgain jumpAgain = new JumpAgain();
        System.out.println(jumpAgain.jump(nums));
    }
}
