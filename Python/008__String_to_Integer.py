class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        # Check all spaces
        start_index = 0
        while start_index < len(str) and str[start_index] == " ":
            start_index += 1
        if start_index == len(str):
            return 0
        # Check - or + sign
        sign = 1
        if str[start_index] == "-":
            sign = -1
            start_index += 1
        elif str[start_index] == "+":
            start_index += 1
        if start_index == len(str):
            return 0

        # Check first bit is number
        dic = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]

        if str[start_index] not in dic:
            return 0
        else:
            result = 0
            while start_index < len(str) and str[start_index] in dic:
                result = result * 10 + int(str[start_index])
                start_index += 1
            # Check overflow
            if result > 2 ** 31 - 1 or result < -1 * 2 ** 31:
                return 2 ** 31 - 1 if sign == 1 else -1 * 2 ** 31

            return result * sign

        return 0
