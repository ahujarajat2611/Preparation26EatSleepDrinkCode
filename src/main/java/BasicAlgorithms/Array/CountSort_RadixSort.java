package BasicAlgorithms.Array;

import java.util.Collections;
import java.util.List;

/**
 * Created by hadoop on 17/10/17.
 */
public class CountSort_RadixSort {
//http://opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
    int maxgap(int []num){
        int maxvalue = Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            maxvalue = Math.max(maxvalue,num[i]);
        }
        // we will use radix / count sort method to sort
        int radix = 10; // 10 base system

        int exp = 1; // 1, 10 , 100 .... digits
        while (maxvalue/exp >0){
            int []count = new int[radix];
            for(int i=0;i<num.length;i++){
                count[(num[i]/exp)%10]+=1;
            }
            for(int i=1;i<radix;i++){
                // addding up indexex to get the latest indexes of elements
                count[i] += count[i-1];
            }
            int aux[] = new int[num.length];

            for(int i=num.length-1;i>=0;i--){
               // System.out.println(count[(num[i]/exp)%10]);
                aux[--count[(num[i]/exp)%10]] = num[i];
            }
            for(int i=0;i<num.length;i++){
                num[i]= aux[i];
            }
            exp = exp*10;
        }
        int maxdif = Integer.MIN_VALUE;
        for(int i=1;i<num.length;i++){
            maxdif = Math.max(maxdif,num[i]-num[i-1]);
        }
        return maxdif;
    }
    /*


    http://opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
     int[] countingSort(int[] a, int k) {
        int c[] = new int[k];
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;
        for (int i = 1; i < k; i++)
            c[i] += c[i-1];
        int b[] = new int[a.length];
        for (int i = a.length-1; i >= 0; i--)
            b[--c[a[i]]] = a[i];
        return b;
    }
     */
    public static void main(String args[]){
        CountSort_RadixSort countSort_radixSort = new CountSort_RadixSort();
        System.out.println(countSort_radixSort.maxgap(new int[]{3,1,5,0,9,3,14}));

    }
}
