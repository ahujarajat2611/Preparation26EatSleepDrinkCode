package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
public class SmallestCharacter {
    public char nextChar(char[] list, char c) {
        int start =0;
        int end = list.length-1;
        while (start<end){
            int mid = start + (end-start)/2;
            if(c>= list[mid]){
                start = mid +1;
            }
            else {
                end = mid;
            }
        }
        return list[start];
    }

    public static void main(String[] args) {
        SmallestCharacter smallestCharacter = new SmallestCharacter();
        System.out.println(smallestCharacter.nextChar(new char[]{'c', 'f', 'j', 'p', 'v'}, 'k'));

    }
}
