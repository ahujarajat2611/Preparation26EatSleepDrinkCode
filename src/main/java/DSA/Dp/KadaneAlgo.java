package DSA.Dp;

/**
 * Created by hadoop on 1/9/17.
 */
public class KadaneAlgo {
    public static void main(String args[]) {
        int num[] = {10, -3, -4, 7, 6, 5, -4, -1};
        int ans = find_sum(num);
    }

    private static int find_sum(int[] num) {
        int i=0;
        int total = 0;
        int maxlocal = 0;
        int minlocal = 0;
        int maxglobal=0;
        int minglobal=0;
        while(i<num.length){
            maxlocal = maxlocal+ num[i];
            minlocal = minlocal + num[i];
            total = total + num[i];

            if(maxlocal >maxglobal){
                maxglobal = maxlocal;
            }
            if(minlocal<minglobal){
                minglobal = minlocal;
            }
            if(minlocal>=0){
                minlocal =0;
            }
            if(maxlocal<0){
                maxglobal = 0;
            }
        }
        if(total - minglobal>maxglobal){
            return total-minglobal;
        }
        else {
            return maxglobal;
        }
    }
}
