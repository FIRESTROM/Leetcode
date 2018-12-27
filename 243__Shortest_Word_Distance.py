class Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        result = len(words) + 1
        index = None
        found = None
        for i, word in enumerate(words):
            if word == word1 or word == word2:
                if found is not None:
                    if word != found:
                        result = min(result, i - index)
                found = word
                index = i
        return result
