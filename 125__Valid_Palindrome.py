class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        s = [i for i in s if i.isalnum()]

        if len(s) == 0:
            return True

        for i in range(int(len(s) / 2)):
            if s[i] != s[len(s)- i- 1]:
                return False
        return True
