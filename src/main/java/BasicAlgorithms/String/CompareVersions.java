package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class CompareVersions {
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
            System.out.println("a"+a);
            System.out.println("b"+b);
            if(a<b){
                return -1;
            }
            if(a>b){
                return 1;
            }
            System.out.println("a"+a);
            System.out.println("b"+b);
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersions compareVersions = new CompareVersions();
        System.out.println(compareVersions.compareVersion("1.0","1"));
    }
}