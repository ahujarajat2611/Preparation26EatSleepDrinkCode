package PracticeOneWeek26;

/**
 * Created by hadoop on 10/12/17.
 */
public class SortColors2 {
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0 || k <= 0) {
            return;
        }
        // if there ar ek colots emans k-1 times partition function
        // neeeds to be ccalled
        int end = colors.length - 1;
        for (int i = 0; i < k - 1; i++) {
            // last index nothing but parititon
            end = helper(colors, 0, end, k - i - 1);
        }
    }

    public void swap(int[] colors, int x, int y){
        int temp = colors[x];
        colors[x] = colors[y];
        colors[y] = temp;
    }

    public int helper(int[] colors, int start, int end, int pivot) {
        int low = start;
        int high = end;
        while (low <= high) {
            while(low < high && colors[low] <= pivot) {
                low++;
            }
            while(high > 0 && colors[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(colors, low, high);
                low++;
                high--;
            }
        }
        return low - 1;
    }
}
