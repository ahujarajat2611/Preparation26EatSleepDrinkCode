package BasicAlgorithms.BackTracking;

import java.util.ArrayList;
import java.util.List;
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        k = k-1;
        return perHelper(list,k);
    }
    String perHelper(List<Integer> list,int k){
        String out ="";
        if(list.size()==0){
            return out;
        }
        int size = list.size();
        int item = (k)/fact(size-1);
        out = out +list.get(item);
        list.remove(item);
        k = k%fact(size-1);
        out = out + perHelper(list,k);
        return out;
    }
    private int fact(int i) {
        if(i ==0){
            return 1;
        }
        if(i ==1){
            return 1;
        }
        return i*fact(i-1);
    }
}