class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        dic = dict()
        for i in range(len(nums)):
            if nums[i] in dic:
                return True
            dic[nums[i]] = 1
            if len(dic) > k:
                del dic[nums[i - k]]
        return False


# Similar Solution
class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """

        dic = dict()

        for idx, num in enumerate(nums):
            if num not in dic:
                dic[num] = idx
            else:
                idx_old = dic[num]
                if idx - idx_old <= k:
                    return True
                else:
                    dic[num] = idx
        return False
