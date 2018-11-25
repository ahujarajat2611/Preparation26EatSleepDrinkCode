package OldAttemptLearning.dp;

import java.util.Arrays;

/**
 * Created by hadoop on 11/8/17.
 */
public class LISLCS {
    public static void main(String[] args) {
        int []array = {1,0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int []arrayb = {1,2,2,2};
        System.out.println(findLIS(array));
    }

    private static int findLIS(int[] array) {
        int []arraycopy = array.clone();
        Arrays.sort(arraycopy);
        int pointer =-1;
        for( int i=0;i<arraycopy.length;i++){
            if(pointer == -1 || arraycopy[i] !=arraycopy[pointer]){
                arraycopy[++pointer] = arraycopy[i];
            }
        }
        int []arraycopyagain = new int[pointer+1];
        for( int i=0;i<pointer+1;i++){
            arraycopyagain[i] = arraycopy[i];
        }
        return LCSLENGTH(array,arraycopyagain);
    }

    private static int LCSLENGTH(int[] array, int[] arraycopyagain) {
        int lookup[][]= new int[array.length+1][arraycopyagain.length+1];
        int lcs=  LCSLENGTHHelper(array,arraycopyagain,array.length-1,arraycopyagain.length-1,lookup);
        LCSArray(array,arraycopyagain,array.length,arraycopyagain.length,lookup);
        return lcs;
    }

    private static int LCSLENGTHHelper(int[] array, int[] arraycopyagain, int length, int length1, int[][] lookup) {
        if ( length<0 || length1 < 0){
            return 0;
        }
        if(lookup[length+1][length1+1] !=0) return lookup[length+1][length1+1];
        if(array[length] == arraycopyagain[length1]){
            return lookup[length+1][length1+1]=1+ LCSLENGTHHelper(array,arraycopyagain,length-1,length1-1, lookup);
        }
        else{
            return lookup[length+1][length1+1]=Math.max(LCSLENGTHHelper(array,arraycopyagain,length,length1-1, lookup),LCSLENGTHHelper(array,arraycopyagain,length-1,length1, lookup));
        }
    }

    private static void LCSArray(int[] array, int[] arraycopyagain, int length, int length1, int[][] lookup) {
        if(length ==0 || length1==0){
            return;
        }
        if(array[length-1] == arraycopyagain[length1-1] && lookup[length][length1] == 1+ lookup[length-1][length1-1]){
            LCSArray(array,arraycopyagain,length-1,length1-1,lookup);
            System.out.println(array[length-1]);
        }

        else if(lookup[length][length1] == lookup[length][length1-1] ){
            LCSArray(array,arraycopyagain,length,length1-1,lookup);
        }
        else {
            LCSArray(array,arraycopyagain,length-1,length1,lookup);
        }
    }

    int lcslength(String a,String b, String c,int l1,int l2,int l3){
        if(l1<0 || l2<0 ||l3<0){
            return 0;
        }
        if(a.charAt(l1)==b.charAt(l2) & a.charAt(l1)== c.charAt(l3)){
            return lcslength(a,b,c,l1-1,l2-1,l3-1);
        }
        return Math.max(Math.max(lcslength(a,b,c,l1-1,l2,l3),lcslength(a,b,c,l1,l2-1,l3)),lcslength(a,b,c,l1,l2,l3-1));
    }
}
