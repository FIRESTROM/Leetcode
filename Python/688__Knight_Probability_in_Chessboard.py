class Solution:
    def get_points(self, row, col, N):
        result = []
        if row - 2 >= 0 and col - 1 >= 0:
            result += [[row - 2, col - 1]]
        if row - 1 >= 0 and col - 2 >= 0:
            result += [[row - 1, col - 2]]
        if row + 1 < N and col - 2 >= 0:
            result += [[row + 1, col - 2]]
        if row + 2 < N and col - 1 >= 0:
            result += [[row + 2, col - 1]]
        if row + 2 < N and col + 1 < N:
            result += [[row + 2, col + 1]]
        if row + 1 < N and col + 2 < N:
            result += [[row + 1, col + 2]]
        if row - 1 >= 0 and col + 2 < N:
            result += [[row - 1, col + 2]]
        if row - 2 >= 0 and col + 1 < N:
            result += [[row - 2, col + 1]]
        return result

    def transfer_XtoY(self, X, Y):
        for i in range(len(X)):
            for j in range(len(X)):
                Y[i][j] = X[i][j]
        return Y

    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        result = 0.0
        table = [[0 for i in range(N)] for j in range(N)]
        table[r][c] = 1
        temp_table = [[0 for i in range(N)] for j in range(N)]
        for i in range(K):
            temp_table = self.transfer_XtoY(table, temp_table)
            for row in range(N):
                for col in range(N):
                    if (table[row][col] != 0):
                        temp = self.get_points(row, col, N)
                        for pair in temp:
                            temp_table[pair[0]][pair[1]] += table[row][col] / 8.0
                        temp_table[row][col] = 0
            table = self.transfer_XtoY(temp_table, table)

        for row in range(N):
            for col in range(N):
                result += table[row][col]
        return result



        
