# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(root):
            if not root:
                return 0, True

            left = helper(root.left)
            right = helper(root.right)

            return max(left[0], right[0]) + 1, abs(left[0] - right[0]) <= 1 and left[1] and right[1]

        if not root:
            return True

        return helper(root)[1]
