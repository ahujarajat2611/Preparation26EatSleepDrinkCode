package BasicAlgorithms.String;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int offset = 0;
    int buffersize=0;
    public int read(char[] buf, int n) {
        int totalbytes = 0;
        boolean eofile = false;
        char []buffer = new char[4];
        int bytesread =0;
        while (!eofile && totalbytes<n){
            if(buffersize == 0){
                bytesread = read4(buffer);
                if(bytesread<4){
                    eofile = true;
                }
            }
            int remainingbytestoread= n-totalbytes;
            for(int i=0;i<Math.min(remainingbytestoread,bytesread);i++){
                buf[totalbytes++] = buffer[offset+i];
            }
            offset = (offset + Math.min(remainingbytestoread,bytesread))%4;
            buffersize = buffersize - Math.min(remainingbytestoread,bytesread);
        }
        
        return totalbytes;
    }
}
class Reader4 {
    int read4(char[] buf) {
        return 4;
    }
}