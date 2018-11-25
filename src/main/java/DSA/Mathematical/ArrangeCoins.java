package DSA.Mathematical;

/**
 * Created by hadoop on 16/2/18.
 */
public class ArrangeCoins {
    public int arrangeCoins(int n) {
        long nLong = (long) n;
        long left = 1, right = nLong;
        long mid = 0;
        if(n ==1){
            return 1;
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            long tot = (mid * (mid + 1)) / 2;
            //System.out.println(left);
            //System.out.println(right);
            if(tot == nLong){
                return (int)mid;
            }
            if(tot <nLong){
                //  System.out.println(tot);
                left = mid+1;
            }
            else {
                right = mid;
            }
//			if (tot > nLong) {
//				right = mid - 1;
//			} else {
//				left = mid + 1;
//			}
        }
        return (int) (left-1);
    }

    public int arrangeCoinsOn(int n) {
        int i = 1;
        while (n - i >= 0) {
            n = n - i++;
        }
        return i - 1;
    }
}
