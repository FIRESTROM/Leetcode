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

    def search(self, r, path):
        if r == self.n:
            self.result.append(path)
            return

        for c in range(self.n):
            if c not in self.col_taken and c - r not in self.diag_taken and c + r not in self.antiDiag_taken:
                self.col_taken.add(c)
                self.diag_taken.add(c - r)
                self.antiDiag_taken.add(c + r)
                self.search(r + 1, path + ["." * c + "Q" + (self.n - c - 1) * "."])
                self.col_taken.remove(c)
                self.diag_taken.remove(c - r)
                self.antiDiag_taken.remove(c + r)
