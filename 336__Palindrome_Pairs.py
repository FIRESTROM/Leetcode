class Solution(object):
    def palindromePairs(self, words):
        """
        :type words: List[str]
        :rtype: List[List[int]]
        """
        def is_palindrome(s):
            return s == s[::-1]

        words = {word: i for i, word in enumerate(words)}
        result = []
        for word, i in words.iteritems():
            n = len(word)
            for j in range(n + 1):
                pref, suf = word[:j], word[j:]
                if is_palindrome(pref):
                    back = suf[::-1]
                    if back != word and back in words:
                        result.append([words[back],  i])
                if j != n and is_palindrome(suf):
                    back = pref[::-1]
                    if back != word and back in words:
                        result.append([i, words[back]])
        return result
