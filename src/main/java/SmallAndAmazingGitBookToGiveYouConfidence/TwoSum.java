package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 22/9/17.
 */
public class TwoSum {
    public int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int number : num) {
            if (map.containsKey(target - number)) {
                return new int[]{map.get(target - number), index};
            }
            map.put(number, index++);
        }
        return null;
    }


    private class TwoSumDesign {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        void add(int num){
            if(hashMap.containsKey(num)){
               int count= hashMap.get(num);
               hashMap.put(num,count+1);
            }
            else{
                hashMap.put(num,1);
            }
        }
        public boolean find(int value){
            for(int num:hashMap.keySet()){
                if(hashMap.containsKey(value-num)){
                    if(value == num){
                        if(hashMap.get(num)>1) {
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
