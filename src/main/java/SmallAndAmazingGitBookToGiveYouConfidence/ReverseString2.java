package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class ReverseString2 {
    public static void main(String args[]){
        ReverseString2 reverseString2 = new ReverseString2();
        String a = "rahat is goog";
        char[] array = a.toCharArray();
        reverseString2.reverseWords(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    void reverseWords(char [] words){
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
}
