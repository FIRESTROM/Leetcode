class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        if len(nums) == 0 or len(nums) == 1:
            return True

        cur = 0
        max_reach = nums[0]
        while cur < len(nums) and cur <= max_reach:
            if nums[cur] + cur > max_reach:
                max_reach = nums[cur] + cur
            cur += 1

        if max_reach >= len(nums) - 1:
            return True

        return False


# Another Greedy Approach

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        last_pos = len(nums) - 1
        for i in range(len(nums) - 1, -1, -1):
            if i + nums[i] >= last_pos:
                last_pos = i
        return last_pos == 0
            
