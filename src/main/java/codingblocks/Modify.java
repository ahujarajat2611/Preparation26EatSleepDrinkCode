package codingblocks;

import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class Modify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String ans = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='5'){
                ans = ans+('9'-s.charAt(i));
            }
            else {
                ans = ans + s.charAt(i);
            }
        }
        System.out.println(ans);
    }
}
