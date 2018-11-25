package AwangDevLintCode;

/**
 * Created by hadoop on 17/2/18.
 */
public class Read4ApiMultipleCall {
    char r[] = new char[4];
    int size;
    int rptr=0;
    private int read4(char[] r) {
        return 0;
    }
    public int read(char[] buf, int n) {
        int idx = 0;
        while (idx < n) {
            if(rptr == 0) {
                size = read4(r);
            }
            while (rptr < size && idx < n) {
                buf[idx++] = r[rptr++];
            }
            if(rptr == size){
                rptr =0;
            }
            if (size < 4)
                break;
        }
        return idx;
    }
}
