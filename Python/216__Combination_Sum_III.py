class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        def dfs(k, n, path, result, start):
            if k == 0 and n == 0:
                result.append(path[:])
                return
            elif k < 0 or n < 0:
                return
            else:
                for i in range(start, 10):
                    if n - i < 0:
                        break
                    path.append(i)
                    dfs(k - 1, n - i, path, result, i + 1)
                    path.pop()

        result = []
        dfs(k, n, [], result, 1)
        return result
