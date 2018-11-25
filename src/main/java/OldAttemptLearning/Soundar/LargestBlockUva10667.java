package OldAttemptLearning.Soundar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by hadoop on 12/8/17.
 */
public class LargestBlockUva10667 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        int [][]matrix = null;
        for( int testcase = 0;testcase<testcases;testcase++){
            int n = Integer.parseInt(br.readLine());
            matrix = new int[n][n];
            for( int []array:matrix){
                Arrays.fill(array,1);
            }
        }
        int blocks = Integer.parseInt(br.readLine());
        for( int i=0;i<blocks;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int xmin = Integer.parseInt(stringTokenizer.nextToken());
            int xmax = Integer.parseInt(stringTokenizer.nextToken());
            int ymin = Integer.parseInt(stringTokenizer.nextToken());
            int ymax = Integer.parseInt(stringTokenizer.nextToken());

            for( int j=xmin;j<=xmax;j++){
                for( int k = ymax;k<ymin;k++){
                    matrix[j-1][k-1] = -123456;
                }
            }
        }

//        int temp[] = {1,2,-3,-4,5};
//        kadane kad = kadanonedim(temp);
//        System.out.println(kad.maxsum);
//        System.out.println(kad.startcolumn);
//        System.out.println(kad.endcolumn);

    }
    public static int findmaxsubmatrix(int [][]matrix){
        int [][]sum = new int[matrix.length+1][matrix[0].length+1];
        for( int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0){
                    sum[i][j] = 0;
                }
                else{
                    sum[i][j] = matrix[i][j] + sum[i][j-1]+sum[i-1][j] -sum[i-1][j-1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int rowstart = -1;
        int rowend = -1;
        int columntart = -1;
        int columnend = -1;

        for( int i=0;i<matrix.length;i++){
            for( int j=i;j<matrix.length;j++){
                for(int m=0;m<matrix[0].length;m++){
                    for( int n = m;n<matrix[0].length;n++){

                        int submatrixsum = sum[j+1][n+1]-sum[i][n+1]-sum[j+1][m] +sum[i][m];
                        if(submatrixsum > max){
                            max = submatrixsum;
                            rowstart = i;
                            rowend = j;
                            columntart = m;
                            columnend = n;
                        }
                    }
                }

            }
        }
        System.out.println("maxsum "+max);
        return max;
    }
    public static int findmaxsubusingkadan(int [][]matrix){
        int max = Integer.MIN_VALUE;
        int rowstart = -1;
        int rowend = -1;
        int columnstart = -1;
        int columnend = -1;
        int []temp = new int[matrix[0].length];
        for( int i=0;i<matrix.length;i++){
            for(int k=0;k<matrix[0].length;k++){
                temp[k] = 0;
            }
            Arrays.fill(temp,0);
            for (int j=i;j<matrix.length;j++){
                for(int col=0;col<matrix[0].length;col++){
                    temp[col] = temp[col]+ matrix[j][col];
                }
                kadane ka = kadanonedim(temp);
                if(ka.maxsum>max){
                    max = ka.maxsum;
                    rowstart = i;
                    rowend = j;
                    columnstart = ka.startcolumn;
                    columnend  =ka.endcolumn;
                }

            }
        }
        return max;
    }
    static class kadane{
        int startcolumn;
        int endcolumn;
        int maxsum;

        public kadane(int startcolumn, int endcolumn, int maxsum) {
            this.startcolumn = startcolumn;
            this.endcolumn = endcolumn;
            this.maxsum = maxsum;
        }
    }

    public static kadane kadanonedim( int [] temp){
        int max = Integer.MIN_VALUE;
        int startcolumn = -1;
        int startcolumntemp = 0;
                int endcolumn = -1;
        int maxsofar=0;

        for( int i=0;i<temp.length;i++){
            maxsofar = maxsofar +temp[i];
            if(maxsofar<0){
                maxsofar=0;
                startcolumntemp = i+1;
            }
            if(maxsofar>max){
                max = maxsofar;
                endcolumn = i;
                startcolumn = startcolumntemp;
            }
        }
        return new kadane(startcolumn,endcolumn,max);
    }
}
