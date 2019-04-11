class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                if index < i:
                    nums[index] = nums[i]
                    index += 1
                    nums[i] = 0
                else:
                    index += 1


                
