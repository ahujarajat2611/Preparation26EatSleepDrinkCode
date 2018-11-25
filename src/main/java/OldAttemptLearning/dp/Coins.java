package OldAttemptLearning.dp;

/**
 * Created by hadoop on 12/8/17.
 */
public class Coins {
    public static void main(String[] args) {


        int s[] = {1, 2, 3, 4};

        int total = 15;
        int ans = findmincoints(s, total);
        System.out.println("ans" + ans);
        System.out.println("ways" + totalways(s, 4));
        System.out.println("ways" + totalwaysCorrected(s, 4,0));
        System.out.println("waysagain"+totalwaysagain(s,4,3));
    }

    private static int findmincoints(int[] s, int total) {


        if(total<=0){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for( int i=0;i<s.length;i++) {
            if(total-s[i]>=0) {
                ans = Math.min(ans, 1 + findmincoints(s, total - s[i]));
            }
        }


        return ans;
    }
    private static int totalways(int s[],int total){

        if (total==0){
            return 1;
        }
        if(total<0){
            return 0;
        }
        int ways = 0;
        for(int i=0;i<s.length;i++){
            ways = ways + totalways(s,total-s[i]);
        }
        return ways;
    }

    private static int totalwaysCorrected(int s[],int total, int index){

        if (total==0){
            return 1;
        }

        if(total<0){
            return 0;
        }

        int ways = 0;

        for(int i=index;i<s.length;i++){
            ways = ways + totalwaysCorrected(s,total-s[i],i);
        }
        return ways;
    }

    private static int totalwaysagain(int s[],int total,int n){
        if(total<0){
            return 0;
        }
        if(n<0) return 0;
        if(total == 0){
            return 1;
        }

        return totalwaysagain(s,total,n-1)+totalwaysagain(s,total-s[n],n);
    }

}

