class Solution(object):
    def validTree(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        def findSubset(i):
            if union[i] == -1:
                return i
            else:
                return findSubset(union[i])

        union = [-1] * n
        for edge in edges:
            s1 = findSubset(edge[0])
            s2 = findSubset(edge[1])

            if s1 == s2:
                return False
            else:
                union[s1] = s2
        if len(edges) != n - 1:
            return False
        else:
            return True
            
