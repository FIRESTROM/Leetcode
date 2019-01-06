class Solution(object):
    def wallsAndGates(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
        if not rooms or not rooms[0]:
            return

        m, n = len(rooms), len(rooms[0])
        direction = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        gates = [[i, j] for i in range(m) for j in range(n) if rooms[i][j] == 0]

        for start in gates:
            queue = [start]
            while queue:
                temp_start = queue.pop()
                row, col = temp_start[0], temp_start[1]
                for d in direction:
                    i, j = row + d[0], col + d[1]
                    if 0 <= i < m and 0 <= j < n and rooms[i][j] > rooms[row][col] + 1:
                        rooms[i][j] = rooms[row][col] + 1
                        queue.append([i, j])
