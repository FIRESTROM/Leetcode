# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution(object):
    def closestKValues(self, root, target, k):
        """
        :type root: TreeNode
        :type target: float
        :type k: int
        :rtype: List[int]
        """
        def inorder(root):
            if not root:
                return
            inorder(root.left)
            if len(res) < k:
                res.append(root.val)
            elif abs(res[0] - target) > abs(root.val - target):
                res.popleft()
                res.append(root.val)
            else:
                return
            inorder(root.right)

        res = deque([])
        inorder(root)
        return list(res)
