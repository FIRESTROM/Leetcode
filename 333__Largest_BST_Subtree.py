# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestBSTSubtree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def helper(r):
            if not r.left and not r.right:
                return True, 1, r.val, r.val
            if not r.left:
                check, size, low, high = helper(r.right)
                if check and r.val < low:
                    return True, 1 + size, r.val, high
                return False, size, None, None
            if not r.right:
                check, size, low, high = helper(r.left)
                if check and r.val > high:
                    return True, 1 + size, low, r.val
                return False, size, None, None

            Lcheck, Lsize, Llow, Lhigh = helper(r.left)
            Rcheck, Rsize, Rlow, Rhigh = helper(r.right)
            if Lcheck and Rcheck and Lhigh < r.val < Rlow:
                return True, 1 + Lsize + Rsize, Llow, Rhigh
            return False, max(Lsize, Rsize), None, None
        if not root:
            return 0
        return helper(root)[1]
