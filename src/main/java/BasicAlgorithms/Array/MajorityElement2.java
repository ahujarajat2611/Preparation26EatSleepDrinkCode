/**
 *
 */
package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 * 
 *         Given an integer array of size n, find all elements that appear more than n/3 times. The algorithm
 *         should run in linear time and in O(1) space.
 */
public class MajorityElement2 {

    // Time : O(n), Space : O(1)
    public List<Integer> majorityElement(int[] a) {
        List<Integer> res = new ArrayList<>();
        int cand1 = 0, cand2 = 0, c1 = 0, c2 = 0;

        for (int n : a) {
            if (n == cand1) {
                c1++;
                // v.imp
            } else if (n == cand2) {
                c2++;
                //v.imp
            } else if (c1 == 0) {
                cand1 = n;
                c1 = 1;
                //v.imp
            } else if (c2 == 0) {
                cand2 = n;
                c2 = 1;
                //v .imp
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int n : a) {
            if (n == cand1) {
                c1++;
            } else if (n == cand2) {
                c2++;
            }
        }
        if (c1 > a.length / 3) {
            res.add(cand1);
        }
        if (c2 > a.length / 3) {
            res.add(cand2);
        }
        return res;

    }
    public int majorityElementSIngle(int[] a) {
        int count = 0, candidate = 0;
        for (int n : a) {
            if (candidate == n) {
                count++;
            } else if (count == 0) {
                candidate = n;
                count = 1;
            } else {
                count--;
            }
        }

        count = 0;
        for (int n : a) {
            if (n == candidate) {
                count++;
            }
        }
        return count > a.length / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        MajorityElement2 obj = new MajorityElement2();
        List<Integer> result = null;
        int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4 };

        result = obj.majorityElement(a);
        System.out.println(result);

    }
    /*

    CAN NOT DO THIS WAY .. SO BETTER YOU DO IT LIKE ITS DONE ABOVVE


        List<Integer> res = new ArrayList<>();
        if(a.length<1){
            return res;
        }
        if(a.length ==1){
            res.add(a[0]);
            return res;
        }
        int cand1 = a[0], cand2 = a[1], c1 = 1, c2 = 1;

        for(int i=1;i<a.length;i++){
            if(a[i]!=cand1){
                System.out.println(a[i]);
                cand2=a[i];
                c2 =1;
                break;
            }
        }
     //   for (int n : a) {
        for(int i=2;i<a.length;i++){
            int n = a[i];
            if (n == cand1) {
                c1++;
            } else if (n == cand2) {
                c2++;

            }
            else {
                c1--;
                c2--;
            }
            if(c1 == 0){
                cand1 = n;
                c1=1;
            }
            else if(c2 ==0){
                cand2 = n;
                c2 = 1;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int n : a) {
            if (n == cand1) {
                c1++;
            } else if (n == cand2) {
                c2++;
            }
     */

}
