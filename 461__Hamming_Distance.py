class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        result = 0
        while x or y:
            if x % 2 != y % 2:
                result += 1
            x /= 2
            y /= 2
        return result
