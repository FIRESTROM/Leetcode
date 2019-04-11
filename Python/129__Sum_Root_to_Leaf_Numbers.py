# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.result = 0
        def dfs(root, value):
            if root:
                dfs(root.left, value * 10 + root.val)
                dfs(root.right, value * 10 + root.val)
                if not root.left and not root.right:
                    self.result += value * 10 + root.val
        dfs(root, 0)
        return self.result
