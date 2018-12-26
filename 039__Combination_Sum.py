class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        def dfs(path, cur_sum, start):
            for i in range(start, len(candidates)):
                next_sum = cur_sum + candidates[i]
                if next_sum < target:
                    dfs(path + [candidates[i]], next_sum, i)
                elif next_sum == target:
                    result.append(path + [candidates[i]])
        dfs([], 0, 0)
        return result
