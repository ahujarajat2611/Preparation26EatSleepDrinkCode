package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class MaxArea {
    private int minX = Integer.MAX_VALUE;
    private int maxX = 0;
    private int minY = Integer.MAX_VALUE;
    private int maxY = 0;
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        dfs(image, x, y);
        // area means length
        // end -publish + 1
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public void dfs(char[][] image, int x, int y) {
        if (x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1 || image[x][y] == '0') {
            return;
        }
        image[x][y] = '0';
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y + 1);
        dfs(image, x, y - 1);
    }
}
