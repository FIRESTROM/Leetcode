class Solution(object):
    def integerReplacement(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = 0
        while n != 1:
            if bin(n)[-1] == "0":
                n = n >> 1
            else:
                if bin(n)[-2] == "1" and len(bin(n)) != 4:
                    n += 1 # if "11" +1
                else:
                    n -= 1 # if "01" -1
            result += 1
        return result
