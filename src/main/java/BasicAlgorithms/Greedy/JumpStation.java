package BasicAlgorithms.Greedy;

/**
 * Created by hadoop on 23/10/17.
 */
public class JumpStation {

    public boolean canJump(int[] nums) {
        int fathestIndex = 0 + nums[0];
        for (int i = 0; i < nums.length && i <= fathestIndex; i++) {
            if (i + nums[i] > fathestIndex) {
                fathestIndex = i + nums[i];
            }
        }
        if (fathestIndex >= nums.length - 1) {
            return true;
        }
        return false;
    }

    public int jump(int[] nums) {
        int steps=1;
        int fathestIndex = 0 + nums[0];
        int lastfarthestIndex = 0+nums[0];
        for (int i = 0; i < nums.length && i <= fathestIndex; i++) {
            if(i>lastfarthestIndex){
                System.out.println("i "+i);
                System.out.println(" last "+lastfarthestIndex);
                steps++;
            }
            if (i + nums[i] > fathestIndex) {
                lastfarthestIndex = fathestIndex;
                fathestIndex = i + nums[i];
            }
        }
//        if (fathestIndex >= nums.length - 1) {
//            return steps;
//        }
        return steps;
    }
    public int jumpagain(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxCover = 0;
        int steps = 0;
        int lastCover = 0;
        for (int i = 0; i < nums.length && i <= maxCover; i++) {
            if (i > lastCover) {
                steps++;
                lastCover = maxCover;
            }

            //maxCover = Math.max(maxCover, A[i] + i);
            if (nums[i] + i > maxCover) {
                maxCover = nums[i] + i;
            }
        }
        if (maxCover < nums.length - 1) {
            return 0;
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpStation jumpStation = new JumpStation();
        jumpStation.jump(new int[]{3,2,1});
    }
}