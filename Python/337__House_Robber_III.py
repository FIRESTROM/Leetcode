# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # the value in the couple is (yesrob, norob)
        # yesrob is the max amount with robbing the current node
        # norob is the max amount without robbing the current node

        def helper(root):
            if root is None:
                return (0, 0)
            left = helper(root.left)
            right = helper(root.right)
            return (left[1] + right[1] + root.val, max(left) + max(right))

        return max(helper(root))
