class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 1:
            return [nums]
        result = []
        pas = []
        for i, num in enumerate(nums):
            if num in pas:
                continue
            pas.append(num)
            result += [j + [num] for j in self.permuteUnique(nums[:i] + nums[i + 1:])]
        return result
