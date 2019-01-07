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

    def search(self, r):
        if r == self.n:
            self.result += 1
            return

        for c in range(self.n):
            if c not in self.col_taken and c - r not in self.diag_taken and c + r not in self.antiDiag_taken:
                self.col_taken.add(c)
                self.diag_taken.add(c - r)
                self.antiDiag_taken.add(c + r)
                self.search(r + 1)
                self.col_taken.remove(c)
                self.diag_taken.remove(c - r)
                self.antiDiag_taken.remove(c + r)
