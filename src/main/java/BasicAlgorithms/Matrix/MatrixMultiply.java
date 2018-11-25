package BasicAlgorithms.Matrix;

public class MatrixMultiply {

    /**
     * 朴素矩阵相乘算法，思想明了，编程实现简单。时间复杂度是O(n^3)
     * <pre>
     * for i ← 1 to n
     *     do for j ← 1 to n
     *         do c[i][j] ← 0
     *             for k ← 1 to n
     *                 do c[i][j] ← c[i][j] + a[i][k]⋅ b[k][j]
     * </pre>
     */
    public int[][] multiply(int[][] a, int[][] b) {
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        if (n1 != m2) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }
        int[][] c = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}