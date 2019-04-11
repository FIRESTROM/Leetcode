class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if s == t:
            return False
        if len(s) == len(t):
            for i in range(len(s)):
                if s[:i] + s[i + 1:] == t[:i] + t[i + 1:]:
                    return True
            return False
        elif len(s) - len(t) == 1:
            for i in range(len(s)):
                if s[:i] + s[i + 1:] == t:
                    return True
            return False
        elif len(t) - len(s) == 1:
            for i in range(len(t)):
                if s == t[:i] + t[i + 1:]:
                    return True
            return False
        else:
            return False

# Another Simpler Solution
class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) > len(t):
            return self.isOneEditDistance(t, s)
        if abs(len(s) - len(t)) > 1 or s == t:
            return False
        for i in range(len(s)):
            if s[i] != t[i]:
                return s[i + 1:] == t[i + 1:] or s[i:] == t[i + 1:]
        return True
