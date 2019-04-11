class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = [0] * n
        pal = [[False] * n for row in range(n)]

        for j in range(n):
            min_cut = n
            for i in range(j + 1):
                if s[i] == s[j] and (j - i <= 2 or pal[i + 1][j - 1]):
                    pal[i][j] = True
                    if i == 0:
                        min_cut = 0
                    else:
                        min_cut = min(min_cut, dp[i - 1] + 1)
            dp[j] = min_cut

        return dp[-1]
