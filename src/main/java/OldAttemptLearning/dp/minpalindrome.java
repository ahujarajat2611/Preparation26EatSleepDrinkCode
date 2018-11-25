package OldAttemptLearning.dp;

import java.util.Arrays;

/**
 * Created by hadoop on 11/8/17.
 */
public class minpalindrome {
    public static boolean ispandrome(String a, int i,int j){
        if(i<=j){
            if(a.charAt(i)!=a.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int minpalindrome(String a, int i, int j){
        if(ispandrome(a,i,j)){
            return 0;
        }

        if(i>=j)
            return 0;
        int count = Integer.MAX_VALUE;
      //  System.out.println("i value" + i);
       // System.out.println("j value "+ j);
        for( int k = i;k<j;k++){
         //   System.out.println(" k value "+k);
            count = Math.min(count,1 + minpalindrome(a,i,k) + minpalindrome(a,k+1,j));
        }
        return count;
    }

    public static void main(String[] args) {
        String x = "BAB  ABCBA  DCD";
        String y = "abcd";
//        System.out.println("min count "+minpalindrome(y,0,x.length()-1));
       // constructarray(x);
        //System.out.println("new  min count "+a(y,0));
        System.out.println("cuts "+moreoptimizediterative("abcdfe"));
    }
    public static boolean [][]array;

    public static  void constructarray(String a){
        int n = a.length();
        array = new boolean[n][n];

        for(int i=0;i<n;i++){
            array[i][i] = true;
        }
        for(int i=0;i<n-1;i++){
            if(a.charAt(i) == a.charAt(i+1)){
                array[i][i+1] = true;
            }
        }
        for( int diaglength = 3;diaglength<=n;diaglength++){
            for ( int i=0;i<=n-diaglength;i++){
                int j = diaglength+i-1;
               // System.out.println("i value"+i);
                //System.out.println("j val
                // ue "+j);
                array[i][j] = array[i+1][j-1] && a.charAt(i) == a.charAt(j);
            }
        }
        for( int i =0;i<n;i++){
            for ( int  j = 0;j<n;j++){
              //  System.out.print(array[i][j]+" ");
            }
            //System.out.println();
        }
        boolean [][] arrayb = new boolean[n][n];
        for( int i = n-1;i>=0;i--){
            for( int j=i;j<n;j++){
               // System.out.println("index i"+i);
               // System.out.println("index j"+j);
                if(i==j){
                    arrayb[i][j] = true;
                }
                else if(j-i+1==2){
                    arrayb[i][j] =(arrayb[i] == arrayb[j]);
                }
                else {
                    arrayb[i][j] = arrayb[i+1][j-1]  && a.charAt(i) == a.charAt(j);
                }
            }
        }
        System.out.println();
        for( int i =0;i<n;i++){
            for ( int  j = 0;j<n;j++){
                //System.out.print(arrayb[i][j]+" ");
                if(arrayb[i][j]!=array[i][j]){
                   // System.out.println(arrayb[i][j]);
                    //System.out.println(array[i][j]);
                    //System.out.println("diff"+i);
                    //System.out.println("diff"+j);
                    //System.exit(1);
                }
            }
            //System.out.println();
        }
    }
    public static int minpartitionoptimizedstate(String a,int start){
        int n = a.length();
        if(start == n-1){
            return 0;
        }
        if(ispandrome(a,start,n-1)){
            return 0;
        }
        System.out.println("publish value "+start);
        int count = Integer.MAX_VALUE;
//        for( int i=publish;i<n-1;i++){
            for( int j = start +1;j<n;j++){
                System.out.println("j value "+j);
               // System.out.println("count "+count);
                count = Math.min(count,1 + minpartitionoptimizedstate(a,j));
                System.out.println("count after"+count);
//            }
        }
        return count;
    }

    public static int moreoptimizediterative(String a ){
        int lookup[] = new int[a.length()];
        //System.out.println(lookup[0]);
        Arrays.fill(lookup,Integer.MAX_VALUE);
        for( int end=0;end<a.length();end++){
            //lookup[end] = Integer.MAX_VALUE;
            if(ispandrome(a,0,end)){
                lookup[end] = 0;
            }
            for ( int i=0;i<=end;i++){
//                if(ispandrome(a,i,end)){
//                  lookup[end] = 1 + lookup[i];
//                }
                if(ispandrome(a,i+1,end)) {
                    lookup[end] = Math.min(lookup[end], 1 + lookup[i]);
                    System.out.println("lookup[end"+lookup[end]);
                }

            }
        }
        return lookup[a.length()-1];
    }

}
