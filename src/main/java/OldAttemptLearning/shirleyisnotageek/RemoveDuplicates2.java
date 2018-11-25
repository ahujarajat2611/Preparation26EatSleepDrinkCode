package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
//http://shirleyisnotageek.blogspot.in/2015/01/remove-duplicates-from-sorted-array-ii.html
    /*
    This is not a hard problem.
     However, it is tricky to write neat code.
      A smart way to do it is to track two variables, the current node (curr) and the node before it (prev).
    If current node equals the previous
    node and the node before the previous node, we traverse all duplicate nodes and skip them until we find the next different one, mark the index of that node.
Then we move the prev to the next one, and let num[prev] = num[curr]. Then we increase curr.

     */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] A) {
        if (A == null)
            throw new NullPointerException("Null Array!");
        if (A.length <= 2)
            return A.length;

        int prev = 1;
        int curr = 2;
        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            }
            else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }

        }
        return prev + 1;
    }
}
