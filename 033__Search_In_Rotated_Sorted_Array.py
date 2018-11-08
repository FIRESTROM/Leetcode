class Solution(object):
    def search(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    if len(nums) == 0:
        return -1
    if len(nums) == 1:
        if nums[0] == target: return 0
        else: return -1

    left = nums[:len(nums) / 2]
    right = nums[len(nums) / 2:]
    index_right = len(nums) / 2
    # left part is sorted and target is in left
    if left[0] <= target <= left[-1]:
        return self.search(left, target)
    # right part is sorted and target is in right
    elif right[0] <= target <= right[-1]:
        if self.search(right, target) == -1:
            return -1
        return index_right + self.search(right, target)
    # target is in the unsorted part
    else:
        # Check left
        if self.search(left, target) != -1:
            return self.search(left, target)
        # If left do not contain target, check right
        else:
            if self.search(right, target) != -1:
                return index_right + self.search(right, target)
            return -1
