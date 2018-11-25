package OldAttemptLearning.dynamicprogramming;

/**
 * Created by hadoop on 3/8/17.
 */
public class Robber {
    public static void main(String[] args) {
        Integer array[] = new Integer[4];
        array[0] = 1;
                array[1] = 2;
        array[2] =100;
        array[3] = 5;
        int rob = robbery(array,array.length-1);
        System.out.println(rob);
    }

    private static int robbery(Integer nums[],int index) {
        if(index == 0){
            return nums[index];
        }
        if(index <0) return 0;

        int returned = Math.max(robbery(nums,index-1),nums[index]+robbery(nums,index-2));

        return returned;
    }
}
