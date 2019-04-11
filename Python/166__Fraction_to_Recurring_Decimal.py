class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        if numerator == 0:
            return "0"

        neg = (numerator < 0) ^ (denominator < 0)
        w, r = divmod(abs(numerator), abs(denominator))
        s = str(w)
        if neg:
            s = "-" + s
        if r:
            s += '.'
        i = len(s)
        nums = {r: i}
        while r:
            w, r = divmod(r * 10, abs(denominator))
            s += str(w)
            if r in nums:
                s = s[:nums[r]] + "(" + s[nums[r]:] + ")"
                return s
            i += 1
            nums[r] = i
        return s
        
