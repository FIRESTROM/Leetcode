class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        dic = {}
        for i in range(length):
            if nums[i] not in dic:
                dic[nums[i]] = 1
            else:
                dic[nums[i]] += 1
        for key, val in dic.items():
            if val == 1:
                return key

# Bit Manipulation

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        for i in range(32):
            temp = 0
            for num in nums:
                temp += (num >> i) & 1
            result = result + (temp % 3) * (2 ** i)
        return self.convert(result)

    def convert(self, x):
        if x >= 2 ** 31:
            x -= 2 ** 32
        return x
