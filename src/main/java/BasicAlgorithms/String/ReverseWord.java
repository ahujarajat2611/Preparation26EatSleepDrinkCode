package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class ReverseWord {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int end = s.length()-1;end>=0 ;end--){
            if(s.charAt(end) == ' '){
                continue;
            }
            int start = end;
            while (start>=0 && s.charAt(start)!=' '){
                start--;
            }
            String word = s.substring(start+1,end+1);
            sb.append(word+" ");
            end = start;
        }
        return sb.toString();
    }

    public String reverseWordsBegining(String s) {
        StringBuilder sb = new StringBuilder();
        for(int start= 0;start<s.length();start++){
            if(s.charAt(start) == ' '){
                continue;
            }
            int end = start;
            while (end<s.length() && s.charAt(end)!=' '){
                end++;
            }
            String word = s.substring(start,end);
            String reverseWord = new StringBuilder(word).reverse().toString();
            sb.append(reverseWord).append(" ");
            System.out.println(sb.toString());
            start = end;
        }
        return sb.reverse().toString().trim();
    }
    public void reverseWords(char[] s) {
        System.out.println(s.length);
        for(int start=0;start<s.length;start++){
            if(s[start]==' ')
                continue;
            int end = start;
            while (end<s.length && s[end]!=' '){
                end++;
            }
            reversew(s,start,end-1);
            start = end;
        }
        reversew(s,0,s.length-1);
    }

    private void reversew(char[] s, int start, int end) {
        while (start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    public void reverseWordsAcc(char[] words) {
        int start=0;
        for(int i=0;i<words.length;i++){
            if(words[i] == ' '){
                reverseWordsHelper(words,start,i-1);
                start = i+1;
            }
            if(i == words.length -1){
                reverseWordsHelper(words,start,i);
            }
        }
        reverseWordsHelper(words,0,words.length-1);

    }

    private void reverseWordsHelper(char[] words, int start, int end) {
        while (start<end){
            char temp  = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
       // System.out.println(reverseWord.reverseWordsBegining("rajat is good"));
        char d[] = {};
        char c [] = "".toCharArray();
        reverseWord.reverseWords(c);
        System.out.println(String.valueOf(c));
        System.out.println(String.valueOf(d));
        char []acc = "".toCharArray();
        reverseWord.reverseWordsAcc(acc);
        System.out.println("check"+String.valueOf(acc)+"ad");
    }
}