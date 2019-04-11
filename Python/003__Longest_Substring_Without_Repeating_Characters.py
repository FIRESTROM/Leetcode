# Naive Sliding Window Solution

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        check = set()
        maxlen = 0
        l, r = 0, 0
        while l < len(s) and r < len(s) :
            if s[r] not in check:
                check.add(s[r])
                r += 1
                maxlen = max(maxlen, r - l)
            else:
                check.remove(s[l])
                l += 1
        return maxlen


# Sliding Window Optimized Solution

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0

        d = {}
        maxlen = 0
        left = 0
        for i, right in enumerate(s):
            if right in d and d[right] >= left:
                maxlen = max(i - left, maxlen)
                left = d[right] + 1
            d[right] = i
        return max(len(s) - left, maxlen)
