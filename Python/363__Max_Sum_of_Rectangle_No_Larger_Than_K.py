class Solution(object):
    def maxSumSubmatrix(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        m, n = len(matrix), len(matrix[0])
        result = float("-inf")
        for col1 in range(n):
            sums = [0] * m # sums[i] == row:i, col1 to col2
            for col2 in range(col1, n):
                for i in range(m):
                    sums[i] += matrix[i][col2]
                cur = maxv = float("-inf")
                for s in sums:
                    cur = max(s, cur + s)
                    maxv = max(maxv, cur)
                if maxv <= k:
                    result = max(result, maxv)
                else:
                    for i in range(m):
                        tempsum = 0
                        for j in range(i, m):
                            tempsum += sums[j] # sum(i to j)
                            if tempsum <= k:
                                result = max(result, tempsum)
                                if result == k:
                                    return k
        return result       
