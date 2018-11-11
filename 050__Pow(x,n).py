class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1
        if n == 1:
            return x
        if n == -1:
            return float(1/x)
        if n > 0:
            temp = self.myPow(x, n / 2)
            return temp * temp * self.myPow(x, n % 2)
        else:
            temp = self.myPow(x, n / 2)
            return temp * temp * self.myPow(x, n % 2)

        
