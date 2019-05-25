class Solution {
    public int minFallingPathSum(int[][] A) {
        int len = A.length;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                int best = A[i + 1][j];
                if (j > 0)
                    best = Math.min(best, A[i + 1][j - 1]);
                if (j + 1 < len)
                    best = Math.min(best, A[i + 1][j + 1]);
                A[i][j] += best;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int x: A[0])
            result = Math.min(result, x);
        return result;
    }
}
