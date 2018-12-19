class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        len_m = len(board)
        len_n = len(board[0])

        for m in xrange(len_m):
            for n in xrange(len_n):
                live_neighbor = 0
                for temp_m in xrange(max(0, m - 1), min(len_m - 1, m + 1) + 1):
                    for temp_n in xrange(max(0, n - 1), min(len_n - 1, n + 1) + 1):
                        if (m, n) != (temp_m, temp_n) and (board[temp_m][temp_n] == 1 or board[temp_m][temp_n] == 2):
                            live_neighbor += 1
                if board[m][n] == 1:
                    if live_neighbor < 2 or live_neighbor > 3:
                        board[m][n] = 2
                else:
                    if live_neighbor == 3:
                        board[m][n] = 3

        for m in xrange(len_m):
            for n in xrange(len_n):
                if board[m][n] == 2:
                    board[m][n] = 0
                if board[m][n] == 3:
                    board[m][n] = 1

                    
