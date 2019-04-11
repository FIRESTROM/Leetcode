class TicTacToe(object):

    def __init__(self, n):
        """
        Initialize your data structure here.
        :type n: int
        """
        self.check_row = [0] * n
        self.check_col = [0] * n
        self.check_diag_1 = 0
        self.check_diag_2 = 0

        self.dim = n



    def move(self, row, col, player):
        """
        Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins.
        :type row: int
        :type col: int
        :type player: int
        :rtype: int
        """
        delta = 1 if player == 1 else -1
        self.check_row[row] += delta
        self.check_col[col] += delta
        if row == col:
            self.check_diag_1 += delta
        if row + col == self.n - 1:
            self.check_diag_2 += delta

        if abs(self.check_row[row]) == self.dim or abs(self.check_col[col]) == self.dim or abs(self.check_diag_1) == self.dim or abs(self.check_diag_2) == self.dim:
            return player

        return 0




# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)
