# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """

        def binary(lst):
            if len(lst) == 0:
                return None
            if len(lst) == 1:
                return TreeNode(lst[0])

            index = len(lst) / 2
            root = TreeNode(lst[index])
            root.left = binary(lst[:index])
            root.right = binary(lst[index + 1:])
            return root

        return binary(nums)
