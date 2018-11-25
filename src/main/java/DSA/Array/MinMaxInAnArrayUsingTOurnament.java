package DSA.Array;

/**
 * Created by hadoop on 11/2/18.
 */
public class MinMaxInAnArrayUsingTOurnament {
    public Pair getMinMax(int a[], int l, int r) {
        int n = r - l + 1;
        int min, max;
        if (n == 1) {
            return new Pair(a[l], a[l]);
        }
        if (n == 2) {
            if (a[l] > a[r]) {
                max = a[l];
                min = a[r];
            } else {
                min = a[l];
                max = a[r];
            }
            return new Pair(max, min);
        }
        int mid = l + (r - l) / 2;
        Pair left = getMinMax(a, l, mid);
        Pair right = getMinMax(a, mid + 1, r);

        max = left.max > right.max ? left.max : right.max;
        min = left.min < right.min ? left.min : right.min;

        return new Pair(max, min);
    }
    public Pair getMinMaxInSingleTraversalUsingPairsMethod(int a[], int n) {
        if (n <= 0)
            return null;
        int max, min, i;
        if (n % 2 == 0) {
            if (a[1] > a[0]) {
                max = a[1];
                min = a[0];
            } else {
                max = a[0];
                min = a[1];
            }
            i = 2;
        } else {
            min = max = a[0];
            i = 1;
        }
        while (i < n - 1) {
            if (a[i] > a[i + 1]) {
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i + 1] < min) {
                    min = a[i + 1];
                }
            } else {
                if (a[i + 1] > max) {
                    max = a[i + 1];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }
            i = i +2;
        }

        return new Pair(max, min);
    }
    class Pair {
        int max;
        int min;

        @Override
        public String toString() {
            return "Pair [max=" + max + ", min=" + min + "]";
        }

        public Pair(int max, int min) {
            super();
            this.max = max;
            this.min = min;
        }
    }
}
