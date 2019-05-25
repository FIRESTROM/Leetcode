class Solution {
    public int numSquares(int n) {
        List<Integer> perfSquares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            perfSquares.add(i * i);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int num : perfSquares) {
                if (i - num < 0)
                    break;
                else
                    if (dp[i] == 0 || dp[i] > dp[i - num] + 1)
                        dp[i] = dp[i - num] + 1;
            }
        }
        return dp[n];
    }
}
