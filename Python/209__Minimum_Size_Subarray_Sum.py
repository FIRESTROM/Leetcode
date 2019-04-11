class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        if sum(nums) < s:
            return 0

        start, end = 0, 0
        curval = nums[0]
        result = len(nums)
        while end != len(nums) - 1:
            while end < len(nums) - 1 and curval < s:
                end += 1
                curval += nums[end]
            while start < end and curval - nums[start] >= s:
                curval -= nums[start]
                start += 1
            result = min(result, end - start + 1)
            curval -= nums[start]
            start += 1
        return result

# Same Approach But Faster and More Clear Solution

class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        val = left = 0
        result = len(nums) + 1
        for right, n in enumerate(nums):
            val += n
            while val >= s:
                result = min(result, right - left + 1)
                val -= nums[left]
                left += 1
        return result if result <= len(nums) else 0
