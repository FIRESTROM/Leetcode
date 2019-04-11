class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        check = {}
        maxval = 0

        for num in nums:
            check[num] = 1
            if num > maxval:
                maxval = num


        for i in range(1, maxval):
            if i not in check:
                return i

        return maxval + 1
        
