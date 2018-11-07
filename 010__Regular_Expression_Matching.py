class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
        dp[0][0] = True
        for j in range(2, (len(p) + 1)):
            if p[j - 1] == "*":
                dp[0][j] = dp[0][j - 2]

        for j in range(1, len(p) + 1):
            for i in range(1, len(s) + 1):

                if p[j - 1] != "*":
                    dp[i][j] = dp[i - 1][j - 1] and (s[i - 1] == p[j - 1] or p[j - 1] == ".")
                else:
                    if p[j - 2] == ".":
                        dp[i][j] = dp[i - 1][j] or dp[i][j - 2]
                    else:
                        dp[i][j] = dp[i][j - 2] or (dp[i - 1][j] and s[i - 1] == p[j - 2])

        return dp[-1][-1]
