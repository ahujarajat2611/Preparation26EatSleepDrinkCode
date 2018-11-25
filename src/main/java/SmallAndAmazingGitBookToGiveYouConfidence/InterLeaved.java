package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class InterLeaved {
    boolean interleaved(String s1,String s2,String s3){
        int len1 = s2.length();
        int len2 = s3.length();
        int len3 = s3.length();
        boolean [][]valid = new boolean[len1+1][len2+1];
        valid[0][0] = true;


        for( int i=1;i<=len1;i++){
            valid[i][0] = valid[i-1][0] && s1.charAt(i-1) == s2.charAt(i-1);
        }
        for( int i=1;i<=len1;i++){
            valid[0][i] = valid[0][i-1] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                valid[i][j] = (valid[i-1][j] && s2.charAt(i-1) ==s1.charAt(i+j-1)) || (valid
                [i][j-1] && s3.charAt(j-1) == s1.charAt(i+j-1));
            }
        }
        return valid[len1][len2];
    }

    public static void main(String[] args) {
        InterLeaved interLeaved = new InterLeaved();
        System.out.println(interLeaved.interleaved("rajat","ra","jt"));
    }

}
