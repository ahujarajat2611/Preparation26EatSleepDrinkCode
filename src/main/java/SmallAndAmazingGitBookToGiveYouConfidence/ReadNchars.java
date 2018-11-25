package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class ReadNchars {
    public int read(char []answer,int n){
        char [] buffer = new char[4];
        int totalCharsRead = 0;
        boolean isEof = false;
        while (!isEof && totalCharsRead<n){
            int charsRead = read4(buffer);
            if(charsRead<4){
                isEof= true;
            }
            int tobeCopied;
            if(totalCharsRead +1 + charsRead >n){
                tobeCopied= n-totalCharsRead-1;
            }
            else {
                tobeCopied = charsRead;
            }
            for(int i=0;i<tobeCopied;i++){
                answer[totalCharsRead+i] = buffer[i];
            }
            totalCharsRead +=tobeCopied;
        }
        return totalCharsRead;
    }

    private int read4(char[] buffer) {
        return 3;
    }
}
