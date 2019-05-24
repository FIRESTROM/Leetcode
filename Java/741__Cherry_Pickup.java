class Solution {
    public int cherryPickup(int[][] grid) {
        int len = grid.length;
        int[][] dp = new int[len][len];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);
        dp[0][0] = grid[0][0];

        for (int t = 1; t <= 2 * len - 2; t++) {
            int[][] dp_temp = new int[len][len];
            for (int[] row: dp_temp)
                Arrays.fill(row, Integer.MIN_VALUE);
            for (int i = Math.max(0, t - (len - 1)); i <= Math.min(len - 1, t); i++) {
                for (int j = Math.max(0, t - (len - 1)); j <= Math.min(len - 1, t); j++) {
                    if (grid[i][t - i] == -1 || grid[j][t - j] == -1)
                        continue;
                    int val = grid[i][t - i];
                    if (i != j)
                        val += grid[j][t - j];
                    for (int pi = i - 1; pi <= i; pi++)
                        for (int pj = j - 1; pj <= j; pj++)
                            if (pi >= 0 && pj >= 0)
                                dp_temp[i][j] = Math.max(dp_temp[i][j], dp[pi][pj] + val);
                }
            }
            dp = dp_temp;
        }
        return Math.max(0, dp[len-1][len-1]);
    }
}
