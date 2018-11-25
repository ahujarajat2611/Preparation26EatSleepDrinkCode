package BasicAlgorithms.Array;

/**
 * Created by hadoop on 18/12/17.
 */
public class Shuffle {
    public void shuffle2(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));   // between i and n-1
            swap(a, i, r);
        }
    }
    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // a1a2a3a4b1b2b3b4
    // 0 1 2 3 4 5 6 7 8 9
    //   b1a1b2a2b3a3b4a4
    //


    // 2* i / length + 1 mode /. very nice
    public void shuffle(int[] nums) {
        //TODO no need?
        if (nums.length % 2 != 0) {
            throw new IllegalArgumentException("Odd length expected");
        }
        int[] temp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            temp[(i * 2) % (nums.length + 1)] = nums[i - 1];
        }
        for (int i = 1; i <= nums.length; i++) {
            nums[i - 1] = temp[i];
        }
    }
}
