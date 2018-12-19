class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not len(s):
            return ''
        l = 0
        r = len(s)-1
        ss = ['']*len(s)
        while l < r:
            ss[l] = s[r]
            ss[r] = s[l]
            l+=1
            r-=1
        if l == r:
            ss[l] = s[r]
        return ''.join(ss)
