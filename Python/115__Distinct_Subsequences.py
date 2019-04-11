class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        m, n = len(s), len(t)

        if m < n:
            return 0

        dp = [[0] * (m + 1) for _ in range(n + 1)]
        dp[0] = [1] * (m + 1)

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if s[j - 1] == t[i - 1]:
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]
                else:
                    dp[i][j] = dp[i][j - 1]
        return dp[-1][-1]
