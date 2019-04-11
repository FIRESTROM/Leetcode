class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) <= 2:
            return max(nums)
        tmp1 = self.dp(nums[:-1])
        tmp2 = self.dp(nums[1:])
        return max(tmp1, tmp2)

    def dp(self,nums):
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = nums[1]
        for i in range(2, len(nums)):
            dp[i] = nums[i] + max(dp[:i - 1])
        return max(dp[-1], dp[-2])
