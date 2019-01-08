class Solution(object):
    def generateAbbreviations(self, word):
        """
        :type word: str
        :rtype: List[str]
        """
        self.result = []
        self.helper(word, "", 0, 0)
        return self.result

    def helper(self, word, changed_word, start, count):
        if start == len(word):
            if count > 0:
                changed_word += str(count)
            self.result.append(changed_word)
            return
        # Abbreviate this char at start
        self.helper(word, changed_word, start + 1, count + 1)
        # Not Abbreviate this char at start
        if count > 0:
            changed_word += str(count)
        self.helper(word, changed_word + word[start], start + 1, 0)


# Recursion with DP Solution
class Solution(object):
    def gen(self, word, memo):

        if word in memo: return memo[word]

        res = []
        for i in range(1, len(word)+1):
            res += [str(i) + word[i:i+1] + sub_word for sub_word in self.gen(word[i+1:], memo)]
        res += [word[0] + sub_word for sub_word in self.gen(word[1:], memo)]

        memo[word] = res
        return res

    def generateAbbreviations(self, word):
        """
        :type word: str
        :rtype: List[str]
        """
        return self.gen(word, {'': ['']})
