class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 2:
            return 1
        result = [1] * (n + 1)
        for i in range(2, n + 1):
            maxval = 0
            for j in range(1, i):
                maxval = max(maxval, j * result[i - j], j * (i - j))
            result[i] = maxval
        return result[-1]


# A solution using Math
# First prove we should break into at most 3 ( >= 4 will definetely have better
# solution by combinning two numbers)
class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 2:
            return 1
        if n == 3:
            return 2
        if n == 4:
            return 4
        result = 1
        while n > 4:
            result *= 3
            n -= 3
        result *= n
        return result
