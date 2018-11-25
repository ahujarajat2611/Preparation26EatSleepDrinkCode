package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 13/10/17.
 */
public class TrappedWater {
    public static void main(String[] args) {
        int nums[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
static  int trap(int heights[]){
    int left = 0;
    int right = heights.length-1;
    int water=0;
    while (left<right){
        int min = Math.min(heights[left],heights[right]);
        if(heights[left] == min){
            left++;
            while (left<right && min>heights[left]){
                water = water+ min-heights[left];
                left++;
            }
        }
        else {
            right--;
            while (left<right && min >heights[right]){
                water = water + min-heights[right];
                right--;
            }
        }
    }
    return water;
}
    static  int trapWaterAgainBetterSOlution(int heights[]) {
    int maxIndex = find(heights);
    int sum=0;
    for(int i=0;i<maxIndex;i++){

        int prev = 0;
        // whenever there is increase in height
        if(heights[i] >prev){
            sum = sum + (heights[i]-prev) *(maxIndex-i);
            prev = heights[i];
        }
        sum = sum - heights[i];
    }
    int prev = 0;
    for(int i=heights.length-1;i>maxIndex;i--){
        if(heights[i]>prev){
            sum = sum +(heights[i]-prev) * (maxIndex-i);
            prev = heights[i];
        }
        sum = sum -heights[i];
    }

    return sum;
    }

    private static int find(int[] heights) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<heights.length;i++){
            if(heights[i]>max){
                max = heights[i];
                index = i;
            }
        }
        return index;
    }
}
