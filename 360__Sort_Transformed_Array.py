class Solution(object):
    def sortTransformedArray(self, nums, a, b, c):
        """
        :type nums: List[int]
        :type a: int
        :type b: int
        :type c: int
        :rtype: List[int]
        """
        result = [None] * len(nums)
        if a == 0 and b >= 0:
            return [b * x + c for x in nums]
        if a == 0 and b < 0:
            return ([b * x + c for x in nums])[::-1]

        pivot = (b / (2.0 * a)) * (-1.0)
        left, right, tail = 0, len(nums) - 1, len(nums) - 1
        while left <= right:
            if abs(nums[left] - pivot) >= abs(nums[right] - pivot):
                result[tail] = a * nums[left] ** 2 + b * nums[left] + c
                left += 1
            else:
                result[tail] = a * nums[right] ** 2 + b * nums[right] + c
                right -= 1
            tail -= 1
        if a > 0:
            return result
        return result[::-1]
