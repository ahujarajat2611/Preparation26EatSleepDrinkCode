package OldAttemptLearning.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by hadoop on 4/8/17.
 */
public class RotatedSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noofelements = scanner.nextInt();
        Integer array[] = new Integer[noofelements];
        for(int i=0;i<noofelements;i++){
            array[i] = scanner.nextInt();
        }
        int element = scanner.nextInt();
        int search = searcharray(array,element);
        System.out.println(search);
    }

    private static int searcharray(Integer[] array,int element) {

        int low = 0;
        int high = array.length -1;

        while(low<high){
            int mid = low + (high-low)/2;
            if(array[mid] == element){
                return mid;
            }
            if(array[mid]<array[high] ){
                if(element>=array[high]){
                    high = mid;
                    
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(element>=array[low]){
                    high = mid;
                }
                else{
                    low = mid +1;
                }
            }
        }
            if(array[low] == element ){
            return low;
            }
            else{
                return -1;
            }
    }
}
