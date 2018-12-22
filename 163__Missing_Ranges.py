class Solution(object):
    def findMissingRanges(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: List[str]
        """
        start = lower
        result = []

        if len(nums) == 0:
            st = str(lower)
            if start < upper:
                st += "->" + str(upper)
            result.append(st)
            return result

        for i in range(len(nums)):
            end = nums[i] - 1
            if start <= end < upper:
                 st = str(start)
                 if start < end:
                    st += "->" + str(end)
                 result.append(st)
            start = nums[i] + 1

        if nums[-1] + 1 <= upper:
            st = str(nums[-1] + 1)
            if nums[-1] + 1 < upper:
                st += "->" + str(upper)
            result.append(st)
        return result
                    
