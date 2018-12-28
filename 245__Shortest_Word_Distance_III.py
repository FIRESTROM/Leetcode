class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        w1, w2 = [], []
        for i, word in enumerate(words):
            if word == word1:
                w1.append(i)
            elif word == word2:
                w2.append(i)

        result = float("inf")
        if len(w2):
            for i in w1:
                for j in w2:
                    if abs(i - j) < result:
                        result = abs(i - j)
        else:
            for i in range(len(w1) - 1):
                result = min(result, abs(w1[i] - w1[i + 1]))
        return result
