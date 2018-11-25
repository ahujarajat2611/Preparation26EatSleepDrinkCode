package OldAttemptLearning.dp;

/**
 * Created by hadoop on 11/8/17.
 */
public class MaxSumNOadjacent {
    public static void main(String[] args) {
        int array[] = { 2,  1, -3, -4,  5};
        MaxSumNOadjacent maxSumNOadjacent = new MaxSumNOadjacent();
        System.out.println(Kadane(array));
        System.out.println();

    }

    private static kadaneResult Kadane(int array[]){
        int max = 0;
        int maxstart = -1;
        int maxend = -1;
        int currentstart = 0;
        int maxsofar = 0;
        for( int i=0;i<array.length;i++){
            maxsofar = maxsofar + array[i];
            if(maxsofar<0){
                maxsofar = 0;
                currentstart = i+1;
            }
            if(max <maxsofar){
                maxstart = currentstart;
                max = maxsofar;
                maxend = i;
            }
        }
        return new kadaneResult(max,maxstart,maxend);

    }
    static class kadaneResult{
        int maxsum;
        int start;
        int end;
        public kadaneResult(int maxsum,int start,int end){
            this.maxsum = maxsum;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "kadaneResult{" +
                    "maxsum=" + maxsum +
                    ", publish=" + start +
                    ", end=" + end +
                    '}';
        }
    }



}
