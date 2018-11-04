# DP solution

class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """

        table = [[False] * (len(s) + 1)  for _ in range(len(p) + 1)]
        table[0][0] = True

        for i in range(1, len(p) + 1):
            table[i][0] = table[i - 1][0] and p[i - 1] == "*"

        for i in range(1,len(p) + 1):
            for j in range(1,len(s) + 1):
                if p[i - 1] != "*":
                    table[i][j] = ( p[i - 1] == s[j - 1] or p[i - 1] == '?') and table[i - 1][j - 1]
                else:
                    table[i][j] = table[i][j - 1] or table[i - 1][j]
                    
        return table[-1][-1]
