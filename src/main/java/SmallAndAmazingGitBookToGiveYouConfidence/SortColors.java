package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 19/9/17.
 */
public class SortColors {
    public static void main(String[] args) {
        int []num = {1,3,4,5,5,6,3};
        SortColors sortColors = new SortColors();
        System.out.println(sortColors.countSort(num,6));
    }
    int [] countSort(int []num,int k){
        int []count = new int[k];
        int []result = new int[num.length];
        for( int i=0;i<num.length;i++){
            count[num[i]-1]++;
        }
        for( int i=1;i<k;i++){
            count[i] = count[i]+count[i-1];
        }

        for(int i=num.length-1;i>=0;i--){
            result[--count[num[i]-1]] = num[i];
        }
        for( int i=0;i<count.length;i++){
            System.out.println(count[i]);
        }
        return result;
    }
}
