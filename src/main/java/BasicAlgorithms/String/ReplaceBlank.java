package BasicAlgorithms.String;

/**
 * Created by hadoop on 15/10/17.
 */
public class ReplaceBlank {
    public int replaceBlank(char[] string, int length) {
        int additional=0;
        for(int i=0;i<string.length;i++){
            if(string[i] == ' '){
                additional = additional+2;
            }
        }
        int index = string.length+additional;
        int len = index;
        for(int i=string.length-1;i>=0;i--){
            if(string[i] == ' '){
                string[--index] = '0';
                string[--index] = '2';
                string[--index] = '%';
             }
            else {
                string[--index] = string[i];
            }
        }
        return len;
    }
}
