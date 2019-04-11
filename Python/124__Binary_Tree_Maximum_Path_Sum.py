# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        self.max_pathsum = root.val
        self.pathsum(root)
        return self.max_pathsum

    def pathsum(self, root):
        if not root:
            return 0
        left, right = self.pathsum(root.left), self.pathsum(root.right)
        cursum = root.val
        if left > 0:
            cursum += left
        if right > 0:
            cursum += right
        self.max_pathsum = max(self.max_pathsum, cursum)
        return max(root.val, left + root.val, right + root.val)
