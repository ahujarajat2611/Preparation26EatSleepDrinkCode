package BasicAlgorithms.QuickSelect;

/**
 * Created by hadoop on 16/10/17.
 */
public class Main {
    public static void main(String[] args) {
     int nums[]={1,2,3,4};
        System.out.println(get(nums,0));
        System.out.println(get(nums,1));
        System.out.println(get(nums,2));
        System.out.println(get(nums,3));
       // System.out.println(get(nums,4));

    }
    private static int get(int[] nums, int i){
        if(i <= (nums.length / 2 - 1)) return i * 2 + 1;
        return (i - nums.length / 2) * 2;
    }
}
