package Gitbooks.Chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 17/9/17.
 */
public class RotateString {
    public void rotateString(char[] str, int offset) {
        List<Integer> list = new ArrayList<>();
        list.toArray();
        // write your code here
        reverse(str,0,str.length-1);
        reverse(str,0,offset-1);
        reverse(str,offset,str.length-1);
    }
    public static void reverse(char []array,int start,int end){
        while(start<end){
            swap(array,start,end);
            start++;
            end--;
        }
    }
    public static void swap(char []array,int a,int b){
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
