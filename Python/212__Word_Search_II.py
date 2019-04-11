class Solution(object):

    def buildTrie(self, words):
        trie = {}
        for word in words:
            cur = trie
            for char in word:
                cur = cur.setdefault(char, {})
            cur["word"] = word
        return trie


    def dfs(self, board, i, j, trie):
        # found one
        if trie.get("word"):
            self.res.append(trie["word"])
            # de-duplicate
            trie["word"] = None
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] not in trie:
            return
        c, board[i][j] = board[i][j], "#"
        self.dfs(board, i - 1, j, trie[c])
        self.dfs(board, i + 1, j, trie[c])
        self.dfs(board, i, j - 1, trie[c])
        self.dfs(board, i, j + 1, trie[c])
        board[i][j] = c

    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        # Backtracking + Trie
        trie = self.buildTrie(words)
        self.res = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, i, j, trie)
        return self.res

    
