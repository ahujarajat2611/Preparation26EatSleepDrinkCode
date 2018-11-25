package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 26/3/18.
 */
public class HashCode {
    private long computeHashCode (String str) {
        int[] count = new int[26];
        for (char c: str.toCharArray()) {
            ++count[c - 'a'];
        }

        long hashCode = 17;

        for (int val: count) {
            hashCode = hashCode * 31 + val;
        }
        return hashCode;
        // in java string we use
        //s[0]*31^(n-1) + s[1]*31^(n-2) + … + s[n-1]
        // mind u u r calcultaing hashcode of ocunt array
        //
    }

    public static void main(String[] args) {
        HashCode hashCode = new HashCode();
        System.out.println(hashCode.computeHashCode("abc"));
        System.out.println(hashCode.computeHashCode("bca"));
    }
}
