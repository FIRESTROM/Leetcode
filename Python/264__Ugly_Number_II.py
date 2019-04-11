class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0:
            return None
        if n == 1:
            return 1

        dp = [0] * (n + 1)
        dp[1] = 1
        pointer_2, pointer_3, pointer_5 = 1, 1, 1

        for i in range(2, n + 1):
            dp[i] = min(dp[pointer_2] * 2, dp[pointer_3] * 3, dp[pointer_5] * 5)
            if dp[i] == dp[pointer_2] * 2:
                pointer_2 += 1
            if dp[i] == dp[pointer_3] * 3:
                pointer_3 += 1
            if dp[i] == dp[pointer_5] * 5:
                pointer_5 += 1

        return dp[-1]
