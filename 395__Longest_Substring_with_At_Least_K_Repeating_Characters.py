class Solution(object):
    def longestSubstring(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        if len(s) < k:
            return 0

        for char in set(s):
            if s.count(char) < k:
                return max(self.longestSubstring(z, k) for z in s.split(char))
        return len(s)
