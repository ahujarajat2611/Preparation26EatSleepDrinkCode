package BasicAlgorithms.String;
import java.util.*;

/**
 * Created by hadoop on 25/12/17.
 */
public class IsSubSequence {
    private boolean isSubSeq(String s, String p) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == p.length();
    }

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else {
                    return o2.length()-o1.length();
                }
            }
        });
        for(String a:d){
            System.out.println(a);
            System.out.println(s);
            if(isSubSeq(s,a)){
                return a;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        IsSubSequence s = new IsSubSequence();
        String a = "abpcplea";
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(s.findLongestWord(a,list));
    }
}