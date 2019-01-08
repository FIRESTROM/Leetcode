class Solution(object):
    def generateAbbreviations(self, word):
        """
        :type word: str
        :rtype: List[str]
        """
        result = []
        self.helper(word, "", 0, 0, result)
        return result

    def helper(self, word, changed_word, start, count, results):
        if start == len(word):
            if count > 0:
                changed_word += str(count)
            results.append(changed_word)
            return
        self.helper(word, changed_word, start + 1, count + 1, results)
        if count > 0:
            changed_word += str(count)
        self.helper(word, changed_word + word[start], start + 1, 0, results) 


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
