class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        wordList = set(wordList)
        result = []
        layer = {}
        layer[beginWord] = [[beginWord]]

        if beginWord in wordList:
            wordList.remove(beginWord)


        while layer:
            newlayer = collections.defaultdict(list)
            for w in layer:
                if w == endWord:
                    result = layer[w]
                    return result
                else:
                    for i in range(len(w)):
                        for char in 'abcdefghijklmnopqrstuvwxyz':
                            neww = w[:i] + char + w[i + 1:]
                            if neww in wordList:
                                newlayer[neww] += [j + [neww] for j in layer[w]]

            wordList -= set(newlayer.keys())
            layer = newlayer

        return result
