class WordDistance(object):

    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.dic = collections.defaultdict(list)
        for i, word in enumerate(words):
            self.dic[word].append(i)
        self.max = len(words)


    def shortest(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        i1_list = self.dic[word1]
        i2_list = self.dic[word2]

        i1 = 0
        i2 = 0
        result = self.max

        while i1 < len(i1_list) and i2 < len(i2_list):
            if i1_list[i1] > i2_list[i2]:
                result = min(i1_list[i1] - i2_list[i2], result)
                i2 += 1
            else:
                result = min(i2_list[i2] - i1_list[i1], result)
                i1 += 1
        return result



# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)
