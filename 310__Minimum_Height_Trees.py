class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n == 1:
            return [0]
        graph = [set() for _ in range(n)]
        for u, v in edges:
            graph[u].add(v)
            graph[v].add(u)
        leaves = [i for i in range(n) if len(graph[i]) == 1]
        while n > 2:
            n -= len(leaves)
            newLeaves = []
            for i in leaves:
                j = graph[i].pop()
                graph[j].remove(i)
                if len(graph[j]) == 1:
                    newLeaves.append(j)
            leaves = newLeaves
        return leaves
