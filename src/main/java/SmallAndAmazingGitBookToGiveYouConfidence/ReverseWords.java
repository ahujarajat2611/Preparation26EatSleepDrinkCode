package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class ReverseWords {
    String reverse(String b){
        int firstNonSpaceindex=0;
        char[] a = b.toCharArray();
        for(int i=0;i<a.length;i++){
            if(a[i]==' '){
                reversesubstring(a,firstNonSpaceindex,i-1);
//                while (i<a.length && a[i] ==' '){
//                    i++;
//                }
                firstNonSpaceindex = i+1;
            }
            System.out.println("index is"+i);
            if(i ==a.length-1){
                reversesubstring(a,firstNonSpaceindex,i);
            }
        }
        reversesubstring(a,0,b.length()-1);
        return String.valueOf(a);
    }

    private void reversesubstring(char[] a, int isspaceindex, int i) {
        while (isspaceindex<i){
            swap(a,isspaceindex,i);
            isspaceindex++;
            i--;
        }

    }

    private void swap(char[] a, int isspaceindex, int i) {
        char temp = a[isspaceindex];
        a[isspaceindex] = a[i];
        a[i] = temp;

    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverse("rajat      is     good"));
    }
}
