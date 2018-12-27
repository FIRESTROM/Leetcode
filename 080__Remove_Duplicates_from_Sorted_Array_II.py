class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        length = 1
        cur_val, cur_num = nums[0], 1
        for i in range(1, len(nums)):
            if nums[i] == cur_val:
                cur_num += 1
                if cur_num == 2:
                    nums[length] = nums[i]
                    length += 1
            else:
                cur_val = nums[i]
                cur_num = 1
                nums[length] = nums[i]
                length += 1
        return length
