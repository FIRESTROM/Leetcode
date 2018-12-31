class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.strip()
        numSeen = False
        dotSeen = False
        eSeen = False
        numAfterE = True

        for i, char in enumerate(s):
            if char.isdigit():
                numSeen = True
                numAfterE = True
            elif char == ".": # e.g. 1.2e1, 12e1.2(invalid)
                if eSeen or dotSeen:
                    return False
                dotSeen = True
            elif char == "e": # should be no e before e, number needs to be seen before e
                if eSeen or not numSeen:
                    return False
                eSeen = True
                numAfterE = False
            elif char in ["+", "-"]: #e.g. +1, -3, 1e+2 are valid
                if i != 0 and s[i-1] != "e":
                    return False
            else:
                return False
        return numSeen and numAfterE
