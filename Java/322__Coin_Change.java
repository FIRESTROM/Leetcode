class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int val : coins)
            if (val <= amount)
                dp[val] = 1;
        for (int i = 1; i <= amount; i++)
            for (int val : coins)
                if (i - val >= 0)
                    if (dp[i - val] != 0)
                        dp[i] = dp[i] == 0 ? 1 + dp[i - val] : Math.min(dp[i], 1 + dp[i - val]);
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
