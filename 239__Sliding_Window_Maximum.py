class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if k > nums:
            return [max(nums)]
        if len(nums) == 0:
            return []

        temp_max = nums[0]
        valid = 0
        for i in range(k):
            if nums[i] > temp_max:
                temp_max = nums[i]
                valid = i

        result = [temp_max]
        for i in range(1, len(nums) - k + 1):
            if valid == 0:
                temp_max, valid = nums[i], 0
                for j in range(i, i + k):
                    if nums[j] > temp_max:
                        temp_max = nums[j]
                        valid = j - i
                result.append(temp_max)
            else:
                if temp_max > nums[i + k - 1]:
                    result.append(temp_max)
                    valid -= 1
                else:
                    temp_max = nums[i + k - 1]
                    result.append(temp_max)
                    valid = k - 1
        return result
