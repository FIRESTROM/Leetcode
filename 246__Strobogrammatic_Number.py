class Solution(object):
    def isStrobogrammatic(self, num):
        """
        :type num: str
        :rtype: bool
        """
        d = {
            '0':'0',
            '1':'1',
            '2':'#',
            '3':'#',
            '4':'#',
            '5':'#',
            '6':'9',
            '7':'#',
            '8':'8',
            '9':'6',
        }

        num_rev = [d[i] for i in num]          # upside-down each number
        return list(num) == num_rev[::-1]

# Or a Faster Solution
class Solution(object):
    def isStrobogrammatic(self, num):
        """
        :type num: str
        :rtype: bool
        """
        if len(num) < 1:
            return False
        maps = {("0", "0"), ("1", "1"), ("6", "9"), ("8", "8"), ("9", "6")}
        l, r = 0, len(num) - 1
        while l <= r:
            if (num[l], num[r]) not in maps:
                return False
            l += 1
            r -= 1
        return True
