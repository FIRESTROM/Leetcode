class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if needle == "":
            return 0
        m, n = len(haystack), len(needle)
        if haystack == needle :
            return 0

        for i in range(m - n + 1):
            if haystack[i:i+n] == needle:
                return i
        return -1
        
