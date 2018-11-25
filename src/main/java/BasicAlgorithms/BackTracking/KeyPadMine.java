package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 4/3/18.
 */
public class KeyPadMine {
    static int row[] = {0,-1,0,1};
    static int col[] = {-1,0,1,0};
    public static boolean isValid(int i,int j){
        if((i==3)&& (j==0 || j==2)){
            return false;
        }
        return i>=0 && i<=3 && j>=0 && j<=2;
    }



    int numberOfStrings(char [][]array,int i, int j , int n,boolean [][] visited,StringBuilder sb ){
        if( n ==0){
            System.out.println(sb.toString());
            return 1;
        }
        int totalways = 0;

        for(int k =0;k<4;k++){
            int newx  = i + row[k];
            int newy  = j + col[k];

            if(isValid(newx,newy) && !visited[newx][newy]) {
//                System.out.println("char "+array[newx][newy]);
//                System.out.println("new x"+newx);
//                System.out.println("new y"+newy);
                sb.append(array[newx][newy]);
                visited[newx][newy] = true;
                totalways = totalways + numberOfStrings(array,newx,newy,n-1,visited,sb);
                visited[newx][newy] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return totalways;
    }
    int ans (char [][]matrix,int n){
        int ans = 0;
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(isValid(i,j) ) {
                    visited[i][j] = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(matrix[i][j]);
                    ans = ans + numberOfStrings(matrix, i, j, n-1,visited,sb);
                    System.out.println("============  ============");
                    visited[i][j] = false;
                }
            }
        }
        return ans;
    }
}
