class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        left, right = 1, x
        while left < right:
            mid = (left + right) // 2 + 1
            if mid * mid > x:
                right = mid - 1
            else:
                left = mid
        return right
        
