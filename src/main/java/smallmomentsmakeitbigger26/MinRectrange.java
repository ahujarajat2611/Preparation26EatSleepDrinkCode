package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 14/12/17.
 */
public class MinRectrange {
    private int top, bottom, left, right;

    public int minArea(char[][] image, int x, int y) {
        if(image.length == 0 || image[0].length == 0) return 0;
        top = bottom = x;
        left = right = y;
        dfs(image, x, y);
        return (right - left+1) * (bottom - top+1);
    }
    private void dfs(char[][] image, int x, int y){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length ||
                image[x][y] == '0')
            return;
        image[x][y] = '0'; // mark visited black pixel as white
        // keep trac of maxx, min in both that wil be ans
        // rectanable area //
        // sommetimes u need to think of
        top = Math.min(top, x);
        bottom = Math.max(bottom, x );
        left = Math.min(left, y);
        right = Math.max(right, y );
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y - 1);
        dfs(image, x, y + 1);
    }
}
