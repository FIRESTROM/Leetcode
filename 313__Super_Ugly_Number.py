class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        ugly_numbers = [0] * n
        ugly_numbers[0] = 1
        indexes = [0] * len(primes)
        refactors = [i for i in primes]
        for i in range(1, n):
            ugly_numbers[i] = min(refactors)
            for ind in [k for k, x in enumerate(refactors) if x == ugly_numbers[i]]:
                indexes[ind] += 1
                refactors[ind] = ugly_numbers[indexes[ind]]*primes[ind]
        return ugly_numbers[-1]
