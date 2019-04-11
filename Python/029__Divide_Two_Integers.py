class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        temp_dicidend, temp_divisor = abs(dividend), abs(divisor)
        quotient = 0
        while temp_dicidend >= temp_divisor:
            temp, i = temp_divisor, 1
            while temp_dicidend >= temp:
                temp_dicidend -= temp
                temp += temp
                quotient += i
                i += i
        if (dividend < 0 and divisor > 0) or (dividend > 0 and divisor < 0):
            quotient = -quotient

        return min(max(quotient, -pow(2,31)),pow(2,31)-1)
