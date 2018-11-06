class Solution(object):

    def bfs(self, grid, i, j):

        new_i = [0, 0, 1, -1]
        new_j = [1, -1, 0, 0]
        queue = collections.deque()
        queue.append((i, j))
        max_i, max_j = len(grid), len(grid[0])
        grid[i][j] = '0'

        while len(queue):
            i, j = queue.popleft()
            for k in range(4):
                temp_i, temp_j = i + new_i[k], j + new_j[k]
                if 0 <= temp_i < max_i and 0 <= temp_j < max_j and grid[temp_i][temp_j] == "1":
                    grid[temp_i][temp_j] = "0"
                    queue.append((temp_i, temp_j))



    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        num = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.bfs(grid, i, j)
                    num += 1
        return num
