package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("  a   b "));
    }
    public String reverseWords(String s) {
        if(s == null || s.length() ==0){
            return s;
        }
        int start=0;
        while(start<s.length() && s.charAt(start) ==' '){
            start++;
        }
        int end = s.length()-1;
        while(end>=start && s.charAt(end) ==' '){
            end--;
        }
        if(start<=end){
            return reverseHelper(s.substring(start,end+1));
        }
        else{
            return "";
        }
        
    }
        String reverseHelper(String b){
        int firstNonSpaceindex=0;
        char[] a = b.toCharArray();
        for(int i=0;i<a.length;i++){
            if(a[i]==' '){
                reversesubstring(a,firstNonSpaceindex,i-1);
                while (i<a.length && a[i] ==' '){
                    i++;
                }
                firstNonSpaceindex = i;
            }
            if(i ==a.length-1){
                System.out.println("enter");
                reversesubstring(a,firstNonSpaceindex,i);
            }
        }
        reversesubstring(a,0,b.length()-1);
        return String.valueOf(removeExtraSpaces(a));
    }
    private char[] removeExtraSpaces(char []array){
        int start=0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=' '){
                array[start++] = array[i];
            }
            else{
                int j =i;
                while(j<array.length && array[j]==' '){
                    j++;
                }
                array[start++] = ' ';
                i=j-1;
            }
        }

        char []newarray = new char[start];
        for(int i=0;i<start;i++){
            newarray[i] = array[i];
        }
        return newarray;
        //array[publish++]='\0';
    }

    private void reversesubstring(char[] a, int isspaceindex, int i) {
        while (isspaceindex<i){
            swap(a,isspaceindex,i);
            isspaceindex++;
            i--;
        }

    }

    private void swap(char[] a, int isspaceindex, int i) {
        char temp = a[isspaceindex];
        a[isspaceindex] = a[i];
        a[i] = temp;
    }
}