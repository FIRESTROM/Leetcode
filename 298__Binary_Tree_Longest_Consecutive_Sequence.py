# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.maxlength = 0
        def helper(node, parent, length):
            if node is None:
                return
            if parent is not None and node.val == parent.val + 1:
                length += 1
            else:
                length = 1
            self.maxlength = max(self.maxlength, length)
            helper(node.left, node, length)
            helper(node.right, node, length)
        helper(root, None, 0)
        return self.maxlength
