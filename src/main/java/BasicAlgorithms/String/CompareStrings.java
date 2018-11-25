package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class CompareStrings {
    public boolean compareStrings(String A, String B) {
        int []count = new int[256];
        for(char c:A.toCharArray()){
            count[c]++;
        }
        int totalelement=0;
        for(char d:B.toCharArray()){
            if(count[d]>0){
                count[d]--;
                totalelement++;
            }
        }
        if(totalelement == B.length()){
            return true;
        }
        return false;
    }
}