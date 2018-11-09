class Solution(object):

    def dfs(self, nums, target, index, path, result):

        for i in range(index, len(nums)):
            if i > index and nums[i] == nums[i-1]:
                continue
            if nums[i] > target:
                break
            if nums[i] == target:
                result.append([nums[i]] + path)
                break
            self.dfs(nums, target - nums[i], i + 1, [nums[i]] + path, result)

    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        result = []
        self.dfs(candidates, target, 0, [], result)
        return result
    
