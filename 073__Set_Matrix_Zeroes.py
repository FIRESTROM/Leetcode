class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if len(matrix) == 0:
            return []
        row, col = {}, {}
        m, n = len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    if i not in row:
                        row[i] = 1
                        for temp_j in range(n):
                            if matrix[i][temp_j] != 0:
                                matrix[i][temp_j] = "."
                    if j not in col:
                        col[j] = 1
                        for temp_i in range(m):
                            if matrix[temp_i][j] != 0:
                                matrix[temp_i][j] = "."
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == ".":
                     matrix[i][j] = 0



# Another solution (Setting first col & row to 0)

class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        is_col = False # Check is there zero in the first column originally
        R = len(matrix)
        C = len(matrix[0])
        for i in range(R):
            if matrix[i][0] == 0:
                is_col = True
            for j in range(1, C):
                if matrix[i][j]  == 0:
                    matrix[0][j] = 0
                    matrix[i][0] = 0


        for i in range(1, R):
            for j in range(1, C):
                if not matrix[i][0] or not matrix[0][j]:
                    matrix[i][j] = 0


        if matrix[0][0] == 0:
            for j in range(C):
                matrix[0][j] = 0

        if is_col:
            for i in range(R):
                matrix[i][0] = 0
