package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.Arrays;

/**
 * Created by hadoop on 22/9/17.
 */
public class SmallestDifference {
    public int smallestDiff(int []a,int []b){
        Arrays.sort(a);
        Arrays.sort(b);
        int index1=0;
        int index2=0;
        int mindiff = Integer.MAX_VALUE;
        while (index1<a.length && index2 <b.length){
            mindiff = Math.min(mindiff,Math.abs(a[index1]-b[index2]));
            if(mindiff ==0){
                return 0;
            }
            if(a[index1]<b[index2]){
                index1++;
            }
            else {
                index2++;
            }
        }
        return mindiff;
    }
}
