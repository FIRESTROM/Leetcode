class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 1:
            return [nums]
        result = []
        pas = []
        for i, num in enumerate(nums):
            if num in pas:
                continue
            pas.append(num)
            result += [j + [num] for j in self.permuteUnique(nums[:i] + nums[i + 1:])]
        return result

# DFS Solution

class Solution:
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        nums.sort()
        cur_path = []
        self.result = []

        self.dfs(cur_path, nums)

        return self.result

    # For collection without duplicates,
    # we can iteratively append a number to n-1 state to get n state
    # While, with dulicates
    # the only difference is to avoid appending same numbers to a same n-1 state
    # This can be achieved by sorting list and skipping iteration when the num[i]==nums[i-1]

    def dfs(self, cur_path, left_nums):

        if left_nums == []:
            self.result.append(exist_seq.copy())
        else:
            prev_val = None
            for i in range(len(left_nums)):
                if left_nums[i] == prev_val:
                    continue
                else:
                    prev_val = left_nums[i]
                    cur_path.append(left_nums.pop(i))
                    self.dfs(exist_seq, left_nums)
                    left_nums.insert(i, cur_path.pop(-1))
					#This line is used to restore the original num collection
