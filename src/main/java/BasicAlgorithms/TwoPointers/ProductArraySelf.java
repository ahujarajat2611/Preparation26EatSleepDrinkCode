package BasicAlgorithms.TwoPointers;

/**
 * Created by hadoop on 13/10/17.
 */
public class ProductArraySelf {
    public static void main(String[] args) {
        int []array = {1,2,3,4};
        int []ans = productapartfromself(array);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
    static int [] productapartfromself(int []nums){
        int []left = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = 1;
        for(int i=1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        right[nums.length-1] = 1;
        for(int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            left[i] = left[i]*right[i];
        }
        return left;
    }
}
