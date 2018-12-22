class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = 0
        while n:
            if n & 1 == 1:
                result += 1
            n = n >> 1
        return result

# Another solution using a trick of bit

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = 0
        while n:
          result += 1
          n = n & (n - 1)  # Flip the least significant 1
        return result
