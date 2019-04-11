class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        len_s = len(s)
        dp = [0 for _ in range(len_s + 1)]
        dp[0] = 1
        for i in xrange(1, len_s + 1):
            for str in wordDict:
                l = len(str)
                if i - 1 + l > len_s:
                    continue
                if i - 1 + l <= len_s and s[i - 1: i + l - 1] == str:
                    if dp[i - 1] == 1:
                        dp[i - 1 + l] = 1
        return dp[-1] == 1
                    
