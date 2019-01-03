# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def closestValue(self, root, target):
        """
        :type root: TreeNode
        :type target: float
        :rtype: int
        """
        self.minval = float("inf")
        def helper(root):
            if root is None:
                return
            if abs(root.val - target) < abs(self.minval - target):
                self.minval = root.val
            if root.val > target:
                helper(root.left)
            elif root.val < target:
                helper(root.right)
        helper(root)
        return self.minval
