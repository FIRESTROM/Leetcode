class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if len(board) == 0:
            return

        m, n = len(board), len(board[0])

        visited = [[False] * n for _ in range(m)]

        def bfs(index_i, index_j):
            remove = True
            queue = [[index_i, index_j]]
            list_of_node = [[index_i, index_j]]
            change_i, change_j = [0, 0, 1, -1], [1, -1, 0, 0]
            while queue:
                cur = queue.pop()
                visited[cur[0]][cur[1]] = True
                for i in range(4):
                    temp_i, temp_j = cur[0] + change_i[i], cur[1] + change_j[i]
                    if 0 <= temp_i < m and 0 <= temp_j < n:
                        if board[temp_i][temp_j] == "O" and not visited[temp_i][temp_j]:
                            queue.append([temp_i, temp_j])
                            list_of_node.append([temp_i, temp_j])
                if cur[0] == 0 or cur[0] == m - 1 or cur[1] == 0 or cur[1] == n - 1:
                    remove = False

            return list_of_node, remove

        for i in range(m):
            for j in range(n):
                if board[i][j] == "O" and not visited[i][j]:
                    nodes, remove = bfs(i, j)
                    if remove:
                        for node in nodes:
                            board[node[0]][node[1]] = "X"



# A similar solution but more clear, BFS

class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        queue = collections.deque([])
        for r in xrange(len(board)):
            for c in xrange(len(board[0])):
                if (r in [0, len(board) - 1] or c in [0, len(board[0]) - 1]) and board[r][c] == "O":
                    queue.append((r, c))
        while queue:
            r, c = queue.popleft()
            if 0 <= r < len(board) and 0 <= c < len(board[0]) and board[r][c] == "O":
                board[r][c] = "D"
                queue.append((r - 1, c))
                queue.append((r + 1, c))
                queue.append((r, c - 1))
                queue.append((r, c + 1))

        for r in xrange(len(board)):
            for c in xrange(len(board[0])):
                if board[r][c] == "O":
                    board[r][c] = "X"
                elif board[r][c] == "D":
                    board[r][c] = "O"
