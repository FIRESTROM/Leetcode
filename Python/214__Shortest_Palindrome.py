# KMP Solution
class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        new_s = s + "#" + s[::-1]
        next = self.makeNext(new_s)

        if (len(s) - next[-1]) == 0:
            return s
        else:
            return (s[-(len(s) - next[-1]):])[::-1] + s


    def makeNext(self, string):
        next = [0] * len(string)

        q = 1 # cursor in P, starting from 1
        k = 0 # k is the length of maximum common suffix and prefix

        while q < len(string):
            while k > 0 and string[q] != string[k]:
                k = next[k-1]
            if string[q] == string[k]:
                k+=1
            next[q] = k
            q +=1

        return next

# Or Easier But Slower Solution
class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        for i in range(len(s)):
            if s[:i] == s[:i][::-1]:
                return s[i:][::-1] + s
