class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        for index_1 in range(len(nums) - 3):
            if index_1 > 0 and nums[index_1] == nums[index_1 - 1]:
                continue;

            for index_4 in range(len(nums) - 1, 2, -1):
                if index_4 < len(nums) - 1 and nums[index_4] == nums[index_4 + 1]:
                    continue;

                index_2, index_3 = index_1 + 1, index_4 - 1
                while index_2 < index_3:
                    val = nums[index_1] + nums[index_2] + nums[index_3] + nums[index_4]
                    if val == target:
                        result.append([nums[index_1], nums[index_2], nums[index_3], nums[index_4]])
                        while index_2 < index_3 and nums[index_2] == nums[index_2 + 1]:
                            index_2 += 1

                        while index_2 < index_3 and nums[index_3] == nums[index_3 - 1]:
                            index_3 -= 1
                        index_2 += 1
                        index_3 -= 1
                    elif val < target:
                        index_2 += 1
                    else:
                        index_3 -= 1
        return result


# A better general solution: Solve NSum Problem

class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        results = []
        self.findNsum(nums, target, 4, [], results)
        return results

    def findNsum(self, nums, target, N, result, results):
        """
        nums is a sorted arr
        """
        if len(nums) < N or N < 2:
            return

        # solve 2 sum here
        if N == 2:
            l, r = 0, len(nums) - 1
            while l < r:
                if nums[l] + nums[r] == target:
                    results.append(result + [nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                    while l < r and nums[r] == nums[r + 1]:
                        r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    r -= 1
        else:
            for i in range(len(nums) - N + 1):
                # pruning
                if target < nums[i] * N or target > nums[-1] * N:
                    break
                if i == 0 or (i > 0 and nums[i - 1] != nums[i]):
                    self.findNsum(nums[i + 1:], target - nums[i], N - 1, result + [nums[i]], results)
        return
