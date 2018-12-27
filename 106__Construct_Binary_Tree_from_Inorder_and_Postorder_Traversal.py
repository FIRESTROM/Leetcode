# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if len(inorder) == 0:
            return None
        val = postorder.pop()
        i = inorder.index(val)

        root = TreeNode(val)
        root.right = self.buildTree(inorder[i + 1:], postorder)
        root.left = self.buildTree(inorder[:i], postorder)

        return root
