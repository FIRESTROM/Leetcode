class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        def getsum(n):
            result = 0
            while n:
                result += (n % 10) ** 2
                n /= 10
            return result

        dic = {}
        while n:
            if n in dic:
                return False
            dic[n] = 1
            n = getsum(n)
            if n == 1:
                return True
