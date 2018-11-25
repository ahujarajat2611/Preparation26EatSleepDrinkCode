package BasicAlgorithms.BfsDfs;

/**
 * Created by hadoop on 16/1/18.
 */
public class SmallestRectangleEnclosingBlackPixel {
    public int minArea(char[][] image, int x, int y) {

        int[] coords = new int[4];
        coords[0] = Integer.MAX_VALUE;
        coords[1] = Integer.MIN_VALUE;
        coords[2] = Integer.MAX_VALUE;
        coords[3] = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[image.length][image[0].length];
        findRange(image, coords, x, y, visited);
        return (coords[3] - coords[2] + 1) * (coords[1] - coords[0] + 1);
    }

    private void findRange(char[][] image, int[] coords, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        coords[0] = Math.min(coords[0], x);
        coords[1] = Math.max(coords[1], x);
        coords[2] = Math.min(coords[2], y);
        coords[3] = Math.max(coords[3], y);
        if (x - 1 >= 0 && image[x - 1][y] == '1' && !visited[x - 1][y]) {
            findRange(image, coords, x - 1, y, visited);
        }
        if (x + 1 < image.length && image[x + 1][y] == '1' && !visited[x + 1][y]) {
            findRange(image, coords, x + 1, y, visited);
        }
        if (y - 1 >= 0 && image[x][y - 1] == '1' && !visited[x][y - 1]) {
            findRange(image, coords, x, y - 1, visited);
        }
        if (y + 1< image[0].length && image[x][y + 1] == '1' && !visited[x][y + 1]) {
            findRange(image, coords, x, y + 1, visited);
        }
    }

    public int minAreaBinarySearchTechnique(char[][] image, int x, int y) {
        int left = leftmost(image, 0, y, true);
        int right = rightmost(image, y, image[0].length - 1, true);
        int top = leftmost(image, 0, x, false);
        int bottom = rightmost(image, x, image.length - 1, false);
        return (right - left + 1) * (bottom - top + 1);
    }

    int leftmost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (!hasBlack(image, mid, horizontal)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    int rightmost(char[][] image, int min, int max, boolean horizontal) {
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (!hasBlack(image, mid, horizontal)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return r;
    }

    boolean hasBlack(char[][] image, int mid, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    return true;
                }
            }
        } else {
            for (int j = 0; j < image[0].length; j++) {
                if (image[mid][j] == '1') {
                    return true;
                }
            }
        }
        return false;
    }
}
