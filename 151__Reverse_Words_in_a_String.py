class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        s += " " #in case, no trailing spaces
        words = []
        word = ""
        for i in range(len(s)):
            if s[i] != " ":
                word += s[i]
            else:
                if word:
                    words.append(word)
                word = ""
        result = ""
        while words:
            result += words.pop()
            if words:
                result += " "
        return result

# Simpler Solution
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return " ".join(s.split()[::-1])
