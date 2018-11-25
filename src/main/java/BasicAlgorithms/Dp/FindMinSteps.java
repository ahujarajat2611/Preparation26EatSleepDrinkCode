package BasicAlgorithms.Dp;
import java.util.*;
/**
 * Created by hadoop on 25/12/17.
 */
public class FindMinSteps {
//    public int findRotateSteps(String ring, String key) {
//        if(key.length() == 0){
//            return 0;
//        }
//        int steps = Integer.MAX_VALUE;
//        for(int i=0;i<ring.length();i++){
//
//            if(ring.charAt(i) == key.charAt(0)){
//                int minSteps=0;
//                minSteps+=Math.min(i,ring.length()-i);
//                minSteps+=1;
//                String updatedStringClockWise = ring.substring(i,ring.length())+ring.substring(0,i);
//                minSteps+=findRotateSteps(updatedStringClockWise,key.substring(1));
//               // System.out.println(minSteps);
//                steps = Math.min(steps,minSteps);
//            }
//        }
//        return steps;
//    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        FindMinSteps findMinSteps = new FindMinSteps();
        System.out.println(findMinSteps.findRotateSteps(ring,key));
    }
    public int findRotateSteps(String ring, String key) {
        Map<String,Integer> map = new HashMap();
        return dfs(ring, key, 0, map);
    }

    public int dfs(String ring, String key, int index, Map<String,Integer> map){
        if(index == key.length()){
            return 0;
        }

        char c = key.charAt(index);
        String hashKey = ring + index;
        if(map.containsKey(hashKey)) return map.get(hashKey);

        int minSteps = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i ++){
            if(ring.charAt(i) == c){
                String s = ring.substring(i, ring.length()) + ring.substring(0, i);
                int steps = 1 + Math.min(i, ring.length() - i);
                steps += dfs(s, key, index + 1, map);
                System.out.println(steps);
                minSteps = Math.min(minSteps, steps);
            }
        }

        map.put(hashKey, minSteps);

        return minSteps;
    }
    public int findRotateStepsEasyAmazing(String ring, String key) {
        Map<Character,List<Integer>> map = new HashMap<>();
        char[] arrayRing = ring.toCharArray();
        for(int i=0;i<arrayRing.length;i++){
            char c = arrayRing[i];
            if(map.containsKey(c)==false){
                map.put(c,new ArrayList<>());
            }
            map.get(c).add(i);
        }
        Integer[][] dp = new Integer[key.length()][ring.length()];
        DPsearch(map,dp,key.toCharArray(),ring.toCharArray(),0,0);
        return dp[0][0];
    }

    public int DPsearch(Map<Character,List<Integer>> map,Integer[][] dp,char[] arrayKey,char[] arrayRing,int keyIndex,int ringIndex){
        if(keyIndex==arrayKey.length){
            return 0;
        }

        if(dp[keyIndex][ringIndex]!=null){
            return dp[keyIndex][ringIndex];
        }

        List<Integer> list = map.get(arrayKey[keyIndex]);
        int min = Integer.MAX_VALUE;
        for(int index:list){
            int steps = 0;
            if(index<ringIndex){
                steps = Math.min(ringIndex-index,Math.abs(index-ringIndex+arrayRing.length));
            }else{
                steps = Math.min(index-ringIndex,Math.abs(ringIndex+arrayRing.length-index));
            }

            int nextsteps = DPsearch(map,dp,arrayKey,arrayRing,keyIndex+1,index);
            min = Math.min(min,steps+1+nextsteps);

        }

        dp[keyIndex][ringIndex] = min;
        return dp[keyIndex][ringIndex];

    }
}
/*
//Solution: DFS + Memo

public int findRotateSteps(String ring, String key) {
     Map<String, Integer> memo = new HashMap<>();
    return dfs(memo, ring, key, 0);
}

//memo: key is ring & index as a string, value is min steps;
//index: is index of key
private int dfs(Map<String, Integer> memo, String ring, String key, int index) {
    if (index >= key.length()) {
        return 0;
    }

    //Fetch memory
    String memoKey = ring + index;
    if (memo.containsKey(memoKey)) {
        return memo.get(memoKey);
    }

    //DFS
    char c = key.charAt(index);
    int forwardPos = getPosition(ring, c);//forward position
    int backwardPos = getBackPosition(ring, c);//backward position

    //forward steps and backward steps
    int forwardSteps = 1 + forwardPos
        + dfs(memo, ring.substring(forwardPos) + ring.substring(0, forwardPos), key, index + 1);
    int backwardSteps = 1 + ring.length() - backwardPos
        + dfs(memo, ring.substring(backwardPos) + ring.substring(0, backwardPos), key, index + 1);
    int steps = Math.min(forwardSteps, backwardSteps);

    //Memorize
    memo.put(memoKey, steps);

    return steps;
}

private int getPosition(String ring, char c) {
    return ring.indexOf(c);
}

private int getBackPosition(String ring, char c) {
    return ring.length() - 1 - new StringBuffer(ring).reverse().toString().indexOf(c);
}
 */
