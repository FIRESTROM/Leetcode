class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if len(matrix) == 0:
            return []

        m = len(matrix)
        n = len(matrix[0])

        visited = [[False] * n for _ in range(m)]
        visited_num = 1
        result = [matrix[0][0]]
        visited[0][0] = True
        direct = [0, 1]
        i, j = 0, 0
        while visited_num < m * n:
            if direct == [0, 1]:
                while j + 1 < n and not visited[i][j + 1] :
                    visited[i][j + 1] = True
                    j += 1
                    visited_num += 1
                    result += [matrix[i][j]]
                direct = [1, 0]
            elif direct == [1, 0]:
                while i + 1 < m and not visited[i + 1][j] :
                    visited[i + 1][j] = True
                    i += 1
                    visited_num += 1
                    result += [matrix[i][j]]
                direct = [0, -1]
            elif direct == [0, -1]:
                while j - 1 >= 0 and not visited[i][j - 1]:
                    visited[i][j - 1] = True
                    j -= 1
                    visited_num += 1
                    result += [matrix[i][j]]
                direct = [-1, 0]
            else:
                while i - 1 >= 0 and not visited[i - 1][j]:
                    visited[i - 1][j] = True
                    i -= 1
                    visited_num += 1
                    result += [matrix[i][j]]
                direct = [0, 1]
        return result

        
