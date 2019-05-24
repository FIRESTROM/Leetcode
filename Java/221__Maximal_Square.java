class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        int[][] dp = new int[m + 1][n + 1];
        int max_len = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    max_len = Math.max(max_len, dp[i][j]);
                }
            }
        }
        return max_len * max_len;
    }
}
