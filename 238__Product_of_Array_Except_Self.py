class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        total = 1
        for num in nums:
            if num != 0:
                total *= num
        if nums.count(0) >= 2:
            return [0 for _ in range(len(nums))]
        elif nums.count(0) == 1:
            index = nums.index(0)
            nums = [0 for _ in range(len(nums))]
            nums[index] = total
            return nums
        else:
            for i in range(len(nums)):
                if nums[i] != 0:
                    nums[i] = total / nums[i]
        return nums
