package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Smallest Rectangle Enclosing Black Pixels
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
For example, given the following image:
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,

Return 6.

 */
/*

There are lots of ways to solve this problem. I use DFS because all black pixels are connected to each other so it's quite easy to figure out the boundaries of the black pixels.

 */
public class SmallestRectangle {
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
}
