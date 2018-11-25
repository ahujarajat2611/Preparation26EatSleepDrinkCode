package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String []v1 = version1.split("\\.");
        String []v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i<v1.length || j<v2.length){
            int a= 0;
            if(i<v1.length){
                a = Integer.parseInt(v1[i]);
            }
            int b= 0;
            if(j<v2.length){
                b = Integer.parseInt(v2[j]);
            }
            if(a<b){
                return -1;
            }
            if(a>b){
                return 1;
            }
            // in short return a-b in case a and b are not equal !!!
            //
            i++;
            j++;
        }
        return 0;
    }
}
