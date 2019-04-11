class ValidWordAbbr(object):

    def __init__(self, dictionary):
        """
        :type dictionary: List[str]
        """
        self.dic = {}
        for word in set(dictionary):
            abbr = self.abbrev(word)
            if abbr not in self.dic:
                self.dic[abbr] = word
            else:
                self.dic[abbr] = False


    def isUnique(self, word):
        """
        :type word: str
        :rtype: bool
        """
        abbr = self.abbrev(word)
        if abbr not in self.dic:
            return True
        else:
            return self.dic[abbr] == word

    def abbrev(self, word):
        if len(word) < 3:
            return word
        else:
            return word[0] + str(len(word) - 2) + word[-1]



# Your ValidWordAbbr object will be instantiated and called as such:
# obj = ValidWordAbbr(dictionary)
# param_1 = obj.isUnique(word)
