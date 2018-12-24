# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
# def knows(a, b):

class Solution(object):
    def findCelebrity(self, n):
        """
        :type n: int
        :rtype: int
        """
        candidate = 0
        # if candidate knows anyone then it should be replaced
        # i is known by someone, so it might be a candidate
        # the last candidate is the one who dont konw anyone after it
        for i in range(n):
            if knows(candidate, i):
                candidate = i

        # check if the candidate know anyone before
        for i in range(candidate):
            if knows(candidate,i):
                return -1

        # check anyone after know candidate
        for i in range(candidate, n):
            if not knows(i, candidate):
                return -1

        return candidate

                
