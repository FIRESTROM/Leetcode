class Solution(object):
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        s = 0
        dic = {}
        result = 0
        for i, num in enumerate(nums):
            s += num
            if s == k:
                result = max(result, i + 1)
            elif s - k in dic:
                result = max(result, i - dic[s - k])
            if s not in dic:
                dic[s] = i
        return result
