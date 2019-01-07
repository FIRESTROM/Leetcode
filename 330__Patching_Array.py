class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        patches, i = 0, 0
        miss = 1
        while miss <= n:
            # if current element nums[i] is less than or equal to miss
            if i < len(nums) and nums[i] <= miss:
                # extends the range to [1, miss + nums[i])
                miss += nums[i]
                i += 1
            else:
                # patch the array with miss, extends the range to [1, miss + miss)
                miss *= 2
                patches += 1
        return patches
