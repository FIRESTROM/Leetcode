class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        if n == 0:
            return [0]
        elif n == 1:
            return [0, 1]
        else:
            l1 = self.grayCode(n - 1)
            l2 = [l + (1 << (n - 1)) for l in l1[::-1]]
        return l1 + l2
