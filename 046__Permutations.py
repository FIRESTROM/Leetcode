class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        def once(lists, n):
            result = []
            for lst in lists:
                for i in range(len(lst) + 1):
                    result.append(lst[:i] + [n] + lst[i:])
            return result

        result = [[nums[0]]]
        for i in range(1, len(nums)):
            result = once(result, nums[i])
        return result
