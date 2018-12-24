class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        INVALID = float('inf')
        dp = [INVALID] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for i in range(coin, amount + 1):
                if dp[i - coin] >= dp[i]:
                    continue
                dp[i] = dp[i - coin] + 1
        return -1 if dp[amount] == INVALID else dp[amount]
