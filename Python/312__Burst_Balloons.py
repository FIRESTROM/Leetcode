class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        nums = [1] + nums + [1]

        dp = [[0] * (n + 2) for _ in range(n + 2)]

        for length in range(2, n + 2):
            for i in range(n - length + 2):
                j = i + length
                mij = nums[i] * nums[j]
                for mid in range(i + 1, j):
                    temp = dp[i][mid] + dp[mid][j] + mij * nums[mid]
                    if temp > f[i][j]:
                        dp[i][j] = temp

        return dp[0][-1]
