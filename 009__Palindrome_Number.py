class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        if x == 0:
            return True
        stack = []
        while x != 0:
            stack = [x % 10] + stack
            x /= 10
        for i in range(len(stack) / 2):
            if stack[i] != stack[-i-1]:
                return False
        return True
        
