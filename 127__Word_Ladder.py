class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        # Check if there exits wordlist and endword is in wordlist
        if wordList == [] or endWord not in wordList:
            return 0

        # Get a list that stores all appeared letter in ith char in thess words,
        # since only change ith char to these letters can be a possible match
        # appeared in the wordList.
        word_dict = [set() for _ in range(len(beginWord))]
        for i in range(len(beginWord)):
            for word in wordList:
                word_dict[i].add(word[i])

        # WordSet keeps all unvisited words
        wordSet = set(wordList)
        front = set([beginWord])
        end = set([endWord])
        wordSet.remove(endWord)

        level = 2
        # Each time, go through all words that appears first in this level
        while front:
            newset = set()
            for word in front:
                for i in range(len(word)):
                    for char in word_dict[i]:
                        # New word
                        new_word = word[:i] + char + word[i + 1:]
                        # If this is in the end set, then finish
                        if new_word in end:
                            return level
                        # If not in end set but still in wordSet, which means
                        # this is the first time that this word is find during
                        # word changing. We add this to next set to check, and
                        # remove it from wordSet since it's visited.
                        elif new_word in wordSet:
                            newset.add(new_word)
                            wordSet.remove(new_word)
            # Update front set and level
            front = newset
            level += 1
            # Always look through the smaller one
            if len(front) > len(end):
                front, end = end, front
        # If finish looking and no return, then not able to get a match.
        return 0
