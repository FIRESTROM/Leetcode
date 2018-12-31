class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if not s or not words:
            return []
        freq = {}
        for word in words:
            if word not in freq:
                freq[word] = 0
            freq[word] += 1

        m = len(words[0])
        ans = []
        for i in range(len(s) - m * len(words) + 1):
            if self.is_valid_concatenation(s, i, m, freq):
                ans.append(i)

        return ans

    def is_valid_concatenation(self, s, j, m, freq):
        dic = {}
        n = len(freq)
        while s[j : j + m] in freq and n > 0:
            word = s[j : j + m]
            if word not in dic:
                dic[word] = 0
            dic[word] += 1
            if dic[word] > freq[word]:
                break;
            if dic[word] == freq[word]:
                n -= 1
            j += m
        return n == 0
