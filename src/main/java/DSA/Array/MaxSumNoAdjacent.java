package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class MaxSumNoAdjacent {
    int maxSumNonAdjascnent(int a[]) {
        int maxsum[] = new int[a.length+1];
        maxsum[0] = 0;
        ///// WTF MOMENTTTT SHIT I HAD NOT THINK OF THIS CASE
        // THATS WHY WORKING ON PAPER MAKES SENSE
        maxsum[1] = Math.max(0,a[0]);
        for(int i=2;i<maxsum.length;i++){
            maxsum[i] = Math.max(maxsum[i-2]+a[i-1],maxsum[i-1]);
        }
        return maxsum[maxsum.length-1];
    }

    public static void main(String[] args) {
        MaxSumNoAdjacent maxSumNoAdjacent = new MaxSumNoAdjacent();
        int []array = {-4,5,100,3,-4,23};
        System.out.println(maxSumNoAdjacent.maxSumNonAdjascnent(array));
        System.out.println(maxSumNoAdjacent.maxSumNonAdjascnent(array,array.length));
    }
    int maxSumNonAdjascnent(int a[], int n) {
        if (n <= 0)
            return -1;
        int incl = a[0], excl = 0, temp;

        if (n == 1)
            return incl;

        for (int i = 1; i < n; i++) {
            temp = incl;
            incl = Math.max(excl + a[i], a[i]);
            excl = temp;
        }
        return incl;
    }
}
