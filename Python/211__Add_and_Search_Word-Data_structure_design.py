class Node:
    def __init__(self, is_word_end=False):
        self.children = {}
        self.is_word_end = is_word_end

class WordDictionary(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Node()

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        curr = self.root
        for i, char in enumerate(word):
            last_char_check = (i == len(word) - 1)
            if char not in curr.children:
                curr.children[char] = Node(last_char_check)
            elif last_char_check:
                curr.children[char].is_word_end = True
            curr = curr.children[char]


    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        return self.helper(word, self.root)


    def helper(self, word, curr):
        for i, char in enumerate(word):
            last_char_check = (i == len(word) - 1)
            if char == ".":
                if last_char_check:
                    return self.wildcard_terminates(curr)
                else:
                    return self.recursive_wildcard_search(word[i + 1:], curr)
            if char not in curr.children:
                return False
            curr = curr.children[char]
        return curr.is_word_end

    def wildcard_terminates(self, node):
        return any(map(lambda x: x.is_word_end, node.children.values()))

    def recursive_wildcard_search(self, word, node):
            return any(map(lambda x: self.helper(word, x), node.children.values()))



# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)


# Another Faster Solution Using Dictionary


class WordDictionary(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.len2words = collections.defaultdict(list)


    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        self.len2words[len(word)].append(word)


    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        words = self.len2words[len(word)]
        for i, char in enumerate(word):
            words = [w for w in words if char in (".", w[i])]
            if not words:
                return False
        return True


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
