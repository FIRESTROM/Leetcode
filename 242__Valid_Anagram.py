class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        if len(s) != len(t):
            return False
        if len(s) == 0:
            return True

        dic = {}
        for str in s:
            if str in dic:
                dic[str] += 1
            else:
                dic[str] = 1
        for str in t:
            if str in dic:
                if dic[str] == 0:
                    return False
                dic[str] -= 1
            else:
                return False
        return True
