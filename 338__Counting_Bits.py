# Most Significant Bit
class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        result = [0] * (num + 1)
        i, b = 0, 1
        while b <= num:
            while i < b and i + b <= num:
                result[i + b] = result[i] + 1
                i += 1
            i = 0
            b <<= 1
        return result

# Least Significant Bit
class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        result = [0] * (num + 1)
        for i in range(1, num + 1):
            result[i] = result[i >> 1] + (i & 1)
        return result
