class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        squares = [i**2 for i in range(1, int(math.sqrt(n) + 1))]
        thisVisit = set()
        thisVisit.add(0)
        toVisit = set()
        bfsRound = 0

        while True:
            bfsRound += 1
            for num in thisVisit:
                for square in squares:
                    if num + square < n:
                        toVisit.add(num + square)
                    elif num + square == n:
                        return bfsRound
                    else:
                        break
            thisVisit, toVisit = toVisit, set()
        
