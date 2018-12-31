class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        self.dic = {}
        def helper(s):
            if s in self.dic:
                return self.dic[s]
            if s == 0:
                return 1
            result = 0
            for val in nums:
                if s - val >= 0:
                    result += helper(s - val)
            self.dic[s] = result
            return result

        return helper(target)
        
