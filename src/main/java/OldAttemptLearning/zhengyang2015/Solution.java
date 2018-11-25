package OldAttemptLearning.zhengyang2015;

public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public static int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) return 0;

        int lb = 0, ub = Integer.MIN_VALUE;
        // get the upper bound of L
        for (int l : L) if (l > ub) ub = l + 1;

        System.out.println("lb"+lb);
        System.out.println("ub"+ub);
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (C(L, k, mid)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb;
    }

    // whether it cut with length x and get more than k pieces
    private static boolean C(int[] L, int k, int x) {
        int sum = 0;
        for (int l : L) {
            sum += l / x;
        }
        return sum >= k;
    }

    public static void main(String[] args) {
        int L[] ={232, 124, 456};
        int k = 7;
        System.out.println("ans"+woodCut(L,k));
    }
}