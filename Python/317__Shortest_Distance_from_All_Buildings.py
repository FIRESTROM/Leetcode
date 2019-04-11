class Solution:
    def shortestDistance(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # for each building 1, run BFS and record for each 0
        # the distance from that building 1
        # the optimal new building spot is the 0 that has least total distance
        m, n = len(grid), len(grid[0])
        buildings = sum(grid[i][j] for i in range(m) for j in range(n) if grid[i][j] == 1)
        distance = collections.defaultdict(list)
        def bfs(start_i, start_j):
            queue = [(start_i, start_j, 0)]
            visited = [[False for _ in range(m)] for _ in range(n)]
            visited[start_i][start_j] = True
            can_reach_count = 0
            while queue:
                i, j, dist = queue.pop()
                # A good bruning is while doing BFS, also visit points with 1 but not put in queue
                # Then check at the end to make sure it can reach all other buildings
                for x, y in [[i + 1, j], [i - 1, j], [i, j + 1], [i, j - 1]]:
                    if 0 <= x < m and 0 <= y < n and not visited[x][y]:
                        visited[x][y] = True
                        if grid[x][y] == 0:
                            distance[(x, y)].append(dist + 1)
                            queue.insert(0, (x, y, dist + 1))
                        elif grid[x][y] == 1:
                            can_reach_count += 1
            return can_reach_count == buildings - 1

        # run BFS on every node where the value is 1
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    if not bfs(i, j):
                        return -1
        result = float("inf")
        for (i, j), distances in distance.items():
            if len(distances) == buildings:
                result = min(result, sum(distances))
        return -1 if result == float("inf") else result
