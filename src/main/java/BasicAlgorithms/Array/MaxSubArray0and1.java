package BasicAlgorithms.Array;
import java.util.*;
/**
 * Created by hadoop on 25/12/17.
 */
public class MaxSubArray0and1 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans = 0;
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum = sum + (nums[i]==0?-1:1);
            // System.out.println("sum"+sum);
            if(map.containsKey(sum)){
                //   System.out.println("entry "+i +" "+map.get(sum));
                ans = Math.max(ans,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return ans;
    }
}
