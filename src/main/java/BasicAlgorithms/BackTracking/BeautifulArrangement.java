package BasicAlgorithms.BackTracking;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 25/12/17.
 */
public class BeautifulArrangement {
    private int dfs(int startIndex,List<Integer> list,int N, boolean[] visited, int[] array) {
        if(list.size()+1>= N){
            //System.out.println(list);
            // returning 1
            // once we reach at end
            return 1;
        }
        int nways = 0;
        for(int i=startIndex;i<N;i++){
            if(!visited[i] && (array[i]%(list.size()+1)==0 || (list.size()+1)%array[i]==0)){
//                System.out.println(array[i]);
//                System.out.println(i);
//                System.out.println("i%array[i] "+i%array[i]);
//                System.out.println("array[i]%i "+array[i]%i);
                // calculating permutations usually its n!
                // with some condition it's not combination for sure !!!
                // so we need to tweak permutation code only ....
                // .. so here
                visited[i] = true;
                list.add(array[i]);
                nways+= dfs(startIndex,list,N,visited,array);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
        return nways;
    }

    public int countArrangement(int N) {
        int []array = new int[N+1];
        boolean []visited = new boolean[N+1];
        for(int i=1;i<N+1;i++){
            array[i] = i;
        }
        List<Integer> list = new ArrayList<Integer>();
        //List<List<Integer>> result = new ArrayList<>();
        return dfs(1,list,N+1,visited,array);
    }

    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(3));
    }
    int count =0;
    public int countArrangementSimpler(int N) {
        if (N == 0) return 0;
        helperSimpler(N, 1, new int[N + 1]);
        return count;
    }

    private void helperSimpler(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        // WATTA SOLUTION
        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helperSimpler(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }

    /*

1,n,2,n-1,3,n-2,4… ==> Diff: n-1, n-2, n-3, n-4, n-5…

By following this pattern, k numbers will have k-1 distinct difference values;

and all the rest numbers should have |ai - a_i-1| = 1;

In total, we will have k-1+1 = k distinct values.

    */
    class Solution {
        public int[] constructArray(int n, int k) {
            if(k>=n) return null;
            int[] arr = new int[n];
            int i = 0, small = 1, large = n;
            while(i<k){
                arr[i++] = small++;
                if(i<k) arr[i++] = large--;
            }
            if(k%2 == 0){ // k==2 ==> 1, 6, 5,4,3,2
                while(i<arr.length) arr[i++] = large--;
            } else { // k==3 ==> 1,6,2,3,4,5
                while(i<arr.length) arr[i++] = small++;
            }
            return arr;
        }
    }
}