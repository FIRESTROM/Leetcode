class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 1:
            return 0

        isPrime = [True] * n
        isPrime[0] = False

        for i in xrange(2, n):
            if i * i > n:
                break;
            if not isPrime[i]:
                continue;
            for j in xrange(i * i, n, i):
                isPrime[j] = False

        count = 0

        for i in xrange(2, n):
            if isPrime[i]:
                count += 1

        return count
