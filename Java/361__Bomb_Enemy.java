class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid== null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        int[] up = new int[n];
        for (int i = 0 ; i < m; i++) {
            int left = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    dp[i][j] += left;
                    dp[i][j] += up[j];
                } else if (grid[i][j] == 'E') {
                    left++;
                    up[j]++;
                } else if (grid[i][j] == 'W') {
                    left = 0;
                    up[j] = 0;
                }
            }
        }
        int result = 0;
        int[] down = new int[n];
        for (int i = m - 1 ; i >= 0; i--) {
            int right = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == '0') {
                    dp[i][j] += right;
                    dp[i][j] += down[j];
                    result = Math.max(result, dp[i][j]);
                } else if (grid[i][j] == 'E') {
                    right++;
                    down[j]++;
                } else if (grid[i][j] == 'W') {
                    right = 0;
                    down[j] = 0;
                }
            }
        }
        return result;
    }
}
