package companywidetests.walmartlabs;

import java.util.Scanner;

/**
 * Created by hadoop on 27/10/17.
 */
public class HikingSelfies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        long options = ((1<<n)-1);
        System.out.println(Math.abs(x-options));
    }
}
