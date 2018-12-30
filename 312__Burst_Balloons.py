class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        N = len(nums)
        nums = [1] + nums + [1]

        f = [[0] * (N + 2) for _ in range(N + 2)]

        for length in range(2, N + 2):
            for i in range(N - length + 2):
                j = i + length
                mij = nums[i] * nums[j]
                for mid in range(i + 1, j):
                    temp = f[i][mid] + f[mid][j] + mij * nums[mid]
                    if temp > f[i][j]:
                        f[i][j] = temp

        return f[0][N + 1]
