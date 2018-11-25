package OldAttemptLearning.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 5/8/17.
 */
public class WildCardMatching {
    static Map<Pair, Boolean> cache = new HashMap<Pair, Boolean>();

    public static void main(String[] args) {

//        "abefcdgiescdfimde"
//        "ab*cd?i*de"
        String s = "abefcdgiescdfimde";
        String p = "ab*cd?i*de";

        Map<Pair, Boolean> cache = new HashMap<Pair, Boolean>();
//        Boolean cache [][] = new Boolean[s.length()+1][p.length()+1];
        //   Arrays.fill(cache,false);
        boolean result = ismatchingagainbottomup(s, p);
        System.out.println("rasule" + result);
    }

    private static boolean isMatch(String s, String p) {


        p ="**ho";
        char[] pattern = p.toCharArray();
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        for(int i=0;i<pattern.length-1;i++){
            System.out.println(pattern[i]);
        }
        boolean returnvalue = isMatchHelper(s.toCharArray(), pattern, s.length() - 1, pattern.length - 2);
        return returnvalue;
    }

    private static boolean isMatchHelper(char[] s, char[] p, int sindex, int pindex) {

        if (sindex == -1) {
            for (int i = 0; i <= pindex; i++) {
                if (p[i] != '*') {
                    return false;
                }
            }
            return true;
        }
        if (cache.containsKey(new Pair<Integer, Integer>(sindex, pindex))) {
            return cache.get(new Pair<Integer, Integer>(sindex, pindex));
        }

        if (sindex == -1 && pindex == -1) {
            return true;
        }
        if (sindex == -1 && pindex != -1) {
            return false;
        }
        if (sindex != -1 && pindex == -1) {
            return false;
        }

        if (s[sindex] == p[pindex]) {
            Boolean value = isMatchHelper(s, p, sindex - 1, pindex - 1);
            cache.put(new Pair<Integer, Integer>(sindex, pindex), value);
            return value;
        }

        if (p[pindex] == '?') {
            Boolean value = isMatchHelper(s, p, sindex - 1, pindex - 1);
            cache.put(new Pair<Integer, Integer>(sindex, pindex), value);
            return value;
        }

        if (p[pindex] == '*') {
            Boolean value = isMatchHelper(s, p, sindex, pindex - 1) || isMatchHelper(s, p, sindex - 1, pindex) || isMatchHelper(s, p, sindex - 1, pindex - 1);
            cache.put(new Pair<Integer, Integer>(sindex, pindex), value);
            return value;
        }

        cache.put(new Pair<Integer, Integer>(sindex, pindex), false);
        return false;
    }
    public static boolean ismatchingagainbottomup(String s, String p){
        if(p==null || p.length() == 0){
            return s== null || s.length() ==0;
        }
        int rows = s.length();
        int cols = p.length();

        boolean dp [][] = new boolean[rows+1][cols+1];
        dp[0][0] = true;


        for(int j=1;j<=p.length();j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1];
            }
            else{
                dp[0][j] = false;
            }
        }

        for(int i=1;i<=s.length();i++){
            dp[i][0] = false;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1) !='*'){
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) =='?')
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j-1]||dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}


class Pair<K,V>  {

    /**
     * Key of this <code>Pair</code>.
     */
    public K key;

    /**
     * Gets the key for this pair.
     * @return key for this pair
     */
    public K getKey() { return key; }

    /**
     * Value of this this <code>Pair</code>.
     */
    public V value;

    /**
     * Gets the value for this pair.
     * @return value for this pair
     */
    public V getValue() { return value; }

    /**
     * Creates a new pair
     * @param key The key for this pair
     * @param value The value to use for this pair
     */
    public Pair( K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * <p><code>String</code> representation of this
     * <code>Pair</code>.</p>
     *
     * <p>The default name/value delimiter '=' is always used.</p>
     *
     *  @return <code>String</code> representation of this <code>Pair</code>
     */
    @Override
    public String toString() {
        return key + "=" + value;
    }

    /**
     * <p>Generate a hash code for this <code>Pair</code>.</p>
     *
     * <p>The hash code is calculated using both the name and
     * the value of the <code>Pair</code>.</p>
     *
     * @return hash code for this <code>Pair</code>
     */
    @Override
    public int hashCode() {
        // name's hashCode is multiplied by an arbitrary prime number (13)
        // in order to make sure there is a difference in the hashCode between
        // these two parameters:
        //  name: a  value: aa
        //  name: aa value: a
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    /**
     * <p>Test this <code>Pair</code> for equality with another
     * <code>Object</code>.</p>
     *
     * <p>If the <code>Object</code> to be tested is not a
     * <code>Pair</code> or is <code>null</code>, then this method
     * returns <code>false</code>.</p>
     *
     * <p>Two <code>Pair</code>s are considered equal if and only if
     * both the names and values are equal.</p>
     *
     * @param o the <code>Object</code> to test for
     * equality with this <code>Pair</code>
     * @return <code>true</code> if the given <code>Object</code> is
     * equal to this <code>Pair</code> else <code>false</code>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof javafx.util.Pair) {
            javafx.util.Pair pair = (javafx.util.Pair) o;
            if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
            if (value != null ? !value.equals(pair.getValue()) : pair.getValue() != null) return false;
            return true;
        }
        return false;
    }
}