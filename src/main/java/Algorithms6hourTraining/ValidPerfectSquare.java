package Algorithms6hourTraining;

/**
 * Created by hadoop on 21/12/17.
 */
// left starts with 1
    // right ends with n

    // My Binary Search Approach
public class ValidPerfectSquare {
    boolean sqrt(int n){
        int left = 1;
        int right = n;

        // Standard Bs Algo !!!
        while (left<right){

            int mid = left + (right-left)/2;
            System.out.println(mid);
            if(mid<n/mid){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        // if it is not valid and you have to return the lowest ans
        // in that case return left -1;
        if(left * left == n){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        validPerfectSquare.sqrt(808201);
    }
}
