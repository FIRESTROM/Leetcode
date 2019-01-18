class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if k <= 0 or t < 0 or len(nums) < 2:
            return False

        min_val = min(nums)
        if min_val < 0:
            nums = [n - min_val for n in nums]
            min_val = 0
        max_val = max(nums)
        bucket_dict = {}
        for i, num in enumerate(nums):
            idx = int(num / (t + 1))
            if len(bucket_dict) == k + 1:
                bucket_dict.pop(int(nums[i - k - 1] / (t + 1)))
            if idx in bucket_dict:
                return True
            elif idx - 1 in bucket_dict and num - bucket_dict[idx - 1] <= t:
                return True
            elif idx + 1 in bucket_dict and bucket_dict[idx + 1] - num <= t:
                return True
            else:
                bucket_dict[idx] = num

        return False
