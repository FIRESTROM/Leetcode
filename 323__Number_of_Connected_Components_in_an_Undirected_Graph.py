class Solution(object):
    def countComponents(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        dic = [set() for _ in range(n)]
        visited = [False for _ in range(n)]
        for x,y in edges:
            dic[x].add(y)
            dic[y].add(x)

        def dfs(start):
            for i in dic[start]:
                if not visited[i]:
                    visited[i] = True
                    dfs(i)
        result = 0
        for i in range(n):
            if not visited[i]:
                dfs(i)
                result += 1
        return result
