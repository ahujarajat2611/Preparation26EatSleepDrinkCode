package DSA.Arrays2;

/**
 * Created by hadoop on 20/2/18.
 */
public class FindFirstNegativeNumbers {
    public int findSmallestMissingNumberUsingRecursiveBinarySearchMineNegativeNumbersDiff(int[] a, int l, int r) {

        while (l<r){
            int mid = ((l+r+1)/2);

            System.out.println("l "+l);
            System.out.println("r "+r);
            System.out.println("mid"+mid);
            System.out.println(Math.ceil((double)(l+r)/2));
            if(a[mid]<0){
                l = mid;
            }
            else {
                r = mid-1;
            }
        }
        return r;
    }
    public int findSmallestMissingNumberUsingRecursiveBinarySearchMineNegativeNumbers	(int[] a, int l, int r) {
        while (l<r){
            int mid = (l + r)/2;
            if(a[mid]>=0){
                r = mid;
            }
            else {
                l = mid +1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        FindFirstNegativeNumbers obj = new FindFirstNegativeNumbers();
        int a[] = { -3, -2};
        int n = a.length, result = -1;
        result = obj.findSmallestMissingNumberUsingRecursiveBinarySearchMineNegativeNumbers(a,0,n-1);
        System.out.println(result);
        result = obj.findSmallestMissingNumberUsingRecursiveBinarySearchMineNegativeNumbersDiff(a,0,n-1);
        System.out.println(result);
    }
}
