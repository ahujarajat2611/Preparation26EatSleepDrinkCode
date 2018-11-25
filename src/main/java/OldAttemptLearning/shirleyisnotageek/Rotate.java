package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
The figure here shows how we should shift elements in a 3 * 3 matrix. We [0][0] -> [0][2] -> [2][2] -> [2][0] ->[0][0], generalize, [i][j] -> [j][n - i - 1] -> [n - i - 1][n - j - 1] -> [n - j - 1][i] -> [i][j], be careful about the bold part, otherwise some elements will be flipped upper side down, not rotated.
http://shirleyisnotageek.blogspot.in/2015/01/rotate-image.html
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int length = matrix.length;
        for (int i = 0; i < (length)/ 2; i++) {
            for (int j = 0; j < (length+1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
        }
    }
}
