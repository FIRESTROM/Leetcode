class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        result = 0
        if x > 0 :
            while x != 0:
                result = result * 10 + x % 10
                x /= 10
        else :
            x *= -1
            while x != 0:
                result = result * 10 + x % 10
                x /= 10
            result *= -1
        if result > 2 ** 31 or result < - 2 ** 31:
            return 0

        return result
