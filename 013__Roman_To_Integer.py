class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        map = {"I":1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000}
        result = 0
        front = map[s[0]]
        for i in range(len(s) - 1):
            next = map[s[i + 1]]
            if front < next:
                result -= front
            else:
                result += front
            front = next
        result += map[s[-1]]

        return result
