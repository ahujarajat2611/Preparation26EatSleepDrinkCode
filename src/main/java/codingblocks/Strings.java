package codingblocks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class Strings {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test =sc.nextInt();
        String [] array = new String[test];
        int i=0;
        while (test-->0){
            array[i] = sc.next();
            System.out.println(array[i]);
            i++;
        }
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char a[] = o1.toCharArray();
                char b[] =o2.toCharArray();
                int i=0;
                int j=0;
                while (i<a.length && j<b.length){
                    if(a[i]!=b[j]){
                        return a[i]-b[j];
                    }

                }
                return b.length-a.length;
            }
        });
        for (int k=0;k<array.length;k++) {
            System.out.println(array[k]);
        }
    }
}
