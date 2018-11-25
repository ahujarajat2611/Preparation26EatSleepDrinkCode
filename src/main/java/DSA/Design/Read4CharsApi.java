package DSA.Design;

/**
 * Created by hadoop on 17/2/18.
 */
public class Read4CharsApi {

    public int read(char[] buf, int n) {
        char r[] = new char[4];
        int idx = 0;
        while (idx < n) {
            int size = read4(r);
            int rPtr = 0;
            while (rPtr < size && idx < n) {
                buf[idx++] = r[rPtr++];
            }
            if (size < 4)
                break;
        }

        return idx;
    }
    private int read4(char[] r) {
        return 0;
    }
}
