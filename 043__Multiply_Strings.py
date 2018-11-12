class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        def toint(num):
            result = 0
            for i in num:
                result = result * 10 + ord(i) - ord('0')
            return result
        return str(toint(num1) * toint(num2))

        
