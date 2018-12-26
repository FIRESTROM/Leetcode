class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        if target > nums[high]:
            return high + 1
        while low < high - 1:
            mid = (low + high) / 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                high = mid
            else:
                low = mid

        if target == nums[low]:
            return low
        elif target > nums[low]:
            return low + 1;
        else:
            return 0

    
