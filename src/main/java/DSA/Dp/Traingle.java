package DSA.Dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 4/9/17.
 */
public class Traingle {
    static int minvalue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String lowerCaseCarrierName = "time warnerwifiajgdfadf";
        if(lowerCaseCarrierName.contains("wifi")){
            System.out.println("entering");
        }

        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));

        int ans = maximumsum(list);
    }

    private static int maximumsum(ArrayList<List<Integer>> list) {
        int n = list.size();
        int [][]sum = new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(sum[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            sum[n-1][i] = list.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                sum[i][j] = Math.min(sum[i+1][j],sum[i+1][j+1])+list.get(i).get(j);
            }
        }
        return sum[0][0];
    }

    private static int search(ArrayList<List<Integer>> triangle){
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int [][]sum = new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(sum[i],Integer.MAX_VALUE);
        }
        return searchagain(0,0,n,triangle);
    }

    private static int searchagain(int x, int y, int n, ArrayList<List<Integer>> triangle) {
        if(x == n-1){
            return triangle.get(n-1).get(y);
        }
        return Math.min(searchagain(x+1,y,n,triangle),searchagain(x+1,y+1,n,triangle)) + triangle.get(x).get(y);
    }

}
