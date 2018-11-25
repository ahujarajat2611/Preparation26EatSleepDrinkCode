package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("rajat"));
        System.out.print(reverseString.reverseWords("rajat is good"));
    }

    public String reverseWords(String s){
        if( s== null){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int start =0;
        while (start<s.length() && s.charAt(start) == ' '){
            start++;
        }

        for( int end =start;end<s.length();end++){
            if(s.charAt(end) == ' '){
                stringBuilder.append(reverseString(s.substring(start,end))).append(' ');
                while (end<s.length() && s.charAt(end)==' '){
                    end++;
                }
                start = end;
            }
            if(end == s.length()-1) {
                stringBuilder.append(reverseString(s.substring(start, end+1)));
            }
        }
        String returnedString = stringBuilder.toString();
        return reverseString(returnedString);
    }

    private String reverseString(String returnedString) {
        char []array = returnedString.toCharArray();
        int start=0;
        int end = returnedString.length()-1;
        while (start<end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(array);
    }
}
