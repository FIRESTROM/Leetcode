class Solution(object):
    def getMoneyAmount(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        for length in range(2, n + 1):
            for start in range(1, n - length + 2):
                end = start + length - 1
                tempmin = float("inf")
                for mid in range(start, end):
                    temp = mid + max(dp[start][mid - 1], dp[mid + 1][end])
                    tempmin = min(tempmin, temp)
                dp[start][end] = tempmin
        return dp[1][-1]
