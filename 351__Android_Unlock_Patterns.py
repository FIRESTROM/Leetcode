# Using DFS Solution
class Solution(object):
    def numberOfPatterns(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        skip = {(1,7) : 4, (1, 3) : 2, (1, 9) : 5, (2, 8) : 5, (3, 7) : 5, (3, 9) : 6, (4, 6) : 5, (7, 9) : 8}
        self.result = 0

        def dfs(used, last):
            if len(used) >= m:
                self.result += 1
            if len(used) == n:
                return
            for j in range(1, 10):
                if j not in used:   # if j is not used
                    # Sort the vertices of the edge to search in skip
                    edge = (min(last, j), max(last, j))
                    if edge not in skip or skip[edge] in used:
                        dfs(used + [j], j)

        for i in range(1, 10):
            dfs([i], i)
        return self.result
# Can be optimized by only start at 1, 2, and 5.
# result = dfs([1], 1) * 4 + dfs([2], 2) * 4 + dfs([5], 5)
