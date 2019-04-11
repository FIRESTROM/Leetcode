class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        def change_binary(a):
            result = 0
            temp = 1
            while a:
                result += temp * (a % 10)
                temp *= 2
                a /= 10
            return result

        def change_hex(a):
            result = 0
            temp = 1
            while a:
                result += temp * (a % 2)
                temp *= 10
                a /= 2
            return result

        return str(change_hex(change_binary(int(a)) + change_binary(int(b))))



class Solution:
    def addBinary(self, a, b):
        if len(a) == 0: return b
        if len(b) == 0: return a
        if a[-1] == '1' and b[-1] == '1':
            return self.addBinary(self.addBinary(a[0:-1],b[0:-1]),'1')+'0'
        if a[-1] == '0' and b[-1] == '0':
            return self.addBinary(a[0:-1],b[0:-1])+'0'
        else:
            return self.addBinary(a[0:-1],b[0:-1])+'1'
