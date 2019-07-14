public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int min_result = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++) {
                    int val = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    min_result = Math.min(val, min_result);
                }
                dp[start][start + len - 1] = min_result;
            }
        }
        return dp[1][n];
    }
}
