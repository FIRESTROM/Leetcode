class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums.sort()
        dp = [[nums[i]] for i in range(len(nums))]
        for i in range(1, len(nums)):
            for j in range(i-1, -1, -1):
                if nums[i] % nums[j] == 0:
                    if len(dp[j]) + 1 > len(dp[i]):
                        dp[i] = list(dp[j])
                        dp[i].append(nums[i])
        maxcount = 0
        result = []
        for lst in dp:
            if len(lst) > maxcount:
                result = lst
                maxcount = len(lst)
        return result
