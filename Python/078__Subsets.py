class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def iter(nums, result):
            if len(nums) == 0:
                return result
            result += [x + [nums[0]] for x in result]
            return iter(nums[1:], result)

        return iter(nums, [[]])
            
