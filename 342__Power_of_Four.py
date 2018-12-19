import math
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0 or num & (num - 1) != 0:
            return False
        len = 0
        while num > 1:
            num = num >> 1
            len += 1
        if len % 2 != 0:
            return False
        return True
        
