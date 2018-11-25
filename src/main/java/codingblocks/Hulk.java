package codingblocks;

import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class Hulk {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-->0){
            int number = sc.nextInt();
            int ans = 0;
            while (number!=0){
                number = number & (number-1);
                ans++;
            }
            System.out.println(ans);
        }
    }
}
