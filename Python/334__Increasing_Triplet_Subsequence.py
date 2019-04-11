class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        prev = []
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                if len(prev) == 0:
                    prev = [nums[i - 1], nums[i]]
                else:
                    if nums[i] > prev[1] or prev[0] < nums[i - 1]:
                        return True
                    else:
                        prev[0] = nums[i - 1]
                        prev[1] = nums[i]
        return False

# Another smart solution : Store the smallest two till now, if one appear that
# is larger than both, then there is a increasing Triplet

class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        a = sys.maxint
        b = sys.maxint

        for n in nums:
            if n <= a:
                a = n
            elif n <= b:
                b = n
            else:
                return True

        return False
