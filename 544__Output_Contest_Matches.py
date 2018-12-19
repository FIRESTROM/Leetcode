class Solution(object):
    def findContestMatch(self, n):
        """
        :type n: int
        :rtype: str
        """
        R = tuple(range(1, n+1))
        while len(R) > 2:
            R = tuple((R[i],R[~i]) for i in xrange(len(R)/2))
        return str(R).replace(' ','')
