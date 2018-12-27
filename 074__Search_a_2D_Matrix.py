class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False

        m, n = len(matrix), len(matrix[0])
        start, end = 0, m * n - 1
        while start <= end:
            mid = (start + end) // 2
            i, j = mid // n, mid % n
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] > target:
                end = mid - 1
            else:
                start = mid + 1
        return False
