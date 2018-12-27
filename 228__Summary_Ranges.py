class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if len(nums) == 0:
            return []
        start, end = 0, 0
        result = []
        for i in range(1, len(nums)):
            if nums[i] == nums[end] + 1:
                end += 1
            else:
                if start == end:
                    result.append(str(nums[start]))
                else:
                    result.append(str(nums[start]) + "->" + str(nums[end]))
                start, end = i, i

        if start == end:
            result.append(str(nums[start]))
        else:
            result.append(str(nums[start]) + "->" + str(nums[end]))

        return result

# Faster using while loop

class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if len(nums) == 0:
            return []

        left, right = 0, 0
        result = []
        while right < len(nums):
            while right + 1 < len(nums) and nums[right] + 1 == nums[right + 1]:
                right += 1
            if left < right:
                result.append(str(nums[left]) + "->" + str(nums[right]))
            else:
                result.append(str(nums[left]))
            left, right = right + 1, right + 1

        return result
