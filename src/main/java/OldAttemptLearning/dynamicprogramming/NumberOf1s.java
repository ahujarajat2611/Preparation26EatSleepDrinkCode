package OldAttemptLearning.dynamicprogramming;

/**
 * Created by hadoop on 3/8/17.
 */
public class NumberOf1s {
    public static void main(String args[]){
        //System.out.println(number(7));
        Integer cache [] = new Integer[7];
        for (int i=0;i<7;i++){
            cache[i] = -1;
        }
        number(7,cache);
        int array[] = new int[7];
        for(int i=0;i<7;i++){
            array[i] = cache[i];
        }
    }

   private static int number(int x,Integer [] cache){

        if(x == 0){
            System.out.println("0");
            return 0;
        }
        if(x == 1){
            System.out.println("1");
            return 1;
        }
        if(cache[x]!=-1) return cache[x];
        cache[x] = (number(x/2,cache)) + (x&1);
        return (number(x/2,cache)) + (x&1);
    }
    private class Solution {
        public int[] countBits(int num) {
            Integer cache [] = new Integer[num+1];
            for (int i=0;i<=num;i++){
                cache[i] = -1;
            }
            for(int i=num;i>=0;i--){
                number(i,cache);
            }
            int array[] = new int[num+1];
            for(int i=0;i<=num;i++){
                array[i] = cache[i];
            }
            return array;
        }


        private  int number(int x,Integer [] cache){
            if(x == 0){
                cache[x] =0;
                return 0;
            }
            if(x == 1){
                cache[x] = 1;
                return 1;
            }
            if(cache[x]!=-1) return cache[x];
            cache[x] = (number(x/2,cache)) + (x&1);
            return (number(x/2,cache)) + (x&1);
        }
    }
}
