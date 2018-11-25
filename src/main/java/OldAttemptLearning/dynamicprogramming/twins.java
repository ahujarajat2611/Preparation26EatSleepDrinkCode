package OldAttemptLearning.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by hadoop on 4/8/17.
 */
public class twins{
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String line = sc.nextLine();

        int odd= 1;
        int even = 0;
        int i=0;

        while(odd<line.length() && even<line.length()){
            if(odd +2<line.length()) {
                if (line.charAt(odd) == line.charAt(odd + 2)) {
                    i++;
                }
            }
            if(even +2<line.length()) {
                if (line.charAt(even) == line.charAt(even + 2)) {
                    i++;
                }
            }
            odd= odd+2;
            even= even+2;
        }
        System.out.println(i);
    }
}
