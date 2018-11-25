package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class KsumDFS{

    public int ksum(int []array,int k , int target){
        if(k<1||k >array.length){
            return 0;
        }
        return ksumhelper(array,k,target,0);
    }

    private int ksumhelper(int[] array, int k, int target, int index) {
        int totalways = 0;
        if(target<0){
            return 0;
        }
        if(k<0){
            return 0;
        }
        if(k == 0){
            if(target ==0) return 1;
            return 0;
        }
        for(int i=index;i<array.length;i++){
            target = target-array[i];
            totalways +=ksumhelper(array,k-1,target,i+1);
            target = target+array[i];
        }
        return totalways;
    }
}
