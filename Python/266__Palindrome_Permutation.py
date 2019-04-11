class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        dic = {}
        for item in s:
            dic[item] = dic.get(item, 0) + 1

        count = 0
        for val in dic.values():
            if val % 2 == 1:
                count += 1
            if count > 1:
                return False
        return True
