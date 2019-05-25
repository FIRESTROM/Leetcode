class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K + 2][n];
        for (int i = 0; i < K + 2; i++)
        	for (int j = 0; j < n; j++)
        		dp[i][j] = Integer.MAX_VALUE / 2;
        dp[0][src] = 0;
        for (int i = 1; i <= K + 1; i++) {
        	dp[i][src] = 0;
        	for (int[] flight : flights) {
        		dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);
        	}
        }
        return dp[K + 1][dst] == Integer.MAX_VALUE / 2 ? -1 : dp[K + 1][dst];
    }
}
