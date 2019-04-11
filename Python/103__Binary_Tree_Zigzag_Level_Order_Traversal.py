# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        queue = [root]
        result = []
        reverse = False
        while queue:
            next = []
            temp = []
            for u in queue:
                if u.left:
                    next.append(u.left)
                if u.right:
                    next.append(u.right)
                temp.append(u.val)
            if not reverse:
                result.append(temp)
            else:
                result.append(temp[::-1])
            queue = next
            reverse = not reverse
        return result
