class Solution(object):
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        result = 0
        mask = 1
        for i in range(31):
            if m & mask == 0 or n & mask == 0:  # 0 appears
                bit = 0
            else: # two 1s
                if n - m >= (1 << i):  # n - m >= 2 ** i
                    bit = 0
                else:
                    bit = 1
            if bit == 1:
                result = result | mask
            mask <<= 1

        return result
