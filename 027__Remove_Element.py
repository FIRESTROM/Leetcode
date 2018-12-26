class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        put_index = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[put_index] = nums[i]
                put_index += 1

        return put_index
                
