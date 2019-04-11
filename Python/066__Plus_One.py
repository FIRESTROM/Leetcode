class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        index = 0
        if digits[-1] == 9:
            index = 1
            i = len(digits) - 1
            while i >= 0:
                if index == 0:
                    return digits
                temp = digits[i] + 1
                index = temp / 10
                digits[i] = temp % 10
                i -= 1
            if index == 1:
                digits[0] = 0
                return [1] + digits
            return digits
        else:
            digits[-1] += 1
            return digits
