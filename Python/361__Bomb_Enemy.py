class Solution(object):
    def maxKilledEnemies(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        result = 0
        m, n = len(grid), len(grid[0])
        nums = [[0 for i in range(n)] for j in range(m)]

        for i in range(m):
            row_hits = 0
            for j in range(n):
                if grid[i][j] == "E":
                    row_hits += 1
                elif grid[i][j] == "W":
                    row_hits = 0
                else:
                    nums[i][j] = row_hits

        for i in range(m):
            row_hits = 0
            for j in range(n - 1, -1, -1):
                if grid[i][j] == "E":
                    row_hits += 1
                elif grid[i][j] == "W":
                    row_hits = 0
                else:
                    nums[i][j] += row_hits

        for j in range(n):
            col_hits = 0
            for i in range(m):
                if grid[i][j] == "E":
                    col_hits += 1
                elif grid[i][j] == "W":
                    col_hits = 0
                else:
                    nums[i][j] += col_hits

        for j in range(n):
            col_hits = 0
            for i in range(m - 1, -1, -1):
                if grid[i][j] == "E":
                    col_hits += 1
                elif grid[i][j] == "W":
                    col_hits = 0
                else:
                    nums[i][j] += col_hits
                    result = max(result, nums[i][j])


        return result
