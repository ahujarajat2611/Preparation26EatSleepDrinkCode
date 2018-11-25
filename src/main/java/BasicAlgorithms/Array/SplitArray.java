package BasicAlgorithms.Array;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.HashMap;

/**
 * Created by hadoop on 26/10/17.
 */
public class SplitArray {
    public boolean splitArray(int[] nums) {
        if(nums.length<7){
            return false;
        }
        int []sum = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            sum[i] = sum[i-1] +nums[i-1];
        }
        // split array based out of nums.length
        for(int i=1;i<=nums.length-6;i++){
            int firstPartitionSum = sum[i]; // 0 to i-1
            for(int j=i+2;j<=nums.length-4;j++){
                int secondPartitionSum = sum[j]-sum[i+1]; // i+1 TO J-1
                if(firstPartitionSum !=secondPartitionSum){
                    continue;
                }
                for(int k = j+2;k<=nums.length-2;k++){
                    int thirdParititionSum = sum[k]-sum[j+1];
                    int fourthPartitionSum = sum[nums.length]-sum[k+1];

                    if(firstPartitionSum == secondPartitionSum && thirdParititionSum == fourthPartitionSum && firstPartitionSum == thirdParititionSum){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean splitArrayop(int[] nums) {
        if(nums.length<7){
            return false;
        }
        int []sum = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            sum[i] = sum[i-1] +nums[i-1];
        }
        ConsoleWriter.printIntArray(sum);
        for(int j = 2;j<=nums.length-5;j++){
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int i=0;i<=j-2;i++){
                System.out.println(sum[i+1]);
                if(sum[i] == sum[j]-sum[i+1]){
                    hashMap.put(sum[i],1);
                    System.out.println(hashMap);
                }
            }
            //save state before we go further
            for(int k= j+2;k<=nums.length-3;k++){
                // sum from j+1 to k-1
                if(sum[k]-sum[j+1] == sum[nums.length]-sum[k+1] && hashMap.containsKey(sum[k]-sum[j+1])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        splitArray.splitArrayop(new int[]{1,2,1,2,1,2,1});
    }
    }
    /*
    WATTTTTA SOLUTION SIR JI MAZA AA GAYA
    4 PARTITIONS EQUAL SUM

        bool splitArray(vector<int>& nums) {
        if (nums.size() < 7) return false;
        int n = nums.size();
        vector<int> sum(n); sum[0] = nums[0];
        for (int i = 1; i < n; ++i) sum[i] = sum[i-1]+nums[i];
        for (int j = 3; j < n-3; ++j) {
            unordered_set<int> s;
            for (int i = 1; i < j-1; ++i) {
                if (sum[i-1] == sum[j-1]-sum[i]) s.insert(sum[i-1]);
            }
            for (int k = j+2; k < n-1; ++k) {
                if (sum[n-1]-sum[k] == sum[k-1]-sum[j] && s.count(sum[n-1]-sum[k])) return true;
            }
        }
        return false;
    }
};
     */