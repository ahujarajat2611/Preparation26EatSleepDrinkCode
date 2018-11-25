package BasicAlgorithms.String;

/**
 * Created by hadoop on 15/10/17.
 */
public class ReadNSize extends Read4{
    public int read(char[] buf, int n) {
        int totalbytes = 0;
        boolean eofile = false;
        char []buffer = new char[4];
        while (!eofile && totalbytes<n){
            int bytesread = read4(buffer);
            if(bytesread<4){
                eofile = true;
            }
            int remainingbytestoread= n-totalbytes;
            for(int i=0;i<Math.min(remainingbytestoread,bytesread);i++){
                buf[totalbytes++] = buffer[i];
            }
        }
        return totalbytes;
    }
}
class Read4{
    int read4(char[]buffer){
        return 4;
    }
}