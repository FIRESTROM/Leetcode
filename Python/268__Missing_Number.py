class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        return len(nums) * (len(nums) + 1) / 2 - sum(nums)


class Solution:
    def missingNumber(self, nums):
        nums = set(nums)
        for i in range(len(nums)+1):
            if i not in nums: return i
