from bisect import bisect_left
class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        result = []
        for _, h in sorted(envelopes, key = lambda env : (env[0], -env[1])):
            pos = bisect_left(result, h)
            if pos == len(result):
                result.append(h)
            else:
                result[pos] = h
        return len(result)  
