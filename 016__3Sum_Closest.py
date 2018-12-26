class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        min_val = float("inf")
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue;
            l, r = i + 1, len(nums) - 1
            while l < r:
                val = nums[i] + nums[l] + nums[r]
                if val == target:
                    return target
                elif val > target:
                    if abs(val - target) < abs(min_val - target):
                        min_val = val
                    r -= 1
                else:
                    if abs(val - target) < abs(min_val - target):
                        min_val = val
                    l += 1
        return min_val
