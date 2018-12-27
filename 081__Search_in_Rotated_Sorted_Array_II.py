class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if len(nums) == 0:
            return False
        start, end = 0, len(nums) - 1

        while start <= end:
            while start < end and nums[start] == nums[end]:
                start += 1
            mid = (start + end) / 2
            if nums[mid] == target:
                return True
            elif nums[start] <= nums[mid]:
                if nums[start] <= target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            elif nums[mid] <= nums[end]:
                if nums[mid] < target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
        return False



       
