package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class Nread {
    public int read4(char[] buff){
        return 4;
    }
    public int readN(char[] buff, int N){
        char[] tmp = new char[4];
        int index = 0, next = 0;
        while(index < N  && (next = read4(tmp)) != 0)
            for(int i = 0; i < next && index < N; buff[index++] = tmp[i++]);
        return index;
    }
    private char[] buffer = new char[4];
    int offset = 0;
    int bufsize = 0;
    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean lessthan4 = false;
        int bytes = 0;
        while (!lessthan4 && readBytes < n) {
            if (bufsize == 0) {
                bufsize = read4(buffer);
                if (bufsize < 4) {
                    lessthan4 = true;
                }
            }

            bytes = Math.min(n - readBytes, bufsize);
            for (int i = 0; i < bytes; i++) {
                buf[readBytes + i] = buffer[offset + i];
            }
            offset = (offset + bytes) % 4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
}

