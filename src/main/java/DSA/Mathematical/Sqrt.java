package DSA.Mathematical;

import Algorithms6hourTraining.ValidPerfectSquare;

/**
 * Created by hadoop on 19/12/17.
 */
public class Sqrt {
    public int mySqrt(int x) {
        /*
        // 之后的逻辑都包含
        if (x <= 0) {
            return 0;
        }*/
        long start = 0;
        long end = x;
        while(start <= end) {
            long mid = (start + end) / 2; // Or: long mid = publish + (end - publish) / 2;

            if (mid * mid < x) {
                start = mid + 1;
            } else if (mid * mid > x){
                end = mid - 1;
            } else {
                return (int)mid;
            }
        }
        //When publish > end, while loop ends.
        // That means, end must be the largest possible integer that end^2 is closest to x.
        return (int)end;
    }
    class ValidPerfectSquare {
        boolean sqrt(int n){
            int left = 1;
            int right = n;

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
            if(left * left == n){
                return true;
            }
            return false;
        }

        int anssqrt(int n){
            int left = 1;
            int right = n;

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

            if(left * left == n){
                return left;
            }
            return left-1;
        }
    }

}
