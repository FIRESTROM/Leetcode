# Divide and Conquer Solution

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
            return False

        def search_rec(left, up, right, down):

            if left > right or up > down:
                return False
            elif target < matrix[up][left] or target > matrix[down][right]:
                return False

            mid_col = left + (right-left) // 2

            row = up
            while row <= down and matrix[row][mid_col] <= target:
                if matrix[row][mid_col] == target:
                    return True
                row += 1

            return search_rec(left, row, mid_col - 1, down) or search_rec(mid_col + 1, up, right, row - 1)

        return search_rec(0, 0, len(matrix[0]) - 1, len(matrix) - 1)


# Another smarter solution using the property

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False

        row, col = 0, len(matrix[0]) - 1

        while col >= 0 and row < len(matrix):
            if target == matrix[row][col]:
                return True
            elif target < matrix[row][col]:
                col -= 1
            else:
                row += 1
        return False
