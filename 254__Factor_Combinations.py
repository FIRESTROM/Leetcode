class Solution(object):
    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        return self.getFactorsFrom(n, 2)

    def getFactorsFrom(self, n, start):
        result = []
        for i in range(start, int(math.floor(math.sqrt(n))) + 1):
            if n % i == 0:
                result.append([i, n / i])
                for partial in self.getFactorsFrom(n / i, i):
                    result.append([i] + partial)
        return result
    
