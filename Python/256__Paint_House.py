class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        length = len(costs)
        dp = [[0] * 3 for _ in range(length + 1)]
        for i in range(1, length + 1):
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0]
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1]
            dp[i][2] = min(dp[i - 1][1], dp[i - 1][0]) + costs[i - 1][2]
        return min(dp[-1])
