class Solution(object):
    def generatePossibleNextMoves(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if not s:
            return []
        result = []
        for i in range(1, len(s)):
            if s[i - 1 : i + 1]== "++":
                result.append(s[:i - 1] + "--" + s[i + 1:])
        return result
