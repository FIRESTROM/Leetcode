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



## Another similar solution but looks more elegent

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        result = 1
        if n < 0:
            x = float(1 / x)
            n = n * -1
        temp = x
        while n > 0:
            if n % 2 == 1:
                result *= temp
            temp *= temp
            n /= 2
        return result
