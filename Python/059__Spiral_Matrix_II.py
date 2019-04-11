class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        val = 0
        result = [[0] * n for _ in range(n)]
        direct = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        i, j = 0, -1
        cur_dir = 0
        while val < n * n:
            val += 1
            next_i, next_j = i + direct[cur_dir][0], j + direct[cur_dir][1]
            if 0 <= next_i < n and 0 <= next_j < n and result[next_i][next_j] == 0:
                result[next_i][next_j] = val
            else:
                cur_dir = (cur_dir + 1) % 4
                next_i, next_j = i + direct[cur_dir][0], j + direct[cur_dir][1]
                result[next_i][next_j] = val
            i, j = next_i, next_j
        return result
