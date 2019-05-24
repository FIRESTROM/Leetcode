class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1;i <= matrix.length; i++) {
            int cur_sum = 0;
            for (int j = 1; j <= matrix[0].length; j++) {
                cur_sum += matrix[i - 1][j - 1];
                dp[i][j] = dp[i - 1][j] + cur_sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
