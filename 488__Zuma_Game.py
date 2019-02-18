class Solution(object):
    def findMinStep(self, board, hand):
        """
        :type board: str
        :type hand: str
        :rtype: int
        """
        self.balls = collections.Counter(hand)
        self.result = float("inf")
        self.dfs(board, 0)
        return self.result if self.result < float('inf') else -1

    def dfs(self, board, steps):

        board, N = self.prune(board)

        if not board:
            self.result = min(self.result, steps)

        i = 0
        while i < N:
            cur = board[i]
            j = i
            while j < N and board[j] == cur:
                j += 1
            if j - i <= 2 and self.balls[cur] >= 3 - (j-i):
                self.balls[cur] -= 3 - (j-i)
                self.dfs(board[:i] + board[j:], steps + 3 - (j - i))
                self.balls[cur] += 3 - (j-i)
            elif j - i > 2:
                self.dfs(board[:i] + board[j:], steps)
            i = j


    def prune(self, board):
        new_board = ""
        N = len(board)
        i = 0
        while i < N:
            j = i
            while j < N and board[j] == board[i]:
                j += 1
            if j - i <= 2:
                new_board += board[i:j]
            i = j
        return new_board, len(new_board)
