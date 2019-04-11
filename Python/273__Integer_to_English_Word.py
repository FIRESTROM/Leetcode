class Solution(object):
    def one_number(self, i):
        if i == 1:
            return "One"
        if i == 2:
            return "Two"
        if i == 3:
            return "Three"
        if i == 4:
            return "Four"
        if i == 5:
            return "Five"
        if i == 6:
            return "Six"
        if i == 7:
            return "Seven"
        if i == 8:
            return "Eight"
        if i == 9:
            return "Nine"

    def two_number(self, i):
        if i == 10: return "Ten"
        if i == 11: return "Eleven"
        if i == 12: return "Twelve"
        if i == 13: return "Thirteen"
        if i == 14: return "Fourteen"
        if i == 15: return "Fifteen"
        if i == 16: return "Sixteen"
        if i == 17: return "Seventeen"
        if i == 18: return "Eighteen"
        if i == 19: return "Nineteen"
        if i == 20: return "Twenty"
        if i == 30: return "Thirty"
        if i == 40: return "Forty"
        if i == 50: return "Fifty"
        if i == 60: return "Sixty"
        if i == 70: return "Seventy"
        if i == 80: return "Eighty"
        if i == 90: return "Ninety"
        
    def three(self, num):

        result = []
        if num >= 100:
            result += [self.one_number(num / 100), "Hundred"]
            num = num % 100
        if num >= 10:
            if num / 10 == 1:
                result += [self.two_number(num)]
                return result
            else:
                result += [self.two_number(num / 10 * 10)]
                num = num % 10
        if 1 <= num < 10:
            result += [self.one_number(num)]

        return result



    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "Zero"
        result = []
        i = 0
        while num != 0:
            i += 1
            three_num = num % 1000
            if i == 1:
                result = self.three(three_num) + result
            if i == 2 and three_num != 0:
                result = self.three(three_num) + ["Thousand"] + result
            if i == 3 and three_num != 0:
                result = self.three(three_num) + ["Million"] + result
            if i == 4 and three_num != 0:
                result = self.three(three_num) + ["Billion"] + result
            num = num / 1000

        return " ".join(result)
