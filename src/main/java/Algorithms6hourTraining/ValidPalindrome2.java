package Algorithms6hourTraining;

/**
 * Created by hadoop on 21/12/17.
 */
// Keep matching like standard palindrom match but once we get mismatch
    // either forward 1 travese and restart the matching algo
    // or backward 1 travesers andd restart the matching algo
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {

        int i = 0, j = s.length() - 1;
        // be carful if you need i<j ot i<=j there is lot of differnence in that FYI
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++; j--;
        }
        if (i >= j) return true;

        // here are given that any char can be off state
        // so we are taking both cases and see what can give us result !!!!

        if(isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1)){
            return true;
        }
        return false;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}