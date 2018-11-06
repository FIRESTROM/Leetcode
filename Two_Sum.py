class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        dic = dict()

        for i, val in enumerate(nums):
            if dic.get(target - val) != None:
                return [dic[target - val], i]
            else:
                dic[val] = i
                
        return []
