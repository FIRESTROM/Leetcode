class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        result = 0
        count = 0
        while count < 32:
            temp = n % 2
            n = n >> 1
            result = (result << 1) + temp
            count += 1
        return result

   
