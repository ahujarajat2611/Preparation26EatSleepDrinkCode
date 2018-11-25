package BasicAlgorithms.String;

public class BaseTransfer2 {

    static final String BASE36 = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static String base(int value, int base) {
        final StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, BASE36.charAt(value % base));
            value /= base;
        } while (value != 0);
        return sb.toString();
    }

    public static int base(String value, int base) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            char digit = value.charAt(i);
            result = result * base + BASE36.indexOf(digit);
        }
        return result;
    }


    public String ten2binary(int n) {
        return base(n, 1);
    }

    public String ten2Octal(int n) {
        return base(n, 8);
    }

    public String ten2hex(int n) {
        return base(n, 16);
    }

    public int hex2ten(String value) {
        return base(value, 16);
    }
}