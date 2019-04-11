class Solution(object):
    def getModifiedArray(self, length, updates):
        """
        :type length: int
        :type updates: List[List[int]]
        :rtype: List[int]
        """
        result = [0] * length
        for start, end, increment in updates:
            result[start] += increment
            if end + 1 < length:
                result[end + 1] -= increment

        current = 0
        for i, val in enumerate(result):
            current += val
            result[i] = current
        return result
