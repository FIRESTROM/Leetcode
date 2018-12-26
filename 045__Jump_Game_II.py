class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        jumps = 0
        cur_jump_max = 0
        prev_jump_max = 0
        for i in range(len(nums) - 1):
            cur_jump_max = max(cur_jump_max, i + nums[i])
            if i == prev_jump_max:
                jumps += 1
                prev_jump_max = cur_jump_max
        return jumps
        
