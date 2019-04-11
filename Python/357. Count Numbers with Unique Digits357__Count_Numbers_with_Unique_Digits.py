class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = []
        temp = 9
        for i in range(9, 0, -1):
            result.append(temp)
            temp *= i
        return sum(result[:n]) + 1
