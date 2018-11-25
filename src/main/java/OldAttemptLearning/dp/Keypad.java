package OldAttemptLearning.dp;

/**
 * Created by hadoop on 11/8/17.
 */
public class Keypad {
    static int row[] = {0,-1,0,1};
    static int col[] = {-1,0,1,0};
    public static void main(String args[]){

        char [][] array = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'},
                {'*','0','#'}
        };
int n =2;
        Keypad keypad = new Keypad();

        System.out.println(keypad.ans(array,2));
     //   System.exit(1);
        int length[][][] = new int[n+1][array.length][array[0].length];
        for( int i=0;i<array.length;i++){
            for ( int j=0;j<array[0].length;j++){
                if(isValid(i,j)){
                    length[0][i][j] = 1;
                }
            }
        }
        for(int len=1;len<n;len++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    length[len][i][j] =1;
                    for (int k = 0; k <= 3; k++) {
                        if (isValid(i + row[k], j + col[k])) {
                            System.out.println("len" + len);
                            System.out.println("i" + i);
                            System.out.println("j" + j);
                            System.out.println("k"+k);
                            System.out.println("i+row"+(i+row[k]));
                            System.out.println("j+row"+(j+col[k]));
                            length[len][i][j] = length[len][i][j] + length[len - 1][i + row[k]][j + col[k]];
                        }
                        }
                }
            }
        }
        int solution = 0;
        for(int i=0;i<array.length;i++){
            for( int j=0;j<array[0].length;j++){
                if(isValid(i,j))
                solution = solution + length[n-1][i][j];
            }
        }
        System.out.println("solutoin  again"+solution);
    }
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
//        visited[3][1] = true;
//        StringBuilder sb = new StringBuilder();
//        sb.append(matrix[3][1]);
//        ans = ans + numberOfStrings(matrix,3,1,1,visited,sb);
        return ans;
    }
}
