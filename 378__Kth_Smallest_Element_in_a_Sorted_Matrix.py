class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        def research(value):
            i, j = 0, n - 1
            number = 0
            while i <= n - 1 and j >= 0:
                if matrix[i][j] > value:
                    j -= 1
                if matrix[i][j] <= value:
                    i += 1
                    number += j+1
            return number

        n = len(matrix)
        left = matrix[0][0]
        right = matrix[-1][-1]
        while left < right:
            mid = (left + right) // 2
            mid_count = research(mid)
            if mid_count < k:
                left = mid + 1
            else:
                right = mid
        return left
