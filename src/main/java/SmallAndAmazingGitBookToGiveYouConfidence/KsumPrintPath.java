package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;

/**
 * Created by hadoop on 22/9/17.
 */
public class KsumPrintPath {
    public ArrayList<ArrayList<Integer>> ksum2(int []array,int k,int target){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfshelper(result,path,0,array,target,k);
        return result;
    }

    private void dfshelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int index, int array[],int target, int k) {
            if(target<0){
                return;
            }
            if(k<0){
                return;
            }
            if(target == 0 && k ==0 ){
                result.add(new ArrayList<>(path));
                return;
            }
            if(path.size() == array.length){
                if(target == 0 && k ==0){
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            for(int i =index;i<array.length;i++){
                path.add(array[i]);
                target = target -array[i];
                k =k-1;
                dfshelper(result,path,i+1,array,target,k);
                target = target + array[i];
                path.remove(path.size()-1);
                k =k+1;
            }
    }
    public static void main(String args[]){
        KsumPrintPath ksumPrintPath = new KsumPrintPath();
        int []array = {1,2,3,4};
        int k =2;
        int target = 5;
        System.out.println(ksumPrintPath.ksum2(array,k,target));
    }
}
