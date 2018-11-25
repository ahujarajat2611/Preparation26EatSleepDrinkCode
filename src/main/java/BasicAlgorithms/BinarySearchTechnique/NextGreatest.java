package BasicAlgorithms.BinarySearchTechnique;

/**
 * Created by hadoop on 24/12/17.
 */
public class NextGreatest {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while (start<end){
            int mid = start + (end-start)/2;

            if(target<=letters[mid]){
                start = mid +1;
            }
            else {
                end = mid;
            }
        }
        if(start == letters.length-1){
            return letters[0];
        }
        return letters[start];
    }

}
