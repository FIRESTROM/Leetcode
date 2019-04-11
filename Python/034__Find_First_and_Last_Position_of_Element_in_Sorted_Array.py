class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def findmax(l, r):
            while l < r:
                mid = (l + r) // 2
                if nums[mid] <= target:
                    l = mid + 1
                else:
                    r = mid
            return l - 1

        def findmin(l, r):
            while l < r:
                mid = (l + r) // 2
                if nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid
            return l

        if len(nums) == 0:
            return [-1, -1]

        index_l = findmin(0, len(nums))
        if index_l == len(nums) or nums[index_l] != target:
            return [-1, -1]

        return [index_l, findmax(0, len(nums))]
