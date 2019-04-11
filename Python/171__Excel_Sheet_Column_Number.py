class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        for i in s:
            result = result * 26 + ord(i) - ord("A") + 1
        return result
