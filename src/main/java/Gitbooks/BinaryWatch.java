package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 15/9/17.
 */
public class BinaryWatch {
    public static void main(String args[]){
        List<String> stringList = new ArrayList<>();
        int []nums1= {8,4,2,1};
        int []nums2 = {32,16,8,4,2,1};
        int n = 1;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int k =n;
        //getnumbers(k,nums1,list1,result,0,0);
        //System.out.println(result);
        for( int i=1;i<=n;i++){
            ArrayList<Integer> left = new ArrayList<>();
            getnumbers(i,nums1,list1,left,0,0);
            System.out.println(left);
            ArrayList<Integer> right = new ArrayList<>();
            getnumbers(n-i,nums2,list1,right,0,0);
            System.out.println(right);
            System.out.println("end");
            for(Integer hour: left){
                for(Integer min:right){
                    System.out.println(left+":"+right);
                }
            }
        }
    }

    private static void getnumbers(int k, int[] nums1, List list1,List result,int index,Integer sum) {
        if(list1.size() == k ){
            result.add(sum);
            return;
        }
        for(int i=index;i<nums1.length;i++){
            sum = sum + nums1[i];
            list1.add(nums1[i]);
            getnumbers(k,nums1,list1,result,i+1,sum);
            list1.remove(list1.size()-1);
            sum = sum - nums1[i];
        }
    }
}
