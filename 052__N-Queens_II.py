class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return []
        self.n = n
        self.col_taken, self.diag_taken, self.antiDiag_taken = set(), set(), set()
        self.result = 0
        self.search(0)

        return self.result

    # We will go row by row, for each row, try putting a queen on each column
    def search(self, row, path):
        if row == self.n:
            self.result += 1
            return

        for col in range(self.n):
            if col not in self.col_taken and col - row not in self.diag_taken and col + row not in self.antiDiag_taken:
                self.col_taken.add(col)
                self.diag_taken.add(col - row)
                self.antiDiag_taken.add(col + row)
                self.search(row + 1)
                self.col_taken.remove(col)
                self.diag_taken.remove(col - row)
                self.antiDiag_taken.remove(col + row)
