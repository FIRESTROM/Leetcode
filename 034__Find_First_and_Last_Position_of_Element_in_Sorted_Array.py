class Solution(object):

    def extreme_insertion_index(self, nums, target, left):
        l = 0
        r = len(nums)

        while l < r:
            mid = (l + r) // 2
            if nums[mid] > target or (left and target == nums[mid]):
                r = mid
            else:
                l = mid + 1

        return l

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        left_idx = self.extreme_insertion_index(nums, target, True)

        # assert that `left_idx` is within the array bounds and that `target`
        # is actually in `nums`.
        if left_idx == len(nums) or nums[left_idx] != target:
            return [-1, -1]

        return [left_idx, self.extreme_insertion_index(nums, target, False) - 1]
