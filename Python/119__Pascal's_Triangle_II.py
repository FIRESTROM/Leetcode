class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        if rowIndex == 0:
            return [1]
        if rowIndex == 1:
            return [1, 1]
        result = [1, 1]
        for i in range(rowIndex - 1):
            for j in range(len(result) - 1):
                result[j] += result[j + 1]
            result = [1] + result
        return result
