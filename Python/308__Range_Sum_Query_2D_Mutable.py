class NumMatrix(object):

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        for row in matrix:
            for j in range(1, len(row)):
                row[j] += row[j - 1]
        self.matrix = matrix

    def update(self, row, col, val):
        """
        :type row: int
        :type col: int
        :type val: int
        :rtype: void
        """
        origin = self.matrix[row][col]
        if col != 0:
            origin -= self.matrix[row][col - 1]
        diff = val - origin
        for j in range(col, len(self.matrix[0])):
            self.matrix[row][j] += diff


    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        result = 0
        if col1 != 0:
            for i in range(row1, row2 + 1):
                result += self.matrix[i][col2] - self.matrix[i][col1 - 1]
        else:
            for i in range(row1, row2 + 1):
                result += self.matrix[i][col2]
        return result


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)
