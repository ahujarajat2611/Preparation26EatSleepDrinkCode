package BasicAlgorithms.Dp;

class Jump {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     **/
  //DP
  public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
    //By default, boolean[] can is all false
        boolean[] can = new boolean[A.length];
        can[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && (j + A[j] >= i)) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[A.length - 1];
    }
    public int jump(int[] A) {
        int[] steps = new int[A.length];
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && A[j] + j > i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[A.length - 1];
    }
}