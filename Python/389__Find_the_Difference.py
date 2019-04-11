class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        dic = collections.defaultdict(int)
        for char in s:
            dic[char] += 1
        for char in t:
            if dic[char] == 0:
                return char
            else:
                dic[char] -= 1
