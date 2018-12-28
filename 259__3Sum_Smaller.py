class Solution(object):
    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        result = 0
        nums.sort()
        n = len(nums)
        for head in range(n - 2):
            mid = head + 1
            tail = n - 1
            if 3 * nums[head] >= target:
                break
            while mid < tail:
                s = nums[mid] + nums[head] + nums[tail]
                if s < target:
                    result += tail - mid
                    mid += 1
                else:
                    tail -= 1
        return result
