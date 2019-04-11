# Clean DFS Solution
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        def DFS(queens, xy_dif, xy_sum):
            p = len(queens)
            if p == n:
                result.append(queens)
                return None
            for q in range(n):
                if q not in queens and p - q not in xy_dif and p + q not in xy_sum:
                    DFS(queens + [q], xy_dif + [p - q], xy_sum + [p + q])
        result = []
        DFS([],[],[])
        return [ ["." * i + "Q" + "." * (n - i - 1) for i in sol] for sol in result]

# Backtracking Solution
class Solution:
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        if n == 0:
            return []
        self.n = n
        self.col_taken, self.diag_taken, self.antiDiag_taken = set(), set(), set()
        self.result = []
        self.search(0, [])

        return self.result

    # We will go row by row, for each row, try putting a queen on each column
    def search(self, row, path):
        if row == self.n:
            self.result.append(path)
            return

        for col in range(self.n):
            if col not in self.col_taken and col - row not in self.diag_taken and col + row not in self.antiDiag_taken:
                self.col_taken.add(col)
                self.diag_taken.add(col - row)
                self.antiDiag_taken.add(col + row)
                self.search(row + 1, path + ["." * col + "Q" + (self.n - col - 1) * "."])
                self.col_taken.remove(col)
                self.diag_taken.remove(col - row)
                self.antiDiag_taken.remove(col + row)
