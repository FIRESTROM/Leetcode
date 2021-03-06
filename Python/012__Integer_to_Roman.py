class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        stack = [(1,'I'), (4,'IV'), (5,'V'), (9,'IX'), (10,'X'), (40,'XL'), (50, 'L'), (90, 'XC'), (100, 'C'), (400,'CD'), (500, 'D'), (900, 'CM'), (1000, 'M')]
        res = ''
        while num:
            if num >= stack[-1][0]:
                num -= stack[-1][0]
                res += stack[-1][1]
            else:
                stack.pop()

        return res
        
