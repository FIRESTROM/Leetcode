## An dynamic programming solution.

class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        dp = [[True] * len(s) for _ in range(len(s))]
        result = len(s)
        for length in range(1, len(s)):
            for start in range(len(s) - length):
                end = start + length
                dp[start][end] = (s[start] == s[end]) and dp[start + 1][end - 1]
                if dp[start][end]:
                    result += 1
        return result



## This is a solution about center. For array with length n, there are 2 * n - 1
## centers: either at the i_th element, or between i_th and i+1_th.
def countSubstrings(self, s):

    N = len(s)
    ans = 0
    for center in xrange(2 * N - 1):
        left = center / 2
        right = left + center % 2
        while left >= 0 and right < N and s[left] == s[right]:
            ans += 1
            left -= 1
            right += 1
    return ans
