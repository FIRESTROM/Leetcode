# Boyer-Moore Majority Vote Algorithm
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return nums

        check = len(nums) / 3
        val1, val2 = nums[0], nums[1]
        count1, count2 = 0, 0
        for n in nums:
            if n == val1:
                count1 += 1
                continue
            if n == val2:
                count2 += 1
                continue
            if count1 == 0:
                val1 = n
                count1 = 1
                continue
            if count2 == 0:
                val2 = n
                count2 = 1
                continue
            count1 -= 1
            count2 -= 1

        count1, count2 = 0, 0
        for n in nums:
            if n == val1:
                count1 += 1
            if n == val2:
                count2 += 1
        result = []
        if count1 > check:
            result.append(val1)
        if count2 > check and val2 != val1:
            result.append(val2)

        return result

# Another normal solution, not O(1) space complexity

from collections import defaultdict
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        dic = defaultdict(int)
        check = len(nums) / 3

        for i in nums:
            if i not in dic:
                dic[i] = nums.count(i)

        for val, times in dic.items():
            if times > check:
                result.append(val)
        return result
