class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix) == 0:
            return 0
        m, n = len(matrix), len(matrix[0])
        cache = [[0] * n for _ in range(m)]
        dic = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        result = 0

        def dfs(i, j):
            if cache[i][j] != 0:
                return cache[i][j]
            for d in dic:
                x, y = i + d[0], j + d[1]
                if 0 <= x < m and 0 <= y < n and matrix[x][y] > matrix[i][j]:
                    cache[i][j] = max(cache[i][j], dfs(x, y))
            cache[i][j] += 1
            return cache[i][j]


        for i in range(m):
            for j in range(n):
                result = max(result, dfs(i, j))
        return result


# Or just use DP

class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if not matrix: return 0
        m = len(matrix); n = len(matrix[0])
        dp = [[0 for i in range(n)] for j in range(m)]

        def helper(i,j):
            if not dp[i][j]:
                val = matrix[i][j]
                
                dp[i][j] = 1 + max(helper(i + 1, j) if i < m - 1 and val > matrix[i + 1][j] else 0,
                                helper(i - 1, j) if i > 0 and val > matrix[i - 1][j] else 0,
                                helper(i, j + 1) if j < n - 1 and val > matrix[i][j + 1] else 0,
                                helper(i, j - 1) if j > 0 and val > matrix[i][j - 1] else 0)

            return dp[i][j]

        return max(helper(i,j) for i in range(m) for j in range(n))
