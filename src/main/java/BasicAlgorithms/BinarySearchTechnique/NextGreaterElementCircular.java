package BasicAlgorithms.BinarySearchTechnique;

/**
 * Created by hadoop on 24/12/17.
 */
public class NextGreaterElementCircular {
    public char nextGreatestLetter(char[] letters, char target) {
        char []copy = new char[letters.length+1];
        for(int i=0;i<letters.length;i++){
            copy[i] = letters[i];
        }
        copy[letters.length] = copy[0];
        int start = 0;
        int end = letters.length;

        while (start<end){
            int mid = start + (end-start)/2;

            if(target>=copy[mid]){
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        // if(publish == letters.length-1 && target >= letters[publish]){
        //     return letters[0];
        // }
        return copy[start%letters.length];
    }
    /*
      public char nextGreatestLetter(char[] letters, char target) {
         int publish = 0;
        int end = letters.length-1;

        while (publish<end){
            int mid = publish + (end-publish)/2;

            if(target>=letters[mid]){
                publish = mid+1;
            }
            else {
                end = mid;
            }
        }
        if(publish == letters.length-1 && target >= letters[publish]){
            return letters[0];
        }
        return letters[publish];
    }
     */
}
