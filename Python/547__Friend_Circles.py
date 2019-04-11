class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        n = len(M)

        visited = [0] * n

        def dfs(i):
            visited[i] = 1

            for j in range(n):
                if visited[j] == 0 and M[i][j] == 1:
                    dfs(j)

        ans = 0
        for i in range(n):
            if not visited[i]:
                ans += 1
                dfs(i)

        return ans
