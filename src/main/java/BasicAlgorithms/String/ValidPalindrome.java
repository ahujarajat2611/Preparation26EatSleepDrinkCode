package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !isValid(s.charAt(i))) {
                i++;
            }
            while (i < j && !isValid(s.charAt(j))) {
                j--;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isValid(char c) {
        if(!(c>='a' && c<='z') && !(c>='A' && c<='Z') && !(c>='0' && c<='9')){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n =40;
        String total_n = String.format("%4d", n);
        System.out.println(total_n);
        String s = "A man, a plan, a canal: Panama";
        s= s.toLowerCase();
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(s));
    }
}