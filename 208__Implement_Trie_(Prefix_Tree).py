class TrieNode:
    def __init__(self):
        self.child = dict()
        self.isend = False

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()


    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        root = self.root
        for char in word:
            if char not in root.child:
                root.child[char] = TrieNode()
            root = root.child[char]
        root.isend = True



    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        root = self.root
        for char in word:
            if char in root.child:
                root = root.child[char]
            else:
                return False
        return root.isend


    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        root = self.root
        for char in prefix:
            if char in root.child:
                root = root.child[char]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
