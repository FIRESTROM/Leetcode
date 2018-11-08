# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def bfs(root, result, height):

            if root.left is None and root.right is None:
                return result

            while len(result) < height + 1:
                result += [[]]

            if root.left is None:
                result[height] += [root.right.val]
                return bfs(root.right, result, height + 1)
            elif root.right is None:
                result[height] += [root.left.val]
                return bfs(root.left, result, height + 1)
            else:
                result[height] += [root.left.val, root.right.val]
                result = bfs(root.left, result, height + 1)
                return bfs(root.right, result, height + 1)

        result = []
        if root != None:
            result += [[root.val]]
            result = bfs(root, result, 1)
        return result
