class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        board = board
        maxi = len(board)
        maxj = len(board[0])
        visited = [[False] * len(board[0]) for _ in range(len(board))]
        move = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def start_exist(i, j, word, visited):

            if len(word) == 0:
                return True
            if word == board[i][j]:
                return True
            if board[i][j] != word[0]:
                return False
            else:
                visited[i][j] = True
                for di, dj in move:
                    if 0 <= i + di < maxi and 0 <= j + dj < maxj and not visited[i + di][j + dj]:
                        if start_exist(i + di, j + dj, word[1:], visited):
                            return True
                visited[i][j] = False
                return False

        for i in range(maxi):
            for j in range(maxj):
                if start_exist(i, j, word, visited):
                    return True

        return False
