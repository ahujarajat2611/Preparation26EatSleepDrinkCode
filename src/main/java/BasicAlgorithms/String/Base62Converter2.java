package BasicAlgorithms.String;

public class Base62Converter2 {

    /**
     * Base62 characters table sorted to quickly calculate decimal equivalency by compensating.
     */
    static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * Returns the base 62 string of an integer.
     *
     * @return the base 62 string of an integer
     */
    public static String base62(int value) {
        final StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, BASE62.charAt(value % 62));
            value /= 62;
        } while (value != 0);
        return sb.toString();
    }

    /**
     * Returns the base 62 value of a string.
     *
     * @return the base 62 value of a string.
     */
    public static int base62(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            char digit = value.charAt(i);
            result = result * 62 + BASE62.indexOf(digit);
        }
        return result;
    }
}