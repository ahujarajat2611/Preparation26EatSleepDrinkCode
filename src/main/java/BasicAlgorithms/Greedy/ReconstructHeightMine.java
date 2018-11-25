package BasicAlgorithms.Greedy;

/**
 * Created by hadoop on 1/3/18.
 */
import java.util.*;
public class ReconstructHeightMine {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[]a,int []b){
                if(a[0] == b[0]){
                    return a[1]-b[1];
                }
                else{
                    return b[0]-a[0];
                }
            }
        });
        List<int[]>list = new ArrayList<int[]>();

        for(int []a:people){
            list.add(a[1],a);
        }
        int ans [][] = new int[people.length][2];
        int index =0;
        for(int []a:list){
            ans[index++] = a;
        }
        return ans;
    }
}
