class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        result = 0
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if not (set(words[i]) & set(words[j])):
                    result = max(result, len(words[i]) * len(words[j]))
        return result

# Or Bit Manipulation, much faster!

class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        # 26-bits: store distinct letters
        values = [0] * len(words)
        result = 0
        for i in range(len(words)):
            for char in words[i]:
                values[i] |= 1 << (ord(char) - ord('a'))
            for j in range(i):
                if values[i] & values[j] == 0:
                    result = max(result, len(words[i]) * len(words[j]))
        return result
