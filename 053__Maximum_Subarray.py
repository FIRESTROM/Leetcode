class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        current_max = current_sum = nums[0]

        for item in nums[1:]:

            if current_sum < 0:
                current_sum = item

            else:
                current_sum += item

            if current_sum > current_max:
                current_max = current_sum

        return current_max

        
