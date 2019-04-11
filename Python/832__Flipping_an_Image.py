class Solution(object):
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        result = []
        for row in A:
            result += [map(lambda i: (i + 1) % 2, row[::-1])]

        return result
