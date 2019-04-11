class Solution(object):

    def maxProfit_as_many_transactions(self, prices):
        if prices == []:
            return 0
        result = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                result += prices[i] - prices[i - 1]
        return result

    def maxProfit(self, K, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        K = min(K, len(prices) - 1)
        if K == 0:
            return 0
        if K >= len(prices) / 2:
            return self.maxProfit_as_many_transactions(prices)

        n = len(prices)
        dp = [[0] * n for _ in range(K + 1)]
        for k in range(1, K + 1):
            tmpMax = -1 * prices[0]
            for i in range(1, n):
                # Do nothing; Buy at temMax, sell at i
                dp[k][i] = max(dp[k][i - 1], prices[i] + tmpMax)
                # Update tempMax: finish k - 1 trades before, and buy at i
                tmpMax = max(tmpMax, dp[k - 1][i - 1] - prices[i])
        return dp[-1][-1]
